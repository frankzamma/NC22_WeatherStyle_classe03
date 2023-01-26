package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.service;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.CapoAbbigliamento;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Guardaroba;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.algorithms.ImplementorAlgorithm;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Outfit;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Suggerimento;

import java.util.List;
import java.util.Set;

public interface SuggerimentoLogicInterface {

    boolean salvaSuggerimento(Suggerimento suggerimento);
    List<Suggerimento> ottieniCronologiaSuggerimentiUtente(Integer idUtente);
    public <T> Set<Set<CapoAbbigliamento>> ottieniSuggerimentiCapi(ImplementorAlgorithm<T> implementorAlgorithm,
                                                                   Guardaroba guardaroba, MeteoDaily meteoDaily);
    boolean salvaOutfit(Outfit outfit);

}
