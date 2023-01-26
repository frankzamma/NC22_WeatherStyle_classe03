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

    private final SuggerimentoDAOInterface suggerimentoDAO;
    private final OutfitDAOInterface outfitDAO;

    public SuggerimentoLogicService(SuggerimentoDAOInterface suggerimentoDAO, OutfitDAOInterface outfitDAO){
        this.suggerimentoDAO = suggerimentoDAO;
        this.outfitDAO = outfitDAO;
    }

    /**
     * @param suggerimento il suggerimento che si vuole salvare nel DB
     * @throws IllegalArgumentException
     * if (suggerimento == null || (suggerimento.getUtente().getId() == null
     *          || suggerimento.getCitta().getId() == null
     *          || suggerimento.getOutfit().getId() == null
     *          || suggerimento.getMeteoDaily().getId() == null))
     * @return true se è stato possibile salvare il suggerimento, altrimenti false
     */
    @Override
    public boolean salvaSuggerimento(Suggerimento suggerimento) {
        if (suggerimento == null)
            throw new IllegalArgumentException("Suggerimento non può essere null");
        else
            if (suggerimento.getUtente().getId() == null
                    || suggerimento.getCitta().getId() == null
                    || suggerimento.getOutfit().getId() == null
                    || suggerimento.getMeteoDaily().getId() == null)
                throw new IllegalArgumentException("Suggerimento non ha gli id impostati");

        return suggerimentoDAO.doSaveSuggerimento(suggerimento);
    }

    /**
     *
     * @param idUtente di cui si vuole ottenere i suggerimenti
     * @pre idUtente != null
     * @post foreach suggerimento s : list --> s.getCitta() != null && s.getOutfit() != null
     *                                              && s.getMeteoDaily() != null
     * @return lista di suggerimenti
     */
    @Override
    public List<Suggerimento> ottieniCronologiaSuggerimentiUtente(Integer idUtente) {
        if (idUtente == null)
            throw new IllegalArgumentException("Id utente non può essere null");
        return suggerimentoDAO.doRetrieveCronologiaSuggerimentiByUtenteID(idUtente);
    }


    @Override
    public Set<Set<CapoAbbigliamento>> ottieniSuggerimentiCapi(Guardaroba guardaroba, MeteoDaily meteoDaily) {
        return null;
    }


    /**
     *
     * @param outfit che si vuole salvare nel DB
     * @throws IllegalArgumentException
     * if (outfit == null || (outfit.getMaglia() == null
     *          || outfit.getPantaloni() == null
     *          || outfit.getScarpe() == null))
     * @return true se è stato possibile salvare l'outfit, altrimenti false
     */
    @Override
    public boolean salvaOutfit(Outfit outfit) {
        if (outfit == null)
            throw new IllegalArgumentException("Outfit non può essere null");
        else
            if (outfit.getMaglia() == null
                    || outfit.getPantaloni() == null
                    || outfit.getScarpe() == null)
                throw new IllegalArgumentException("Outfit non contiene maglia, pantaloni o scarpe");
        return outfitDAO.doSaveOutfit(outfit);
    }

}
