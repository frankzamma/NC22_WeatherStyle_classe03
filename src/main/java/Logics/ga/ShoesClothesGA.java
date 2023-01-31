package Logics.ga;

import Model.CapoAbbigliamentoLegacy;
import Model.MeteoInformationLegacy;
import Model.ScarpaLegacy;

import java.util.List;

public class ShoesClothesGA{
    private GenericGA genericGA;

    public ShoesClothesGA(List<ScarpaLegacy> listaScarpe,MeteoInformationLegacy meteoInformation) {
        genericGA = new GenericGA(listaScarpe,meteoInformation,"scarpeGA");
    }

    public List<CapoAbbigliamentoLegacy> getBestScarpe() {
        System.out.println("Avvio Algoritmo Genetico Scarpe");
        List<CapoAbbigliamentoLegacy> list = genericGA.getBestResult();

        System.out.println(list);
        return list;
    }
}
