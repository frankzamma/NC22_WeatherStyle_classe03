package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.algorithms;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.CapoAbbigliamento;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.REPTree;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.filters.Filter;
import weka.filters.supervised.instance.ClassBalancer;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author Raffaele Aurucci, Angelo Palmieri, Annalaura Miglino, Francesco Giuseppe Zammarelli
 * classe che addestra un modello di machine learning attraverso l'utilizzo dell'algoritmo RepTree il quale realizza un
 * albero di regressione.
 * @param <T> tipo della categoria di capo d'abbigliamento, al momento è possibile lavorare solo su Maglie, Pantaloni e
 * Scarpe.
 */
class RegressionTreeAlgorithm<T extends CapoAbbigliamento> implements ImplementorAlgorithm<T> {

    private final REPTree repTree;
    private final Instances fullDataset;

    /**
     * @param pathDatasetFile path del file csv dove sono presenti i dati di training
     */
    public RegressionTreeAlgorithm(String pathDatasetFile) {
        this.repTree = new REPTree();

        // setting min numero d'istanze per i nodi foglia
        repTree.setMinNum(10);

        // caricamento del dataset
        CSVLoader csvLoader = new CSVLoader();
        try {
            csvLoader.setSource(new File(pathDatasetFile));
            fullDataset = csvLoader.getDataSet();

            // setting della variabile dipendente
            fullDataset.setClassIndex(fullDataset.numAttributes() - 1);

            // ten cross validation ha mostrato che l'intero dataset su cui sarà addestrato il modello dà buoni risultati
            // quindi lo addestreremo sull'intero dataset
            testModelWithTenFoldsCrossValidation();
        } catch (IOException e) {
            throw new RuntimeException("File csv non trovato" + e);
        } catch (Exception e) {
            throw new RuntimeException("Problemi nella costruzione del modello [WEKA]" + e);
        }
    }

    /**
     * addestra il modello di machine learning valutandone prestazioni attraverso la ten folds cross validation
     * @throws Exception se non è stato possibile effettuare la validazione
     */
    private void testModelWithTenFoldsCrossValidation() throws Exception {

        // applichiamo 10 folds cross validation
        Evaluation evaluation = new Evaluation(fullDataset);
        evaluation.crossValidateModel(repTree,fullDataset,10,new Random(1));

        // bilanciamento dati di training
        ClassBalancer classBalancer = (ClassBalancer) createClassBalancer(fullDataset);
        Filter.useFilter(fullDataset,classBalancer);

        // addestramento regressore
        repTree.buildClassifier(fullDataset);
    }

    /**
     * filtro si occuperà di ponderare le istanze del dataset sia che vi siano variabili numeriche che nominali
     * in modo che abbiano lo stesso peso, facendo undersampling e oversampling
     */
    private Filter createClassBalancer(Instances trainingSet) throws Exception {
        ClassBalancer classBalancer = new ClassBalancer();
        classBalancer.setInputFormat(trainingSet);
        return classBalancer;
    }

