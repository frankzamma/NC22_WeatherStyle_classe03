package Logics.machinelearning;

import Model.*;
import Model.ScoreCapoAbbigliamentoLegacy;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.REPTree;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.filters.Filter;
import weka.filters.supervised.instance.ClassBalancer;
import weka.filters.unsupervised.instance.Randomize;
import weka.filters.unsupervised.instance.RemovePercentage;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class RegressionTreeWrapper {

    private REPTree repTree;
    private Instances fullDataset;
    private Evaluation evaluation;

    private String modelName;

    public RegressionTreeWrapper(String pathDatasetFile,Boolean buildWithTrainingSetAndTestSet,boolean balanceDate,String modelName) {
        this.modelName =  modelName;
        repTree = new REPTree();

        // setting min numero d'istanze per i nodi foglia
        repTree.setMinNum(10);

        // caricamento del dataset
        CSVLoader csvLoader = new CSVLoader();
        try {
            csvLoader.setSource(new File(pathDatasetFile));
            fullDataset = csvLoader.getDataSet();

            // stampa del dataset
            //System.out.println(fullDataset.toString());

            // setting della variabile dipendente
            fullDataset.setClassIndex(fullDataset.numAttributes() - 1);

            // ten cross validation ha mostrato che l'intero dataset su cui sarà addestrato il modello dà buoni risultati
            // quindi è preferibile addestrarlo sull'intero dataset e non su una parte di esso
            if (buildWithTrainingSetAndTestSet) {
                testModelWithTrainingSetAndTestSet(67,33,balanceDate);
            } else {
                testModelWithTenFoldsCrossValidation(balanceDate);
            }
        } catch (IOException e) {
            throw new RuntimeException("File csv non trovato" + e);
        } catch (Exception e) {
            throw new RuntimeException("Problemi nella costruzione del modello [WEKA]" + e);
        }

    }

    private void testModelWithTrainingSetAndTestSet(double percentTrain,double percentTest,boolean balanceDate) throws Exception {

        // randomizza fullDataset
        Randomize randomize = new Randomize();
        randomize.setInputFormat(fullDataset);
        fullDataset = Filter.useFilter(fullDataset,randomize);

        // ottiene il training set dal 67% del fullDataset
        RemovePercentage removePercentage = new RemovePercentage();
        removePercentage.setPercentage(percentTrain);
        removePercentage.setInputFormat(fullDataset);
        Instances trainingSet = Filter.useFilter(fullDataset,removePercentage);
        trainingSet.setClassIndex(trainingSet.numAttributes() - 1);

        // ottiene il test set dal 33% del fullDataset
        removePercentage.setInvertSelection(true);
        removePercentage.setPercentage(percentTest);
        removePercentage.setInputFormat(fullDataset);
        Instances testSet = Filter.useFilter(fullDataset,removePercentage);
        testSet.setClassIndex(testSet.numAttributes() - 1);

        if (balanceDate) {
            // bilanciamento dati di training
            ClassBalancer classBalancer = (ClassBalancer) createClassBalancer(trainingSet);
            Filter.useFilter(trainingSet,classBalancer);
        }
        // addestramento regressore
        repTree.buildClassifier(trainingSet);

        // valutazione metriche
        evaluation = new Evaluation(trainingSet);
        evaluation.evaluateModel(repTree,testSet);

        // output valutazioni
        System.out.println(modelName + " valutato con Training Set (" + percentTrain + ")%" + "e Test Set ("
                + percentTest + "%):\n" + evaluation.toSummaryString());
    }

    private void testModelWithTenFoldsCrossValidation(boolean balanceDate) throws Exception {

        // valutiamo quanto buono sarà il regressore mediante 10 folds cross validation
        evaluation = new Evaluation(fullDataset);
        evaluation.crossValidateModel(repTree,fullDataset,10,new Random(1));

        // bilanciamento dati di training
        if (balanceDate) {
            ClassBalancer classBalancer = (ClassBalancer) createClassBalancer(fullDataset);
            Filter.useFilter(fullDataset,classBalancer);
        }

        // output valutazioni
        System.out.println(modelName + " addestrato.\nValutazione con Ten Folds Cross Validation:" + evaluation.toSummaryString());

        // addestramento regressore
        repTree.buildClassifier(fullDataset);
    }

    // il filtro si occuperà di ponderare le istanze del dataset sia che vi siano variabili numeriche che nominali
    // in modo che abbiano lo stesso peso, facendo undersampling e oversampling
    private Filter createClassBalancer(Instances trainingSet) throws Exception {
        ClassBalancer classBalancer = new ClassBalancer();
        classBalancer.setInputFormat(trainingSet);
        return classBalancer;
    }


    public String getEvaluation() {
        return (evaluation != null) ? evaluation.toSummaryString() : "null";
    }


    public List<ScoreCapoAbbigliamentoLegacy> classifyInstances(List<? extends CapoAbbigliamentoLegacy> capoAbbigliamentoList,
                                                                MeteoInformationLegacy meteoInformation) {
        List<Instance> listInstance = new ArrayList<>();

        for (CapoAbbigliamentoLegacy capoAbbigliamentoLegacy : capoAbbigliamentoList) {
            Instance instance = new DenseInstance(capoAbbigliamentoLegacy.getClass() != ScarpaLegacy.class ? 7 : 8);
            instance.setDataset(fullDataset);
            if (capoAbbigliamentoLegacy.getClass() == MagliaLegacy.class || capoAbbigliamentoLegacy.getClass() == PantaloniLegacy.class) {
                instance.setValue(1, capoAbbigliamentoLegacy.getColore());

                if (capoAbbigliamentoLegacy.getClass() == MagliaLegacy.class) {
                    instance.setValue(2,((MagliaLegacy) capoAbbigliamentoLegacy).getLunghezzaManica());
                    instance.setValue(0,((MagliaLegacy) capoAbbigliamentoLegacy).getMateriale());
                }
                else {
                    instance.setValue(2,((PantaloniLegacy) capoAbbigliamentoLegacy).getLunghezza());
                    instance.setValue(0,((PantaloniLegacy) capoAbbigliamentoLegacy).getMateriale());
                }

                instance.setValue(3, capoAbbigliamentoLegacy.getStagione());
                instance.setValue(4,meteoInformation.getMeteo());
                instance.setValue(5,meteoInformation.getTemperaturaPercepita());
                instance.setValue(6,meteoInformation.getStagionePrevisione());
            } else {
                ScarpaLegacy scarpa = (ScarpaLegacy) capoAbbigliamentoLegacy;

                instance.setValue(0,scarpa.getTipo().toLowerCase());
                instance.setValue(1,scarpa.getAntiscivolo() ? 'y' : 'n');
                instance.setValue(2,scarpa.getImpermeabile() ? 'y' : 'n');
                instance.setValue(3,scarpa.getColore().toLowerCase());
                instance.setValue(4,scarpa.getStagione());
                instance.setValue(5,meteoInformation.getMeteo());
                instance.setValue(6,meteoInformation.getTemperaturaPercepita());
                instance.setValue(7,meteoInformation.getStagionePrevisione());
            }

            listInstance.add(instance);
        }

        List<ScoreCapoAbbigliamentoLegacy> scoreCapoAbbigliamentoList = new ArrayList<>();

        int i = 0;
        for (Instance instance: listInstance) {
            try {
                double predict = repTree.classifyInstance(instance);
                ScoreCapoAbbigliamentoLegacy scoreCapoAbbigliamentoLegacy = new ScoreCapoAbbigliamentoLegacy(capoAbbigliamentoList.get(i),predict);
                scoreCapoAbbigliamentoList.add(scoreCapoAbbigliamentoLegacy);
                i++;

                System.out.println("Valutata istanza:" + scoreCapoAbbigliamentoLegacy);
            } catch (Exception e) {
                throw new RuntimeException("Predict blocked on " + i + "instance" + e);
            }

        }

        return scoreCapoAbbigliamentoList;
    }

    public List<ScoreCapoAbbigliamentoLegacy> getBestThreeClothes(List<ScoreCapoAbbigliamentoLegacy> scoreCapoAbbigliamentoList) {
        List<ScoreCapoAbbigliamentoLegacy> bests = new ArrayList<>();
        Comparatore comparatore = new Comparatore();

        for (int i = 0; i < 3; i++) {
            ScoreCapoAbbigliamentoLegacy scoreCapoAbbigliamentoMax = Collections.max(scoreCapoAbbigliamentoList,comparatore);
            bests.add(scoreCapoAbbigliamentoMax);
            scoreCapoAbbigliamentoList.remove(scoreCapoAbbigliamentoMax);
        }
        return bests;
    }

    private static class Comparatore implements Comparator<ScoreCapoAbbigliamentoLegacy>{
        @Override
        public int compare(ScoreCapoAbbigliamentoLegacy o1, ScoreCapoAbbigliamentoLegacy o2) {
            return o1.getPunteggio().compareTo(o2.getPunteggio());
        }
    }

}
