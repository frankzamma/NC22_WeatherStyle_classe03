package weatherstyle.gestionemeteo.applicationlogic.logic.beans;

/**
 * @author Francesco Giuseppe Zammarrelli
 * Classe che mantiene informazioni minimali di previsioni meteo giornaliere
 */
public class MeteoDailyMin {
    /**
     * Identificatore della previsione
     */
    private Integer id;
    /**
     * Meteo della previsione
     */
    private String meteo;
    /**
     * Temperatura percepita media
     */
    private double temperaturaPercepitaMedia;
    /**
     * Stagione della previsione
     */
    private String stagionePrevisione;

    /**
     * Costruttore vuoto
     */
    public MeteoDailyMin() {
    }

    /**
     * Restituisce l'identificatore della previsione meteo
     * @return identificatore della previsione meteo
     */
    public Integer getId() {
        return id;
    }

    /**
     * Imposta l'identificatore della previsione meteo
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Restituisce una stringa che descrive la previsione meteo, rispetto a <em>getMeteoString()</em>,
     * la string fornisce una descrizione generica (Eg. Temporale Forte = pioggia);
     * @return stringa che descrive genericamente la previsione meteo
     */
    public String getMeteoStringMin() {
        return meteo;
    }

    /**
     * Imposta la descrizione della previsione meteo
     * @param meteo descrizione della previsione meteo
     */
    public void setMeteo(String meteo) {
        this.meteo = meteo;
    }

    /**
     * Restituisce la temperatura percepita media
     * @return temperatura percepita media
     */
    public double getTemperaturaPercepitaMedia() {
        return temperaturaPercepitaMedia;
    }

    /**
     * Imposta la temperatura percepita media
     * @param temperaturaPercepitaMedia
     */
    public void setTemperaturaPercepitaMedia(double temperaturaPercepitaMedia) {
        this.temperaturaPercepitaMedia = temperaturaPercepitaMedia;
    }

    /**
     *Restituisce la stagione di previsione
     * @return stagione della previsione
     */
    public String getStagionePrevisione() {
        return stagionePrevisione;
    }

    /**
     * Restituisce la stagione di previsione
     * @param stagionePrevisione
     */
    public void setStagionePrevisione(String stagionePrevisione) {
        this.stagionePrevisione = stagionePrevisione;
    }

    /**
     *
     * @return Stringa in formato JSON
     */
    @Override
    public String toString() {
        return "MeteoDailyMin{" +
                "id=" + id +
                ", meteo='" + meteo + '\'' +
                ", temperaturaPercepitaMedia=" + temperaturaPercepitaMedia +
                ", stagionePrevisione='" + stagionePrevisione + '\'' +
                '}';
    }
}
