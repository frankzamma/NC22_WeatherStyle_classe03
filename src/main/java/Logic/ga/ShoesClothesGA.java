package Logic.ga;

import Model.CapoAbbigliamento;
import Model.MeteoInformation;
import Model.Scarpa;

import java.util.List;

public class ShoesClothesGA{
    private GenericGA genericGA;

    public ShoesClothesGA(List<Scarpa> listaScarpe, MeteoInformation meteoInformation){
        genericGA = new GenericGA(listaScarpe, meteoInformation, "scarpeGA");
    }

    public List<CapoAbbigliamento> getBestScarpe(){
        return genericGA.getBestResult();
    }
}

