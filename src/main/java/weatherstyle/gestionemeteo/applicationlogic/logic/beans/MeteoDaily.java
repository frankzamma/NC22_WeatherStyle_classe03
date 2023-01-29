package weatherstyle.gestionemeteo.applicationlogic.logic.beans;

import java.time.LocalDate;
import java.util.Calendar;

public class MeteoDaily {
    private int weatherCode;
    private double temperaturaPercepitaMinima;
    private double temperaturaPercepitaMassima;
    private LocalDate time;

    public MeteoDaily() {
    }

    public int getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(int weatherCode) {
        this.weatherCode = weatherCode;
    }

    public double getTemperaturaPercepitaMinima() {
        return temperaturaPercepitaMinima;
    }

    public void setTemperaturaPercepitaMinima(double temperaturaPercepitaMinima) {
        this.temperaturaPercepitaMinima = temperaturaPercepitaMinima;
    }

    public double getTemperaturaPercepitaMassima() {
        return temperaturaPercepitaMassima;
    }

    public void setTemperaturaPercepitaMassima(double temperaturaPercepitaMassima) {
        this.temperaturaPercepitaMassima = temperaturaPercepitaMassima;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getMeteoString(){
       return MeteoUtils.translateWeatherCode(this.weatherCode);
    }

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

    public String getStagione(){
        String[] stagioneMesi = {"inverno", "inverno", "primavera", "primavera", "primavera", "estate", "estate", "estate", "autunno", "autunno", "autunno", "inverno"};

        return stagioneMesi[time.getMonth().getValue() - 1];
    }

    public MeteoDailyMin toMeteoDailyMin(){
        MeteoDailyMin meteoDailyMin =  new MeteoDailyMin();

        meteoDailyMin.setMeteo(getMeteoStringMin());
        meteoDailyMin
                .setTemperaturaPercepitaMedia((this.temperaturaPercepitaMinima + this.temperaturaPercepitaMassima)/2);
        meteoDailyMin.setStagionePrevisione(this.getStagione());
        return meteoDailyMin;
    }
}
