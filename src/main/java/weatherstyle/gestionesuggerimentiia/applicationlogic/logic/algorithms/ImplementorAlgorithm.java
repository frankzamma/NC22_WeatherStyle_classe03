package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.algorithms;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.CapoAbbigliamento;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;

import java.util.List;

public interface ImplementorAlgorithm<T extends CapoAbbigliamento> {

    List<T> getBestThreeCapoAbbigliamento(List<T> capoAbbigliamentoList,MeteoDaily meteoDaily);
}