    /**
     * metodo che stipola il punteggio di una istanza del tipo della classe
     * @param capoAbbigliamento un capo d'abbigliamento del tipo della classe
     * @param meteoDaily informazioni meteorologiche
     * @return un oggetto che incapsula il capo d'abbigliamento con il relativo punteggio
     */
    private ScoreCapoAbbigliamento classifyInstance(T capoAbbigliamento, MeteoDaily meteoDaily) {

        Instance instance = new DenseInstance(capoAbbigliamento.getClass() != Scarpe.class ? 7 : 8);
        instance.setDataset(fullDataset);

        if (capoAbbigliamento.getClass() == Maglia.class) {
            instance.setValue(1, ((Maglia) capoAbbigliamento).getColore());
            instance.setValue(2, ((Maglia) capoAbbigliamento).getLunghezzaManica());
            instance.setValue(0, ((Maglia) capoAbbigliamento).getMateriale());
            instance.setValue(3, ((Maglia) capoAbbigliamento).getStagione());
            instance.setValue(4, meteoDaily.getMeteo());
            instance.setValue(5, meteoDaily.getTemperatura());
            instance.setValue(6, meteoDaily.getStagionePrevisione());
        }

        if (capoAbbigliamento.getClass() == Pantaloni.class) {
            instance.setValue(1,((Pantaloni) capoAbbigliamento).getColore());
            instance.setValue(2,((Pantaloni) capoAbbigliamento).getLunghezza());
            instance.setValue(0,((Pantaloni) capoAbbigliamento).getMateriale());
            instance.setValue(3,((Pantaloni) capoAbbigliamento).getStagione());
            instance.setValue(4,meteoDaily.getMeteo());
            instance.setValue(5,meteoDaily.getTemperatura());
            instance.setValue(6,meteoDaily.getStagionePrevisione());
        }

        if (capoAbbigliamento.getClass() == Scarpe.class) {
            Scarpe scarpe = (Scarpe) capoAbbigliamento;
            instance.setValue(0,scarpe.getTipo().toLowerCase());
            instance.setValue(1,scarpe.isAntiscivolo() ? 'y' : 'n');
            instance.setValue(2,scarpe.isImpermeabile() ? 'y' : 'n');
            instance.setValue(3,scarpe.getColore().toLowerCase());
            instance.setValue(4,scarpe.getStagione());
            instance.setValue(5,meteoDaily.getMeteo());
            instance.setValue(6,meteoDaily.getTemperatura());
            instance.setValue(7,meteoDaily.getStagionePrevisione());
        }

        ScoreCapoAbbigliamento scoreCapoAbbigliamento;
        try {
            double predict = repTree.classifyInstance(instance);
            scoreCapoAbbigliamento = new ScoreCapoAbbigliamento(capoAbbigliamento,predict);
        } catch (Exception e) {
            throw new RuntimeException("Predict blocked");
        }

        return scoreCapoAbbigliamento;
    }

    /**
     * metodo che restitusice una lista dei tre capi migliori rispetto alla lista dei capi della categoria della classe
     * @param capoAbbigliamentoList lista di capi della categoria della classe
     * @param meteoDaily informazioni meteorologiche
     * @return lista dei tre capi migliori del tipo della classe
     */
    @Override
    public List<T> getBestThreeCapoAbbigliamento(List<T> capoAbbigliamentoList,MeteoDaily meteoDaily) {

        List<ScoreCapoAbbigliamento> scoreCapoAbbigliamentoList = new ArrayList<>();

        for (T capoAbbigliamento: capoAbbigliamentoList)
            scoreCapoAbbigliamentoList.add(classifyInstance(capoAbbigliamento,meteoDaily));


        List<ScoreCapoAbbigliamento> bests = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            ScoreCapoAbbigliamento scoreCapoAbbigliamentoMax = Collections.max(scoreCapoAbbigliamentoList,
            (o1,o2) -> o1.getPunteggio().compareTo(o2.getPunteggio()));
            bests.add(scoreCapoAbbigliamentoMax);
            scoreCapoAbbigliamentoList.remove(scoreCapoAbbigliamentoMax);
        }

        List<T> bestList = new ArrayList<>();

        bestList.add((bests.get(0).getCapoAbbigliamento()));
        bestList.add((bests.get(1).getCapoAbbigliamento()));
        bestList.add((bests.get(2).getCapoAbbigliamento()));

        return bestList;
    }

    /**
     * classe privata che incapsula un capo d'abbigliamento del tipo della classe e il punteggio ottenuto
     */
    private class ScoreCapoAbbigliamento {

        private T capoAbbigliamento;
        private Double punteggio;

        public ScoreCapoAbbigliamento(T capoAbbigliamento,Double punteggio) {
            this.capoAbbigliamento = capoAbbigliamento;
            this.punteggio = punteggio;
        }

        public T getCapoAbbigliamento() {
            return capoAbbigliamento;
        }

        public void setCapoAbbigliamento(T capoAbbigliamento) {
            this.capoAbbigliamento = capoAbbigliamento;
        }

        public Double getPunteggio() {
            return punteggio;
        }

        public void setPunteggio(Double punteggio) {
            this.punteggio = punteggio;
        }
    }
}
