package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.sql.Date;

public class Suggerimento {

    private int id;
    private Date date;
    private int valutazione;
    private Utente utente;
    private Citta citta;
    private Outfit outfit;
    private MeteoDaily meteoDaily;

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

    public MeteoDaily getMeteoDaily() {
        return meteoDaily;
    }

    public void setMeteoDaily(MeteoDaily meteoDaily) {
        this.meteoDaily = meteoDaily;
    }
}
