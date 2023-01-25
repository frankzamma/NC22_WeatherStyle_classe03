package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.service;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.CapoAbbigliamento;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Guardaroba;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Outfit;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Suggerimento;
import weatherstyle.gestionesuggerimentiia.storage.dao.OutfitDAOInterface;
import weatherstyle.gestionesuggerimentiia.storage.dao.SuggerimentoDAOInterface;

import java.util.List;
import java.util.Set;

public class SuggerimentoLogicService implements SuggerimentoLogicInterface{

    SuggerimentoDAOInterface suggerimentoDAO;
    OutfitDAOInterface outfitDAO;

    public SuggerimentoLogicService(SuggerimentoDAOInterface suggerimentoDAO, OutfitDAOInterface outfitDAO){
        this.suggerimentoDAO = suggerimentoDAO;
        this.outfitDAO = outfitDAO;
    }

    @Override
    public boolean salvaSuggerimento(Suggerimento suggerimento) {
        return false;
    }

    @Override
    public List<Suggerimento> ottieniSuggerimentiUtente(int idUtente) {
        return null;
    }

    @Override
    public Set<Set<CapoAbbigliamento>> ottieniSuggerimentiCapi(Guardaroba guardaroba, MeteoDaily meteoDaily) {
        return null;
    }

    @Override
    public boolean salvaOutfit(Outfit outfit) {
        return false;
    }

    @Override
    public List<Suggerimento> ottieniOutfitDaSuggerimentoID(List<Integer> idSuggerimenti) {
        return null;
    }
}
