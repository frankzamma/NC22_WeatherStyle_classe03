package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.service;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.CapoAbbigliamento;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Guardaroba;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Outfit;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Suggerimento;

import java.util.List;
import java.util.Set;

public interface SuggerimentoLogicInterface {

    boolean salvaSuggerimento(Suggerimento suggerimento);
    List<Suggerimento> ottieniCronologiaSuggerimentiUtente(int idUtente);
    Set<Set<CapoAbbigliamento>> ottieniSuggerimentiCapi(Guardaroba guardaroba, MeteoDaily meteoDaily);
    boolean salvaOutfit(Outfit outfit);
    List<Suggerimento> ottieniOutfitDaSuggerimentoID(List<Integer> idSuggerimenti);

}
