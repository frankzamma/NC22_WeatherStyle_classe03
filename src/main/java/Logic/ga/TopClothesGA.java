package Logic.ga;

import Model.CapoAbbigliamento;
import Model.Maglia;
import Model.MeteoInformation;

import java.util.List;

public class TopClothesGA{
    private GenericGA genericGA;

    public TopClothesGA(List<Maglia> listaMaglie, MeteoInformation meteoInformation){
        genericGA = new GenericGA(listaMaglie, meteoInformation);
    }

    public List<CapoAbbigliamento> getBestMaglie(){
        return genericGA.getBestResult();
    }
}
