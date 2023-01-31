package weatherstyle.gestionemeteo.applicationlogic.logic.beans;

import java.time.LocalDate;
import java.util.Calendar;

/**
 * @author Francesco Giuseppe Zammarrelli
 *
 * Classe che mantiene informazioni meteo giornaliere
 */
public class MeteoDaily {
    /**
     * codice identificativo di una previsione meteo
     */
    private int weatherCode;
    /**
     * temperatura percepita minima
     */
    private double temperaturaPercepitaMinima;
    /**
     * temperatura percepita massima
     */
    private double temperaturaPercepitaMassima;
    /**
     * Data a cui si riferisce una previsione
     */
    private LocalDate time;

    /**
     * Costruttore vuoto
     */
    public MeteoDaily() {
    }

    /**
     * Restituisce il weathercode della previsione meteo
     * @return weatherCode della previsione meteo
     */
    public int getWeatherCode() {
        return weatherCode;
    }

    /**
     * Imposta un weatherCode della previsione meteo
     * @param weatherCode codice di una previsione meteo
     */
    public void setWeatherCode(int weatherCode) {
        this.weatherCode = weatherCode;
    }

    /**
     * Restituisce la temperatura percepita minima della previsione
     * @return la temperatura percepita minima della giornata della previsione
     */
    public double getTemperaturaPercepitaMinima() {
        return temperaturaPercepitaMinima;
    }

    /**
     * Imposta la temperatura percepita minima della previsione
     * @param temperaturaPercepitaMinima temperatura percepita minima della gionr
     */
    public void setTemperaturaPercepitaMinima(double temperaturaPercepitaMinima) {
        this.temperaturaPercepitaMinima = temperaturaPercepitaMinima;
    }

    /**
     * Restituisce la temperatuara percepita massima della previsione
     * @return temperatuara percepita massima della previsione
     */
    public double getTemperaturaPercepitaMassima() {
        return temperaturaPercepitaMassima;
    }

    /**
     * Imposta la temperatuara percepita massima della previsione meteo
     * @param temperaturaPercepitaMassima
     */
    public void setTemperaturaPercepitaMassima(double temperaturaPercepitaMassima) {
        this.temperaturaPercepitaMassima = temperaturaPercepitaMassima;
    }

    /**
     * Restituisce la data a cui fa riferimento la previsione
     * @return data a cui fa riferimento la previsione
     */
    public LocalDate getTime() {
        return time;
    }

    /**
     * Imposta la data a cui fa riferimento la previsione
     * @param time data a cui fa riferimento la previsione
     */
    public void setTime(LocalDate time) {
        this.time = time;
    }

    /**
     * Restituisce una stringa che descrive la previsione meteo (Eg. soleggiato)
     * @return stringa che descrive la previsione meteo
     */
    public String getMeteoString(){
       return MeteoUtils.translateWeatherCode(this.weatherCode);
    }

    /**
     * Restituisce una stringa che descrive la previsione meteo, rispetto a <em>getMeteoString()</em>,
     * la string fornisce una descrizione generica (Eg. Temporale Forte = pioggia);
     * @return stringa che descrive genericamente la previsione meteo
     */
    private String getMeteoStringMin(){
        String meteo =  this.getMeteoString();
        if (meteo.contains("Piog") || meteo.contains("piog") || meteo.contains("Temporale")){
                return "pioggia";
        }
        if (meteo.contains("sol") || meteo.contains("Sol") || meteo.contains("chiaro") || meteo.contains("Parzial")) {
            return "soleggiato";
        }
        if ((meteo.contains("nuv") || meteo.contains("Nuv") || meteo.contains("Coperto")) && (!meteo.contains("Parzial"))) {
            return "nuvoloso";
        }
        if (meteo.contains("Nebbia")){
            return "soleggiato";
        }
        if (meteo.contains("Nev") || meteo.contains("nev") || meteo.contains("Grandine")) {
            return "neve";
        }

        throw new IllegalArgumentException("Errore nella costruzione del meteo");
    }

    /**
     *Restituisce la stagione di previsione
     * @return stagione della previsione
     */
    public String getStagione(){
        String[] stagioneMesi = {"inverno", "inverno", "primavera", "primavera", "primavera", "estate", "estate", "estate", "autunno", "autunno", "autunno", "inverno"};

        return stagioneMesi[time.getMonth().getValue() - 1];
    }

    /**
     * Converte l'oggetto MeteoDaily in MeteoDailyMin
     * @return la conversione dell'ogetto in MeteoDailyMin
     */
    public MeteoDailyMin toMeteoDailyMin(){
        MeteoDailyMin meteoDailyMin =  new MeteoDailyMin();

        meteoDailyMin.setMeteo(getMeteoStringMin());
        meteoDailyMin
                .setTemperaturaPercepitaMedia((this.temperaturaPercepitaMinima + this.temperaturaPercepitaMassima)/2);
        meteoDailyMin.setStagionePrevisione(this.getStagione());
        return meteoDailyMin;
    }
}
