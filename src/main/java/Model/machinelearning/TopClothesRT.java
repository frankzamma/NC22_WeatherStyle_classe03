package Model.machinelearning;

import Model.Maglia;
import Model.MeteoInformation;
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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TopClothesRT {

    private final REPTree repTree;
    private Instances fullDataset;
    private Evaluation evaluation;

    public TopClothesRT(String pathDatasetFile, String pathOutputFile, Boolean buildWithTrainingSetAndTestSet) throws Exception {
        repTree = new REPTree();

        // caricamento del dataset
        CSVLoader csvLoader = new CSVLoader();
        csvLoader.setSource(new File(pathDatasetFile));
        fullDataset = csvLoader.getDataSet();

        // stampa del dataset
        // System.out.println(dataset.toString());

        // setting della variabile dipendente
        fullDataset.setClassIndex(fullDataset.numAttributes()-1);

        // ten cross validation ha mostrato che l'intero dataset su cui sarà addestrato il modello dà buoni risultati
        // quindi è preferibile addestrarlo sull'intero dataset e non su una parte di esso
        if(buildWithTrainingSetAndTestSet)
            buildModelWithTrainingSetAndTestSet(67, 33, pathOutputFile);
        else
            buildModelWithTenFoldsCrossValidation(pathOutputFile);
    }

    private void buildModelWithTrainingSetAndTestSet(double percentTrain, double percentTest, String pathOutputFile) throws Exception {

        // randomizza fullDataset
        Randomize randomize = new Randomize();
        randomize.setInputFormat(fullDataset);
        fullDataset = Filter.useFilter(fullDataset, randomize);

        // ottiene il training set dal 67% del fullDataset
        RemovePercentage removePercentage = new RemovePercentage();
        removePercentage.setPercentage(percentTrain);
        removePercentage.setInputFormat(fullDataset);
        Instances trainingSet = Filter.useFilter(fullDataset, removePercentage);
        trainingSet.setClassIndex(trainingSet.numAttributes() -1);

        // ottiene il test set dal 33% del fullDataset
        removePercentage.setInvertSelection(true);
        removePercentage.setPercentage(percentTest);
        removePercentage.setInputFormat(fullDataset);
        Instances testSet = Filter.useFilter(fullDataset, removePercentage);
        testSet.setClassIndex(testSet.numAttributes() -1);

        // bilanciamento dati di training
        ClassBalancer classBalancer = (ClassBalancer) createClassBalancer(trainingSet);
        Filter.useFilter(trainingSet, classBalancer);

        // addestramento regressore
        repTree.buildClassifier(trainingSet);

        // valutazione metriche
        evaluation = new Evaluation(trainingSet);
        evaluation.evaluateModel(repTree, testSet);

        // output valutazioni
        File evaluateOutputFile = new File(pathOutputFile);
        PrintWriter printWriter = new PrintWriter(evaluateOutputFile);
        printWriter.write("TopClothesRT evaluate with Training Set (" + percentTrain + ")%" + "and Test Set (" +
                percentTest + "%):\n" + evaluation.toSummaryString());
        printWriter.flush();
    }

    private void buildModelWithTenFoldsCrossValidation(String pathOutputFile) throws Exception {

        // valutiamo quanto buono sarà il regressore mediante 10 folds cross validation
        evaluation = new Evaluation(fullDataset);
        evaluation.crossValidateModel(repTree, fullDataset, 10, new Random(1));

        // output valutazioni
        File evaluateOutputFile = new File(pathOutputFile);
        PrintWriter printWriter = new PrintWriter(evaluateOutputFile);
        printWriter.write("TopClothesRT evaluate with Ten Folds Cross Validation:\n"+ evaluation.toSummaryString());
        printWriter.flush();

        // bilanciamento dati di training
        ClassBalancer classBalancer = (ClassBalancer) createClassBalancer(fullDataset);
        Filter.useFilter(fullDataset, classBalancer);

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


    public String getEvaluation(){
        return (evaluation != null) ? evaluation.toSummaryString(): "null";
    }


    public List<ScoreMaglia> classifyInstances(List<Maglia> magliaList, MeteoInformation meteoInformation, String stagione) throws Exception {
        List<Instance> listInstance = new ArrayList<>();

        for (Maglia maglia: magliaList){
            Instance instance = new DenseInstance(7);
            instance.setDataset(fullDataset);
            instance.setValue(0, maglia.getMateriale());
            instance.setValue(1, maglia.getColore());
            instance.setValue(2, maglia.getLunghezzaManica());
            instance.setValue(3, maglia.getStagione());
            instance.setValue(4, meteoInformation.getMeteo());
            instance.setValue(5, meteoInformation.getTemperaturaPercepita());
            instance.setValue(6, stagione);
            listInstance.add(instance);
        }

        List<ScoreMaglia> scoreMagliaList = new ArrayList<>();

        int i = 0;
        for(Instance instance: listInstance) {
            double predict = repTree.classifyInstance(instance);
            ScoreMaglia scoreMaglia = new ScoreMaglia(magliaList.get(i), predict);
            scoreMagliaList.add(scoreMaglia);
            i++;
        }

        return scoreMagliaList;
    }

    public List<Maglia> getTopThreeClothes(List<ScoreMaglia> scoreMagliaList){
        return new ArrayList<>();
    }


}
