package weatherstyle.gestioneambiente.applicationlogic.logic.service;

import weatherstyle.gestioneambiente.applicationlogic.logic.beans.RichiestaPromozione;
import weatherstyle.gestioneambiente.storage.dao.RichiestaPromozioneDAOImpl;
import weatherstyle.gestioneambiente.storage.dao.RichiestaPromozioneDAOInterface;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;

import java.util.List;

/**
 * @author angelopalmieri
 * Classe che gestisce le operazioni di business che riguardano le richieste di promozione
 * a ecologista avanzate dagli utenti.
 */
public class RichiestaPromozioneLogicImpl implements RichiestaPromozioneLogicInterface{
    /**
     * DAO di richiestaPromozione per interagire direttamente col database.
     */
    private final RichiestaPromozioneDAOInterface richiestaPromozioneDAO;

    /**
     * Costruttore vuoto in cui si istanzia richiestaPromozioneDAO.
     */
    public RichiestaPromozioneLogicImpl() {
        this.richiestaPromozioneDAO = new RichiestaPromozioneDAOImpl();
    }

    /**
     * Costruttore in cui si assegna richiestaPromozioneDAO.
     * @param richiestaPromozioneDAO rappresenta il DAO di richiesta promozione che andrà
     *                               a usare questa classe per interagire direttamente col database.
     */
    public RichiestaPromozioneLogicImpl(RichiestaPromozioneDAOInterface richiestaPromozioneDAO) {
        this.richiestaPromozioneDAO = richiestaPromozioneDAO;
    }

    @Override
    public RichiestaPromozione ottieniRichiestaPromozionePerIdUtente(int idUtente) {
        return richiestaPromozioneDAO.doRetrieveByIdUtente(idUtente);
    }

    @Override
    public boolean salvaRichiestaPromozione(RichiestaPromozione richiestaPromozione) {
        if (richiestaPromozione == null) {
            throw new IllegalArgumentException("Errore, richiestaPromozione null.");
        }

        if (richiestaPromozioneDAO.doRetrieveByIdUtente(richiestaPromozione.getUtente().getId()) != null) {
            throw new IllegalArgumentException("L'utente ha già richiesto la promozione ad ecologista.");
        }

        if (richiestaPromozione.getTematiche() == null || "".equals(richiestaPromozione.getTematiche())) {
            throw new IllegalArgumentException("Mancano le tematiche.");
        }

        if (richiestaPromozione.getEsperienze() == null || (richiestaPromozione.getEsperienze().length() < 5
                || richiestaPromozione.getEsperienze().length() > 250)) {
            throw new IllegalArgumentException("La lunghezza della stringa esperienze non è valida.");
        }

        return richiestaPromozioneDAO.doSaveRichiestaPromozione(richiestaPromozione);
    }

    @Override
    public List<RichiestaPromozione> ottieniListaRichiestePromozione() {
        return richiestaPromozioneDAO.doRetrieveAll();
    }

    @Override
    public List<RichiestaPromozione> ottieniListaRichiestePromozionePerStato(String stato) {
        if (stato == null) {
            throw new IllegalArgumentException("Errore, stato null.");
        }
        if (!"in attesa".equals(stato) && !"approvata".equals(stato) && !"rifiutata".equals(stato)) {
            throw new IllegalArgumentException("Lo stato di una richiesta può essere solo: in attesa, approvata o rifiutata.");
        }

        return richiestaPromozioneDAO.doRetrieveRichiestaPromozioneByStato(stato);
    }

    @Override
    public boolean aggiornaStatoRichiestaPromozione(RichiestaPromozione richiestaPromozione,String nuovoStato,Admin admin) {
        if (nuovoStato == null) {
            throw new IllegalArgumentException("Errore, nuovoStato null.");
        }

        if (!"in attesa".equals(nuovoStato) && !"approvata".equals(nuovoStato) && !"rifiutata".equals(nuovoStato)) {
            throw new IllegalArgumentException("Lo stato di una richiesta può essere solo: in attesa, approvata o rifiutata.");
        }

        if (richiestaPromozione == null) {
            throw new IllegalArgumentException("Errore, richiesta di promozione null.");
        }

        if (!"in attesa".equals(richiestaPromozione.getStato())) {
            throw new IllegalArgumentException("La richiesta di promozione è già stata valutata.");
        }

        if (admin == null) {
            throw new IllegalArgumentException("Errore, admin null.");
        }

        return richiestaPromozioneDAO.doUpdateStato(richiestaPromozione,nuovoStato,admin);
    }

    @Override
    public RichiestaPromozione ottieniRichiestaPromozionePerId(int idRichiestaPromozione) {
        return richiestaPromozioneDAO.doRetrieveById(idRichiestaPromozione);
    }

}
