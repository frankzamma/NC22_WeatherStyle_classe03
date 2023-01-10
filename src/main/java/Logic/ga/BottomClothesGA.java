package Logic.ga;

import Model.CapoAbbigliamento;
import Model.MeteoInformation;
import Model.Pantalone;

import java.util.List;

public class BottomClothesGA{
    private GenericGA genericGA;

    public BottomClothesGA(List<Pantalone> listaPantaloni, MeteoInformation meteoInformation){
        genericGA = new GenericGA(listaPantaloni, meteoInformation);
    }

    public List<CapoAbbigliamento> getBestPantaloni(){
        return genericGA.getBestResult();
    }
}
