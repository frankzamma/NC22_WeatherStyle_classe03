package weatherstyle.gestionemeteo.applicationlogic.logic.beans;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Francesco Giuseppe Zammarrelli
 * La classe Meteo hour rappresenta il meteo orario.
 */
public class MeteoHour {
    private int weatherCode;
    private double temperatura;
    private LocalTime time;
    private LocalDate date;
    private double precipitazioni;
    private int visibilitaMetri;
    private double windSpeed;
    private double umiditaRelativa;


    /**
     * Instanzia a new Meteo hour.
     */
    public MeteoHour() {
    }

    /**
     * Restituisce weather code, codice che descriva la previsione.
     *
     * @return weather code
     */
    public int getWeatherCode() {
        return weatherCode;
    }

    /**
     * Imposta weather code.
     *
     * @param weatherCode weather code
     */
    public void setWeatherCode(int weatherCode) {
        this.weatherCode = weatherCode;
    }

    /**
     * Restituisce temperatura.
     *
     * @return temperatura
     */
    public double getTemperatura() {
        return temperatura;
    }

    /**
     * Imposta temperatura.
     *
     * @param temperatura temperatura
     */
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    /**
     * Restituisce time.
     *
     * @return ora della previsione
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * Imposta time.
     *
     * @param time ora della previsione
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     * Restituisce precipitazioni.
     *
     * @return the precipitazioni
     */
    public double getPrecipitazioni() {
        return precipitazioni;
    }

    /**
     * Imposta precipitazioni.
     *
     * @param precipitazioni precipitazioni
     */
    public void setPrecipitazioni(double precipitazioni) {
        this.precipitazioni = precipitazioni;
    }

    /**
     * Restituisce visibilita metri.
     *
     * @return visibilita metri
     */
    public int getVisibilitaMetri() {
        return visibilitaMetri;
    }

    /**
     * Imposta visibilita metri.
     *
     * @param visibilitaMetri visibilita metri
     */
    public void setVisibilitaMetri(int visibilitaMetri) {
        this.visibilitaMetri = visibilitaMetri;
    }

    /**
     * Restituisce wind speed.
     *
     * @return wind speed
     */
    public double getWindSpeed() {
        return windSpeed;
    }

    /**
     * Imposta wind speed.
     *
     * @param windSpeed wind speed
     */
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    /**
     * Restituisce umidita relativa.
     *
     * @return umidita relativa
     */
    public double getUmiditaRelativa() {
        return umiditaRelativa;
    }

    /**
     * Imposta umidita relativa.
     *
     * @param umiditaRelativa umidita relativa
     */
    public void setUmiditaRelativa(double umiditaRelativa) {
        this.umiditaRelativa = umiditaRelativa;
    }

    /**
     * Restituisce una descrizione generica della previsione meteo(Eg. Temporale Forte = pioggia);
     * @return stringa che descrive genericamente la previsione meteo
     */
    public String getMeteoString() {
        return MeteoUtils.translateWeatherCode(this.weatherCode);
    }

    /**
     * Restituisce date.
     *
     * @return data della previsione meteo
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Imposta la data della previsione meteo.
     *
     * @param date data della previsione
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
