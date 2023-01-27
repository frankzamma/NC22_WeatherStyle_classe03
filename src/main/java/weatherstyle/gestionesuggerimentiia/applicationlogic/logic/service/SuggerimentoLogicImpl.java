package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.service;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.CapoAbbigliamento;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDailyMin;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.algorithms.ImplementorAlgorithm;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Outfit;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Suggerimento;
import weatherstyle.gestionesuggerimentiia.storage.dao.OutfitDAOInterface;
import weatherstyle.gestionesuggerimentiia.storage.dao.SuggerimentoDAOInterface;

import java.util.List;

/**
 * @author Raffaele Aurucci
 * classe che definisce tutti i servizi offerti alle servlet in merito ai Suggerimenti
 */
public class SuggerimentoLogicImpl implements SuggerimentoLogicService {

    private final SuggerimentoDAOInterface suggerimentoDAO;
    private final OutfitDAOInterface outfitDAO;

    public SuggerimentoLogicImpl(SuggerimentoDAOInterface suggerimentoDAO, OutfitDAOInterface outfitDAO) {
        this.suggerimentoDAO = suggerimentoDAO;
        this.outfitDAO = outfitDAO;
    }

    /**
     * @param suggerimento il suggerimento che si vuole salvare nel DB
     * @throws IllegalArgumentException se suggerimento è null oppure non ha settato tutti gli id degli elementi al suo
     * interno
     * @return true se è stato possibile salvare il suggerimento, altrimenti false
     */
    @Override
    public boolean salvaSuggerimento(Suggerimento suggerimento) {
        if (suggerimento == null) {
            throw new IllegalArgumentException("Suggerimento non può essere null");
        } else
            if (suggerimento.getUtente().getId() == null
                    || suggerimento.getCitta().getId() == null
                    || suggerimento.getOutfit().getId() == null
                    || suggerimento.getMeteoDaily().getId() == null) {
                throw new IllegalArgumentException("Suggerimento non ha gli id impostati");
            }

        return suggerimentoDAO.doSaveSuggerimento(suggerimento);
    }

    /**
     * @param idUtente di cui si vuole ottenere i suggerimenti
     * @throws IllegalArgumentException se idUtente è null
     * @return lista di suggerimenti
     */
    @Override
    public List<Suggerimento> ottieniCronologiaSuggerimentiUtente(Integer idUtente) {
        if (idUtente == null) {
            throw new IllegalArgumentException("Id utente non può essere null");
        }
        return suggerimentoDAO.doRetrieveCronologiaSuggerimentiByUtenteID(idUtente);
    }

    /**
     * @param implementorAlgorithm istanza ottenuta dalla servlet mediante AbstractAlgorithm
     * @param capiAbbigliamento lista di capi d'abbigliamento
     * @param meteoDailyMin informazioni meteorologiche
     * @throws IllegalArgumentException se lista ha meno di tre capi d'abbigliamento o meteo è null
     * @return lista dei tre capi migliori passati al metodo
     */
    @Override
    public <T extends CapoAbbigliamento> List<T> ottieniSuggerimentiCapi(ImplementorAlgorithm<T> implementorAlgorithm,
                                                                         List<T> capiAbbigliamento,
                                                                         MeteoDailyMin meteoDailyMin) {
        if (capiAbbigliamento.size() < 3 || meteoDailyMin == null
                || implementorAlgorithm == null) {
            throw new IllegalArgumentException("Lista capi d'abbigliamento troppo corta o meteo null");
        }

        return implementorAlgorithm.getBestThreeCapoAbbigliamento(capiAbbigliamento, meteoDailyMin);
    }

    /**
     * @param outfit outfit che si vuole salvare nel DB
     * @throws IllegalArgumentException se outfit è null oppure se non contiene maglia, pantaloni e scarpe
     * @return true se è stato possibile salvare l'outfit, altrimenti false
     */
    @Override
    public boolean salvaOutfit(Outfit outfit) {
        if (outfit == null) {
            throw new IllegalArgumentException("Outfit non può essere null");
        } else
            if (outfit.getMaglia() == null
                    || outfit.getPantaloni() == null
                    || outfit.getScarpe() == null) {
                throw new IllegalArgumentException("Outfit non contiene maglia, pantaloni o scarpe");
            }
        return outfitDAO.doSaveOutfit(outfit);
    }

}
