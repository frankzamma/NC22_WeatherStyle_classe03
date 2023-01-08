package Logic.machinelearning;

import Model.CapoAbbigliamento;
import Model.MeteoInformation;
import Model.ScoreCapoAbbigliamento;

import java.util.List;

public class BottomML {

    private RegressionTreeWrapper treeWrapper;

    public BottomML(){
        //Si crea e si addestra il l'albero di regressione
        treeWrapper = new RegressionTreeWrapper("CreazioneDataset/newCsv_all_clothes/bottom_meteo_dataset_labeled",
                false, false);
    }

    public List<ScoreCapoAbbigliamento> classifyInstances(List<CapoAbbigliamento> list, MeteoInformation meteo, String stagione, boolean getBestThree){
        List<ScoreCapoAbbigliamento> scoreCapoAbbigliamentoList = treeWrapper.classifyInstances(list, meteo, stagione);
        if(getBestThree)
            return treeWrapper.getBestThreeClothes(scoreCapoAbbigliamentoList);
        else
            return scoreCapoAbbigliamentoList;
    }
}
