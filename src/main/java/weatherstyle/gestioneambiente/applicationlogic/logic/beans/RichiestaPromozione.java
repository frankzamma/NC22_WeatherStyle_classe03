package weatherstyle.gestioneambiente.applicationlogic.logic.beans;

import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

/**
 * @author angelopalmieri
 * Classe che rappresenta la richiesta di promozione a ecologista
 * avanzata da un utente.
 */
public class RichiestaPromozione {

    /**
     * Identificatore della richiesta di promozione.
     */
    private Integer id;
    /**
     * Tematiche ambientali che interessano l'utente che richiede la promozione.
     */
    private String tematiche;
    /**
     * Esperienze nell'ambito della salvaguardia dell'ambiente da parte
     * dell'utente che richiede la promozione.
     */
    private String esperienze;
    /**
     * Stato in cui si trova la richiesta di promozione.
     * Può assumere tre valori distinti: in attesa, approvata, rifiutata.
     */
    private String stato;
    /**
     * Utente che ha richiesto la promozione a ecologista.
     */
    private Utente utente;
    /**
     * Amministratore che ha approvato o rifiutato la richiesta di promozione.
     */
    private Admin admin;

    /**
     * Costruttore vuoto che si occupa di istanziare la richiesta di promozione.
     */
    public RichiestaPromozione() {
    }

    /**
     * Restituisce l'id della richiesta di promozione.
     * @return id richiesta promozione.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Imposta l'id della richiesta di promozione.
     * @param id rappresenta il nuovo id della richiesta di promozione.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Restituisce le tematiche ambientali che interessano l'utente.
     * @return tematiche interessate dall'utente che ha richiesto la promozione.
     */
    public String getTematiche() {
        return tematiche;
    }

    /**
     * Imposta le tematiche ambientali che interessano l'utente.
     * @param tematiche rappresenta le nuove tematiche interessate dall'utente che ha
     *                  richiesto la promozione.
     */
    public void setTematiche(String tematiche) {
        this.tematiche = tematiche;
    }

    /**
     * Restituisce le esperienze nell'ambito della salvaguardia dell'ambiente
     * che ha maturato chi richiede la promozione.
     * @return esperienze nell'ambito della salvaguardia dell'ambiente.
     */
    public String getEsperienze() {
        return esperienze;
    }

    /**
     * Imposta le esperienze nell'ambito della salvaguardia dell'ambiente
     * che ha maturato chi richiede la promozione.
     * @param esperienze rappresenta le nuove esperienze nell'ambito della
     *                   salvaguardia dell'ambiente.
     */
    public void setEsperienze(String esperienze) {
        this.esperienze = esperienze;
    }

    /**
     * Restituisce lo stato in cui si trova la richiesta di promozione.
     * @return stato di avanzamento della richiesta di promozione.
     */
    public String getStato() {
        return stato;
    }

    /**
     * Imposta lo stato in cui si trova la richiesta di promozione.
     * @param stato rappresenta il nuovo stato in cui si trova
     *              la richiesta di promozione.
     */
    public void setStato(String stato) {
        this.stato = stato;
    }

    /**
     * Restituisce l'utente che ha richiesto la promozione per
     * diventare ecologista.
     * @return utente che ha richiesto la promozione a ecologista.
     */
    public Utente getUtente() {
        return utente;
    }

    /**
     * Imposta l'utente che ha richiesto la promozione
     * per diventare ecologista.
     * @param utente rappresenta il nuovo utente che richiesto
     *              la promozione a ecologista.
     */
    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    /**
     * Restituisce l'amministratore che si è occupato di valutare
     * la richiesta di promozione.
     * @return admin che ha valutato la richiesta di promozione
     * (può approvare o rifiutare).
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     * Imposta l'amministratore che si è occupato di valutare
     * la richiesta di promozione.
     * @param admin rappresenta il nuovo amministratore che ha
     *              valutato la richiesta di promozione.
     */
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
