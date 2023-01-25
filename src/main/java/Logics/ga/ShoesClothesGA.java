package Logics.ga;

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
        System.out.println("Avvio Algoritmo Genetico Scarpe");
        List<CapoAbbigliamento> list = genericGA.getBestResult();

        System.out.println(list);
        return list;
    }
}

