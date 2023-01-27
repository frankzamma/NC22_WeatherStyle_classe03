package Logics.machinelearning;


import Model.MeteoInformationLegacy;
import Model.PantaloniLegacy;
import Model.ScoreCapoAbbigliamentoLegacy;

import java.util.List;

public class BottomML {

    private RegressionTreeWrapper treeWrapper;

    public BottomML(String pathDataset) {
        //Si crea e si addestra il l'albero di regressione
        treeWrapper = new RegressionTreeWrapper(pathDataset,false,true,"PantaloniML");
    }

    public List<ScoreCapoAbbigliamentoLegacy> classifyInstances(List<PantaloniLegacy> list, MeteoInformationLegacy meteo, boolean getBestThree) {
        List<ScoreCapoAbbigliamentoLegacy> scoreCapoAbbigliamentoList = treeWrapper.classifyInstances(list,meteo);
        if (getBestThree) {
            return treeWrapper.getBestThreeClothes(scoreCapoAbbigliamentoList);
        } else {
            return scoreCapoAbbigliamentoList;
        }
    }
}
