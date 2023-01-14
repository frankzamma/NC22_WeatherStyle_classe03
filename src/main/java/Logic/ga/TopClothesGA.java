package Logic.ga;

import Model.CapoAbbigliamento;
import Model.Maglia;
import Model.MeteoInformation;

import java.util.List;

public class TopClothesGA{
    private GenericGA genericGA;

    public TopClothesGA(List<Maglia> listaMaglie, MeteoInformation meteoInformation){
        genericGA = new GenericGA(listaMaglie, meteoInformation, "maglieGA");
    }

    public List<CapoAbbigliamento> getBestMaglie(){
        System.out.println("Avvio Algoritmo Genetico Maglie");
        List<CapoAbbigliamento> list = genericGA.getBestResult();

        System.out.println(list);
        return list;
    }
}
