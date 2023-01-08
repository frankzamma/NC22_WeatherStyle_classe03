package Logic.machinelearning;

import Model.CapoAbbigliamento;
import Model.MeteoInformation;
import Model.ScoreCapoAbbigliamento;

import java.util.List;

public class TopML {

    private RegressionTreeWrapper treeWrapper;

    public TopML(String pathDataset){
        //creazione e allenamento albero di regressione sulle maglie
        treeWrapper = new RegressionTreeWrapper(pathDataset, false, false);
    }

    public List<ScoreCapoAbbigliamento> classifyInstances(List<CapoAbbigliamento> list, MeteoInformation meteo, String stagione, boolean getBestThree){
        List<ScoreCapoAbbigliamento> l = treeWrapper.classifyInstances(list, meteo, stagione);
        if(getBestThree)
            return treeWrapper.getBestThreeClothes(l);
        else
            return l;

    }
}
