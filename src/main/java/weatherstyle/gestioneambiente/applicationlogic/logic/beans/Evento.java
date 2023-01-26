package weatherstyle.gestioneambiente.applicationlogic.logic.beans;

import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.sql.Timestamp;

public class Evento {
    private Integer id;
    private String nome;
    private Timestamp dataOraEvento;
    private String luogo;
    private String descrizione;
    private String altreInformazioni;
    private Utente utente;

    public Evento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Timestamp getDataOraEvento() {
        return dataOraEvento;
    }

    public void setDataOraEvento(Timestamp dataEvento) {
        this.dataOraEvento = dataEvento;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String obiettivo) {
        this.descrizione = obiettivo;
    }

    public String getAltreInformazioni() {
        return altreInformazioni;
    }

    public void setAltreInformazioni(String altreInformazioni) {
        this.altreInformazioni = altreInformazioni;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataOraEvento=" + dataOraEvento +
                ", luogo='" + luogo + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", altreInformazioni='" + altreInformazioni + '\'' +
                ", utente=" + utente +
                '}';
    }
}
