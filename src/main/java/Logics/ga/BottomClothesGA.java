package Logics.ga;

import Model.CapoAbbigliamentoLegacy;
import Model.MeteoInformationLegacy;
import Model.PantaloniLegacy;

import java.util.List;

public class BottomClothesGA{
    private GenericGA genericGA;

    public BottomClothesGA(List<PantaloniLegacy> listaPantaloni,MeteoInformationLegacy meteoInformation) {
        genericGA = new GenericGA(listaPantaloni,meteoInformation,"pantaloniGA");
    }

    public List<CapoAbbigliamentoLegacy> getBestPantaloni() {
        System.out.println("Avvio Algoritmo Genetico Pantaloni");
        List<CapoAbbigliamentoLegacy> list = genericGA.getBestResult();

        System.out.println(list);
        return list;
    }
}
