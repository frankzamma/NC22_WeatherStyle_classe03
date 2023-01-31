package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.service;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.CapoAbbigliamento;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDailyMin;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.algorithms.ImplementorAlgorithm;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Outfit;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Suggerimento;

import java.util.List;

/**
 * @author Raffaele Aurucci
 * interfaccia che definisce i servizi offerti dal package gestionesuggerimentiia
 */
public interface SuggerimentoLogicService {

    boolean salvaSuggerimento(Suggerimento suggerimento);
    List<Suggerimento> ottieniCronologiaSuggerimentiUtente(Integer idUtente);
    <T extends CapoAbbigliamento> List<T> ottieniSuggerimentiCapi(ImplementorAlgorithm<T> implementorAlgorithm,
                                                                  List<T> capiAbbigliamento,
                                                                  MeteoDailyMin meteoDailyMin);
    Outfit ottieniOutfitDaSuggerimento(Suggerimento suggerimento);

}
