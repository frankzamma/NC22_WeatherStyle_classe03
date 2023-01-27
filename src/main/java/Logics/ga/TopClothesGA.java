package Logics.ga;

import Model.CapoAbbigliamentoLegacy;
import Model.MagliaLegacy;
import Model.MeteoInformationLegacy;

import java.util.List;

public class TopClothesGA{
    private GenericGA genericGA;

    public TopClothesGA(List<MagliaLegacy> listaMaglie, MeteoInformationLegacy meteoInformation) {
        genericGA = new GenericGA(listaMaglie,meteoInformation,"maglieGA");
    }

    public List<CapoAbbigliamentoLegacy> getBestMaglie() {
        System.out.println("Avvio Algoritmo Genetico Maglie");
        List<CapoAbbigliamentoLegacy> list = genericGA.getBestResult();

        System.out.println(list);
        return list;
    }
}
