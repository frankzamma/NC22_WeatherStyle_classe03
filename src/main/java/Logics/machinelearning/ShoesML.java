package Logics.machinelearning;


import Model.MeteoInformationLegacy;
import Model.ScarpaLegacy;
import Model.ScoreCapoAbbigliamentoLegacy;

import java.util.List;

public class ShoesML {
    private RegressionTreeWrapper treeWrapper;

    public ShoesML(String pathDataset) {
        //Creazione e allenamento del regressore
        treeWrapper =
                new RegressionTreeWrapper(pathDataset,false,true,"ScarpeML");
    }

    public List<ScoreCapoAbbigliamentoLegacy> classifyIstances(List<ScarpaLegacy> list,MeteoInformationLegacy meteoInformation,boolean getBestThree) {
        List<ScoreCapoAbbigliamentoLegacy> l = treeWrapper.classifyInstances(list,meteoInformation);

        if (getBestThree) {
            return treeWrapper.getBestThreeClothes(l);
        } else {
            return l;
        }
    }


}
