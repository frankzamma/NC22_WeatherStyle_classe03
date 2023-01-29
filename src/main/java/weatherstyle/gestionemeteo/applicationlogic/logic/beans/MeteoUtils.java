package weatherstyle.gestionemeteo.applicationlogic.logic.beans;

public class MeteoUtils {
    public static String translateWeatherCode(int weatherCode){
        return switch (weatherCode){
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
            case 81->"Pioggia a carattere temporalesco Medio";
            case  82->"Pioggia a carattere temporalesco Violento";
            case 85->"Neve leggera";
            case 86->"Neve Intensa";
            case 95->"Temporale";
            case 96->"Temporale con grandine leggera";
            case 99->"Temporale Forte";
            default -> throw  new IllegalArgumentException("WeatherCode non ammissibile");
        };
    }

    public static String imageFromWeatherCode(int weatherCode){
        return "./image/meteoImage/"+
                switch (weatherCode){
            case 0, 1 ->  "soleggiato.png";
            case 2, 3 -> "clouds.png";
            case 45, 48 -> "nebbia.png";
            case 51, 53 -> "pioggia_leggera.png";
            case  55, 63, 61 -> "pioggia.png";
            case 56,57-> "congelamento.png";
            case 65, 80, 95, 96, 99, 81, 82 ->"temporale.png";
            case 66, 67 ->"grandine.png";
            case 71, 77, 73, 75, 85, 86 ->"neve.png";
            default -> throw  new IllegalArgumentException("WeatherCode non ammissibile");
        };
    }
}
