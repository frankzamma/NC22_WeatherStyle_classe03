package Logic.machinelearning;


import Model.MeteoInformation;
import Model.Pantalone;
import Model.ScoreCapoAbbigliamento;

import java.util.List;

public class BottomML {

    private RegressionTreeWrapper treeWrapper;

    public BottomML(String pathDataset){
        //Si crea e si addestra il l'albero di regressione
        treeWrapper = new RegressionTreeWrapper(pathDataset,false, false);
    }

    public List<ScoreCapoAbbigliamento> classifyInstances(List<Pantalone> list, MeteoInformation meteo, String stagione, boolean getBestThree){
        List<ScoreCapoAbbigliamento> scoreCapoAbbigliamentoList = treeWrapper.classifyInstances(list, meteo, stagione);
        if(getBestThree)
            return treeWrapper.getBestThreeClothes(scoreCapoAbbigliamentoList);
        else
            return scoreCapoAbbigliamentoList;
    }
}
