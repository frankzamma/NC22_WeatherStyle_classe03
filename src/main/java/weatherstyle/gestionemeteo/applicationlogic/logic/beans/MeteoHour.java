package weatherstyle.gestionemeteo.applicationlogic.logic.beans;

import java.time.LocalDate;
import java.time.LocalTime;

public class MeteoHour {
    private int weatherCode;
    private double temperatura;
    private LocalTime time;
    private LocalDate date;
    private double precipitazioni;
    private int visibilitaMetri;
    private double windSpeed;
    private double umiditaRelativa;


    public MeteoHour() {
    }

    public int getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(int weatherCode) {
        this.weatherCode = weatherCode;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public double getPrecipitazioni() {
        return precipitazioni;
    }

    public void setPrecipitazioni(double precipitazioni) {
        this.precipitazioni = precipitazioni;
    }

    public int getVisibilitaMetri() {
        return visibilitaMetri;
    }

    public void setVisibilitaMetri(int visibilitaMetri) {
        this.visibilitaMetri = visibilitaMetri;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getUmiditaRelativa() {
        return umiditaRelativa;
    }

    public void setUmiditaRelativa(double umiditaRelativa) {
        this.umiditaRelativa = umiditaRelativa;
    }

    public String getMeteoString(){
        return MeteoUtils.translateWeatherCode(this.weatherCode);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
