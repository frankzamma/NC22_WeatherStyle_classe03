package weatherstyle.gestioneambiente.applicationlogic.logic.service;

import weatherstyle.gestioneambiente.applicationlogic.logic.beans.RichiestaPromozione;
import weatherstyle.gestioneambiente.storage.dao.RichiestaPromozioneDAOInterface;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;

import java.util.List;

public class RichiestaPromozioneLogicService implements RichiestaPromozioneLogicInterface{
    private final RichiestaPromozioneDAOInterface richiestaPromozioneDAO;

    public RichiestaPromozioneLogicService(RichiestaPromozioneDAOInterface richiestaPromozioneDAO) {
        this.richiestaPromozioneDAO = richiestaPromozioneDAO;
    }

    @Override
    public RichiestaPromozione ottieniRichiestaPromozionePerIdUtente(int idUtente) {
        return richiestaPromozioneDAO.doRetrieveByIdUtente(idUtente);
    }

    @Override
    public boolean salvaRichiestaPromozione(RichiestaPromozione richiestaPromozione) {
        if(richiestaPromozione == null)
            throw new IllegalArgumentException("Errore, richiestaPromozione null.");

        if(richiestaPromozioneDAO.doRetrieveByIdUtente(richiestaPromozione.getUtente().getId()) == null)
            throw new IllegalArgumentException("L'utente ha già richiesto la promozione ad ecologista.");

        if(richiestaPromozione.getTematiche() == null || richiestaPromozione.getTematiche().equals(""))
            throw new IllegalArgumentException("Mancano le tematiche.");

        if(richiestaPromozione.getEsperienze() == null || (richiestaPromozione.getEsperienze().length() < 5 || richiestaPromozione.getEsperienze().length() >250))
            throw new IllegalArgumentException("La lunghezza della stringa esperienze non è valida.");

        return richiestaPromozioneDAO.doSaveRichiestaPromozione(richiestaPromozione);
    }

    @Override
    public List<RichiestaPromozione> ottieniListaRichiestePromozioni() {
        return richiestaPromozioneDAO.doRetrieveAll();
    }

    @Override
    public List<RichiestaPromozione> ottieniListaRichiestePromozioniPerStato(String stato) {
        if(!stato.equals("in attesa") && !stato.equals("approvata") && !stato.equals("rifiutata"))
            throw new IllegalArgumentException("Lo stato di una richiesta può essere solo: in attesa, approvata o rifiutata.");

        return richiestaPromozioneDAO.doRetrieveRichiestaPromozioneByStato(stato);
    }

    @Override
    public boolean aggiornaStatoRichiestaPromozionePerId(RichiestaPromozione richiestaPromozione, String nuovoStato, Admin admin) {
        if(!nuovoStato.equals("in attesa") && !nuovoStato.equals("approvata") && !nuovoStato.equals("rifiutata"))
            throw new IllegalArgumentException("Lo stato di una richiesta può essere solo: in attesa, approvata o rifiutata.");

        if(richiestaPromozione == null || !richiestaPromozione.getStato().equals("in attesa"))
            throw new IllegalArgumentException("La richiesta di promozione è già stata valutata precedentemente.");

        if(admin == null)
            throw new IllegalArgumentException("Questa operazione deve essere eseguita da un amministratore.");

        return richiestaPromozioneDAO.doUpdateStatoById(richiestaPromozione, nuovoStato, admin);
    }

}
