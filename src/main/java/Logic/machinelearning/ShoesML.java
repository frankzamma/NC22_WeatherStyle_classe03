package Logic.machinelearning;


import Model.MeteoInformation;
import Model.Scarpa;
import Model.ScoreCapoAbbigliamento;

import java.util.List;

public class ShoesML {
    private RegressionTreeWrapper treeWrapper;

    public ShoesML(String pathDataset){
        //Creazione e allenamento del regressore
        treeWrapper =
                new RegressionTreeWrapper(pathDataset,false, false);
    }

    public List<ScoreCapoAbbigliamento> classifyIstances(List<Scarpa> list, MeteoInformation meteoInformation,
                                                         String stagione, boolean getBestThree){
        List<ScoreCapoAbbigliamento> l = treeWrapper.classifyInstances(list, meteoInformation, stagione);

        if(getBestThree){
            return treeWrapper.getBestThreeClothes(l);
        }else{
            return l;
        }
    }




}
