package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.service;

import weatherstyle.gestionecitta.applicationlogic.logic.service.CittaLogicService;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.CapoAbbigliamento;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDailyMin;
import weatherstyle.gestionemeteo.applicationlogic.logic.service.MeteoLogicService;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.algorithms.ImplementorAlgorithm;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Outfit;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Suggerimento;
import weatherstyle.gestionesuggerimentiia.storage.dao.OutfitDAOInterface;
import weatherstyle.gestionesuggerimentiia.storage.dao.SuggerimentoDAOInterface;

import java.util.ArrayList;
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
     * @param suggerimento il suggerimento che si vuole salvare nel DB completo dei suoi attributi
     * @throws IllegalArgumentException se suggerimento è null o non ha tutti i campi settati
     * @return true se è stato possibile salvare il suggerimento, altrimenti false
     */
    @Override
    public boolean salvaSuggerimento(Suggerimento suggerimento) {
        if (suggerimento == null)
            throw new IllegalArgumentException("Suggerimento non può essere null");
        if (suggerimento.getUtente() == null)
            throw new IllegalArgumentException("Utente non può essere null");
        if (suggerimento.getCitta() == null)
            throw new IllegalArgumentException("Citta non può essere null");
        if (suggerimento.getMeteoDailyMin() == null)
            throw new IllegalArgumentException("Meteo non può essere null");
        if (suggerimento.getOutfit() == null)
            throw new IllegalArgumentException("Outfit non può essere null");

        if (suggerimento.getOutfit().getMaglia() == null)
            throw new IllegalArgumentException("Outfit non contiene maglia");
        if (suggerimento.getOutfit().getPantaloni() == null)
            throw new IllegalArgumentException("Outfit non contiene pantaloni");
        if (suggerimento.getOutfit().getScarpe() == null)
            throw new IllegalArgumentException("Outfit non contiene scarpe");
        if (suggerimento.getOutfit().getNome().length() == 0 || suggerimento.getOutfit().getNome().length() > 30)
            throw new IllegalArgumentException("Outfit lunghezza nome deve essere tra 1 e 30 caratteri");

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
        if (capiAbbigliamento == null || meteoDailyMin == null
                || implementorAlgorithm == null) {
            throw new IllegalArgumentException("Lista capi d'abbigliamento troppo corta o meteo null");
        }

        if (capiAbbigliamento.size() < 3)
            return new ArrayList<T>();

        return implementorAlgorithm.getBestThreeCapoAbbigliamento(capiAbbigliamento, meteoDailyMin);
    }

    /**
     * Questo metodo permette di ottenere un Outfit creato dall’utente dal database dato il suggerimento associato.
     * @param suggerimento con id settato
     * @return un outfit associato a quel suggerimento
     */
    public Outfit ottieniOutfitDaSuggerimento(Suggerimento suggerimento){
        if (suggerimento.getId() == null)
            return null;
        return outfitDAO.doRetrieveOutfitBySuggerimentoID(suggerimento.getId());
    }

}
