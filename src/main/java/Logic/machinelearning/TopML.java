package Logic.machinelearning;


import Model.Maglia;
import Model.MeteoInformation;
import Model.ScoreCapoAbbigliamento;

import java.util.List;

public class TopML {

    private RegressionTreeWrapper treeWrapper;

    public TopML(String pathDataset){
        //creazione e allenamento albero di regressione sulle maglie
        treeWrapper = new RegressionTreeWrapper(pathDataset, false, true);
    }

    public List<ScoreCapoAbbigliamento> classifyInstances(List<Maglia> list, MeteoInformation meteo, boolean getBestThree){
        List<ScoreCapoAbbigliamento> l = treeWrapper.classifyInstances(list, meteo);
        if(getBestThree)
            return treeWrapper.getBestThreeClothes(l);
        else
            return l;

    }
}
