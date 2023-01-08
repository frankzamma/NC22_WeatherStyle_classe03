package Logic.machinelearning;

import Model.CapoAbbigliamento;
import Model.MeteoInformation;
import Model.ScoreCapoAbbigliamento;

import java.util.List;

public class TopML {

    private RegressionTreeWrapper treeWrapper;

    public TopML(){
        //creazione e allenamento albero di regressione sulle maglie
        treeWrapper = new RegressionTreeWrapper("CreazioneDataset/newCsv_all_clothes/top_meteo_dataset_labeled", false, false);
    }

    public List<ScoreCapoAbbigliamento> classifyInstances(List<CapoAbbigliamento> list, MeteoInformation meteo, String stagione, boolean getBestThree){
        List<ScoreCapoAbbigliamento> l = treeWrapper.classifyInstances(list, meteo, stagione);
        if(getBestThree)
            return treeWrapper.getBestThreeClothes(l);
        else
            return l;

    }
}
