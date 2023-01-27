package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDailyMin;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.sql.Date;

/**
 * @author Raffaele Aurucci
 * classe che rappresenta il suggerimento dato dal sistema all'utente
 */
public class Suggerimento {

    /**
     * id suggerimento
     */
    private int id;

    /**
     * data del suggerimento
     */
    private Date date;

    /**
     * valutazione data dall'utente all'outfit. NB: in questa versione non è stato gestito il feedback dell'utente
     */
    private int valutazione;

    /**
     * utente a cui fa riferimento il suggerimento
     */
    private Utente utente;

    /**
     * citta a cui fa riferimento il suggerimento
     */
    private Citta citta;

    /**
     * outfit a cui fa riferimento il suggerimento
     */
    private Outfit outfit;

    /**
     * informazioni meteorologiche a cui fa riferimento il suggerimento
     */
    private MeteoDailyMin meteoDailyMin;

    public Suggerimento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getValutazione() {
        return valutazione;
    }

    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Citta getCitta() {
        return citta;
    }

    public void setCitta(Citta citta) {
        this.citta = citta;
    }

    public Outfit getOutfit() {
        return outfit;
    }

    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }

    public MeteoDailyMin getMeteoDaily() {
        return meteoDailyMin;
    }

    public void setMeteoDaily(MeteoDailyMin meteoDailyMin) {
        this.meteoDailyMin = meteoDailyMin;
    }
}
