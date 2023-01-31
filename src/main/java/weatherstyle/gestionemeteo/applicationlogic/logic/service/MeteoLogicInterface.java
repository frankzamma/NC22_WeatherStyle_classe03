package weatherstyle.gestionemeteo.applicationlogic.logic.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoHour;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoHours;

import java.util.List;

/**
 * @author Francesco Giuseppe Zammarrelli
 * Interfaccia Meteo logic interface.
 */
public interface MeteoLogicInterface {
    /**
     * Restituisce una lista di MeteoDaily di una citta.
     * La lista contiene il MeteoDaily relativo alla giornata in cui si effettua la chiamata al metodo e
     * i due giorni successivi.
     * @param citta citta di cui si vuole ottenere il meteo
     * @return List che contiene il MeteoDaily della citta <em>citta</em> di tre giorni,
     * giorno in cui si effettua la richiesta e i due giorni successivi.
     */
    List<MeteoDaily> getMeteoDaily(Citta citta);

    /**
     * Restituisce una lista di MeteoHours di una citta.
     * La lista contiene il MeteoHours relativo alla giornata in cui si effettua la chiamata al metodo e
     * i due giorni successivi.
     * @param citta citta di cui si vuole ottenere il meteo
     * @return List che contiene il MeteoHours della citta <em>citta</em> di tre giorni,
     * giorno in cui si effettua la richiesta e i due giorni successivi.
     * @param citta citta
     * @return the meteo hours
     */
    List<MeteoHours> getMeteoHours(Citta citta);
}
