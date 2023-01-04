package machine.learning;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.REPTree;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

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
        System.out.println(dataset.toString());

        // setting della variabile dipendente
        dataset.setClassIndex(dataset.numAttributes() - 1);

        // 10 fold cross validation
        Evaluation evaluation = new Evaluation(dataset);
        evaluation.crossValidateModel(repTree, dataset, 10, new Random(1));

        // stampa della validazione
        System.out.println(evaluation.toSummaryString());

        // addestramento repTree
        repTree.buildClassifier(dataset);
    }
}
