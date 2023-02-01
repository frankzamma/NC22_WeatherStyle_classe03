package Logics.machinelearning;


import Model.MagliaLegacy;
import Model.MeteoInformationLegacy;
import Model.ScoreCapoAbbigliamentoLegacy;

import java.util.List;

public class TopML {

    private RegressionTreeWrapper treeWrapper;

    public TopML(String pathDataset) {
        //creazione e allenamento albero di regressione sulle maglie
        treeWrapper = new RegressionTreeWrapper(pathDataset,false,true,"MaglieML");
    }

    public List<ScoreCapoAbbigliamentoLegacy> classifyInstances(List<MagliaLegacy> list,MeteoInformationLegacy meteo,boolean getBestThree) {
        List<ScoreCapoAbbigliamentoLegacy> l = treeWrapper.classifyInstances(list,meteo);
        if (getBestThree) {
            return treeWrapper.getBestThreeClothes(l);
        } else {
            return l;
        }

    }
}
