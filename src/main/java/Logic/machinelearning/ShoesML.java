package Logic.machinelearning;

import Model.CapoAbbigliamento;
import Model.MeteoInformation;
import Model.ScoreCapoAbbigliamento;

import java.util.List;

public class ShoesML {
    private RegressionTreeWrapper treeWrapper;

    public ShoesML(){
        //Creazione e allenamento del regressore
        treeWrapper =
                new RegressionTreeWrapper(
                        "CreazioneDatasets/newCsv_all_clothes/shoes_meteo_dataset_labeled.csv",
                        false, false);
    }

    public List<ScoreCapoAbbigliamento> classifyIstances(List<CapoAbbigliamento> list, MeteoInformation meteoInformation,
                                                         String stagione, boolean getBestThree){
        List<ScoreCapoAbbigliamento> l = treeWrapper.classifyInstances(list, meteoInformation, stagione);

        if(getBestThree){
            return treeWrapper.getBestThreeTopClothes(l);
        }else{
            return l;
        }
    }




}
