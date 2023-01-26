package weatherstyle.gestioneambiente.applicationlogic.logic.beans;

import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

public class RichiestaPromozione {

    private Integer id;
    private String tematiche;
    private String esperienze;
    private String stato;
    private Utente utente;
    private Admin admin;

    public RichiestaPromozione() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTematiche() {
        return tematiche;
    }

    public void setTematiche(String tematiche) {
        this.tematiche = tematiche;
    }

    public String getEsperienze() {
        return esperienze;
    }

    public void setEsperienze(String esperienze) {
        this.esperienze = esperienze;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "RichiestaPromozione{" +
                "id=" + id +
                ", tematiche='" + tematiche + '\'' +
                ", esperienze='" + esperienze + '\'' +
                ", stato='" + stato + '\'' +
                ", utente=" + utente +
                ", admin=" + admin +
                '}';
    }
}
