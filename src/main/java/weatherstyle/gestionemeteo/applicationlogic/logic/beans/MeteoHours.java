package weatherstyle.gestionemeteo.applicationlogic.logic.beans;

import java.util.List;

/**
 * @author Francesco Giuseppe Zammarrelli
 * La classe Meteo hours rappresenta il meteo orario di una giornata
 */
public class MeteoHours {
    private List<MeteoHour> meteoInfo;

    /**
     * Instanzia a new Meteo hours.
     */
    public MeteoHours() {
    }

    /**
     * Instanzia un nuovo Meteo hours.
     *
     * @param meteoInfo meteo info
     */
    public MeteoHours(List<MeteoHour> meteoInfo) {
        this.meteoInfo = meteoInfo;
    }

    /**
     * Restituisce meteo info.
     *
     * @return  meteo info
     */
    public List<MeteoHour> getMeteoInfo() {
        return meteoInfo;
    }

    /**
     * Imposta meteo info.
     *
     * @param meteoInfo meteo info
     */
    public void setMeteoInfo(List<MeteoHour> meteoInfo) {
        this.meteoInfo = meteoInfo;
    }

    /**
     * Metod che permette di aggiungere un nuovo MeteoHour
     *
     * @param meteoHour meteo hour
     * @return true se inserito correttamente, false altrimenti
     */
    public boolean add(MeteoHour meteoHour) {
        return meteoInfo.add(meteoHour);
    }

    /**
     * Restituisce il meteoHour in posizione index.
     *
     * @param index la posizione del MeteoHours
     * @return meteo hour in posizione index
     */
    public MeteoHour get(int index) {
        return meteoInfo.get(index);
    }

    /**
     * Metod che permette di aggiungere un nuovo MeteoHour in posizione index
     *
     * @param index   the index posizione in cui aggiungere in nuovo MeteoHour
     * @param element elemento MeteoHour da aggiungere
     */
    public void add(int index,MeteoHour element) {
        meteoInfo.add(index,element);
    }
}
