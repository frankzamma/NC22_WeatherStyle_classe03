package machine.learning;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.REPTree;
import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.filters.Filter;
import weka.filters.supervised.instance.ClassBalancer;
import weka.filters.unsupervised.instance.Randomize;
import weka.filters.unsupervised.instance.RemovePercentage;

import java.io.File;
import java.util.Random;

public class TopClothesRT {

    public static void main(String[] args) throws Exception {
        REPTree repTree = new REPTree();

        // caricamento del dataset
        CSVLoader csvLoader = new CSVLoader();
        csvLoader.setSource(new File("CreazioneDatasets/newCsv_all_clothes/top_meteo_dataset_selection.csv"));
        Instances dataset = csvLoader.getDataSet();

        // stampa del dataset
        // System.out.println(dataset.toString());

        // setting della variabile dipendente
        dataset.setClassIndex(dataset.numAttributes() - 1);

        // ten cross validation ha mostrato che l'intero dataset su cui sarà addestrato il modello dà buoni risultati
        // quindi scegliamo di addestrarlo sull'intero dataset e non su una parte di esso
        // trainModelWithTrainingSetAndTestSet(repTree, dataset, 67, 33);
        trainModelWithTenCrossValidation(repTree, dataset);
    }

    private static void trainModelWithTrainingSetAndTestSet(REPTree repTree, Instances fullDataset, double percentTrain, double percentTest) throws Exception {

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
        Evaluation evaluation = new Evaluation(trainingSet);
        evaluation.evaluateModel(repTree, testSet);
        System.out.println(evaluation.toSummaryString());
    }

    private static void trainModelWithTenCrossValidation(REPTree repTree, Instances fullDataset) throws Exception {

        // valutiamo quanto buono sarà il regressore mediante 10 folds cross validation
        Evaluation evaluation = new Evaluation(fullDataset);
        evaluation.crossValidateModel(repTree, fullDataset, 10, new Random(1));

        // valutazione metriche
        System.out.println(evaluation.toSummaryString());

        // bilanciamento dati di training
        ClassBalancer classBalancer = (ClassBalancer) createClassBalancer(fullDataset);
        Filter.useFilter(fullDataset, classBalancer);

        // addestramento regressore
        repTree.buildClassifier(fullDataset);
    }

    private static Filter createClassBalancer(Instances trainingSet) throws Exception {
        ClassBalancer classBalancer = new ClassBalancer();
        classBalancer.setInputFormat(trainingSet);
        return classBalancer;
    }
}
