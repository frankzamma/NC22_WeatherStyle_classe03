package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.algorithms;

import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;

import java.util.List;

public interface ImplementorAlgorithm<T> {

    List<T> getBestThreeCapoAbbigliamento(List<T> capoAbbigliamentoList, MeteoDaily meteoDaily);
}
