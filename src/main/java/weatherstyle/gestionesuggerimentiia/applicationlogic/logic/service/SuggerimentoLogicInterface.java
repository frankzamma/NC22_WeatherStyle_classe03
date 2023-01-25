package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.service;

import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Outfit;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Suggerimento;

import java.util.List;

public interface SuggerimentoLogicInterface {

    boolean salvaSuggerimento(Suggerimento suggerimento);
    List<Suggerimento> ottieniSuggerimentiUtente(int idUtente);
    Set<Set<CapoAbbigliamento>> ottieniSuggerimentiCapi(Guardaroba guardaroba, MeteoDaily meteoDaily);
    boolean salvaOutfit(Outfit outfit);
    List<Suggerimento> ottieniOutfitDaSuggerimentoID(List<Integer> idSuggerimenti);

}
