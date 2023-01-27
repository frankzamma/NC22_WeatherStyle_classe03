package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.algorithms;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.CapoAbbigliamento;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDailyMin;

import java.util.List;

/**
 * @author Raffaele Aurucci
 * interfaccia visibile al Client con la quale è possibile lavorare allo stesso modo su diverse implementazioni.
 * @param <T> tipo della categoria di capo d'abbigliamento, al momento è possibile lavorare solo su Maglie, Pantaloni e
 * Scarpe.
 */
public interface ImplementorAlgorithm<T extends CapoAbbigliamento> {

    List<T> getBestThreeCapoAbbigliamento(List<T> capoAbbigliamentoList, MeteoDailyMin meteoDailyMin);
}
