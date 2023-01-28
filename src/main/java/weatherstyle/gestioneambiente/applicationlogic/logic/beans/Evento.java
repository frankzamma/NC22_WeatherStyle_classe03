package weatherstyle.gestioneambiente.applicationlogic.logic.beans;

import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.sql.Timestamp;

/**
 * @author angelopalmieri
 * Classe che rappresenta l'evento creato da un ecologista per la salvaguardia
 * dell'ambiente.
 */
public class Evento {
    /**
     * Identificatore dell'evento.
     */
    private Integer id;
    /**
     * Nome dell'evento.
     */
    private String nome;
    /**
     * Data e ora in cui si svolge l'evento.
     */
    private Timestamp dataOraEvento;
    /**
     * Luogo in cui avviene l'evento.
     */
    private String luogo;
    /**
     * Descrizione sommaria in cui si illustra
     * ciò che verrà fatto durante l'evento.
     */
    private String descrizione;
    /**
     * Altre informazioni utili per partecipare
     * all'evento.
     */
    private String altreInformazioni;
    /**
     * Utente ecologista che ha creato l'evento.
     */
    private Utente utente;

    /**
     * Costruttore vuoto che si occupa di istanziare l'evento.
     */
    public Evento() {
    }

    /**
     * Restituisce l'id dell'evento.
     * @return id dell'evento.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Imposta l'id dell'evento.
     * @param id rappresenta il nuovo id dell'evento.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Restituisce il nome dell'evento.
     * @return nome dell'evento.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome dell'evento.
     * @param nome rappresenta il nuovo nome dell'evento.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce la data e l'ora in cui si svolge l'evento.
     * @return dataOra in cui si svolge l'evento.
     */
    public Timestamp getDataOraEvento() {
        return dataOraEvento;
    }

    /**
     * Imposta la data e l'ora in cui si svolge l'evento.
     * @param dataOraEvento rappresenta la nuova dataOra dell'evento.
     */
    public void setDataOraEvento(Timestamp dataOraEvento) {
        this.dataOraEvento = dataOraEvento;
    }

    /**
     * Restituisce il luogo in cui avviene l'evento.
     * @return luogo in cui avviene l'evento.
     */
    public String getLuogo() {
        return luogo;
    }

    /**
     * Imposta il luogo in cui avviene l'evento.
     * @param luogo rappresenta il nuovo luogo in cui avviene l'evento.
     */
    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    /**
     * Restituisce la descrizione di ciò che verrà fatto durante l'evento.
     * @return descrizione di ciò che verrà fatto durante l'evento.
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Imposta la descrizione di ciò che verrà fatto durante l'evento.
     * @param descrizione rappresenta la nuova descrizione di ciò che verrà
     *                   fatto durante l'evento.
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * Restituisce le altre informazioni utili per partecipare all'evento.
     * @return altre informazioni utili per l'evento.
     */
    public String getAltreInformazioni() {
        return altreInformazioni;
    }

    /**
     * Imposta le altre informazioni utili per partecipare all'evento.
     * @param altreInformazioni rappresenta le nuove altre informazioni utili
     *                          per l'evento.
     */
    public void setAltreInformazioni(String altreInformazioni) {
        this.altreInformazioni = altreInformazioni;
    }

    /**
     * Restituisce l'oggetto utente ecologista che ha creato l'evento.
     * @return utente ecologista che ha creata l'evento.
     */
    public Utente getUtente() {
        return utente;
    }

    /**
     * Imposta l'utente ecologista che ha creato l'evento.
     * @param utente rappresenta il nuovo utente ecologista che ha creato l'evento.
     */
    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Evento{"
                + "id=" + id
                + ", nome='" + nome + '\''
                + ", dataOraEvento=" + dataOraEvento
                + ", luogo='" + luogo + '\''
                + ", descrizione='" + descrizione + '\''
                + ", altreInformazioni='" + altreInformazioni + '\''
                + ", utente=" + utente
                + '}';
    }
}
