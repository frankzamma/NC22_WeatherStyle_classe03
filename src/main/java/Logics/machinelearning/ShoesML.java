package Logics.machinelearning;


import Model.MeteoInformation;
import Model.Scarpa;
import Model.ScoreCapoAbbigliamento;

import java.util.List;

public class ShoesML {
    private RegressionTreeWrapper treeWrapper;

    public ShoesML(String pathDataset){
        //Creazione e allenamento del regressore
        treeWrapper =
                new RegressionTreeWrapper(pathDataset,false, true, "ScarpeML");
    }

    public List<ScoreCapoAbbigliamento> classifyIstances(List<Scarpa> list, MeteoInformation meteoInformation, boolean getBestThree){
        List<ScoreCapoAbbigliamento> l = treeWrapper.classifyInstances(list, meteoInformation);

        if(getBestThree){
            return treeWrapper.getBestThreeClothes(l);
        }else{
            return l;
        }
    }




}
