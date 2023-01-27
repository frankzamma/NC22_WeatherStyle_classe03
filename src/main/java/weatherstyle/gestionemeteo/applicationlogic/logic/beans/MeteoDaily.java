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
       return switch (this.weatherCode){
            case 0 ->  "Cielo chiaro";
            case 1 -> "Principalmente chiaro";
            case 2 -> "Parzialmente nuvoloso";
            case 3 -> "Coperto";
            case 45 -> "Nebbia";
            case 48 -> "Nebbia";
            case 51 -> "pioggerella debole";
            case 53 -> "pioggerella Moderata";
            case  55 -> "pioggerella intensa";
            case 56-> "Congelamento leggero";
            case 57->"Congelamento forte";
            case 61->"Pioggia";
            case 63->"Pioggia moderata";
            case 65->"Pioggia molto intensa";
            case 66->"Grandine";
            case 67->"Grandine forte";
            case 71->"Nevicate leggere";
            case 73->"Nevicate moderate";
            case 75->"Nevicate molto intense";
            case 77->"Granelli di neve";
            case 80->"Pioggia a carattere temporalesco leggero";
            case 81->"Pioggia a carattere temporalesco l Medio";
            case  82->"Pioggia a carattere temporalesco l Violento";
            case 85->"Neve leggera";
            case 86->"Neve Intensa";
            case 95->"Temporale";
            case 96->"Temporale con grandine leggera";
            case 99->"Temporale Forte";
            default -> throw  new IllegalArgumentException("WeatherCode non ammissibile");
            };
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
