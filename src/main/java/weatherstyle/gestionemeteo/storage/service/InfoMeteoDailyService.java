package weatherstyle.gestionemeteo.storage.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Francesco Giuseppe Zammarrelli
 * Interfaccia Info meteo daily service.
 */
public interface InfoMeteoDailyService {
    /**
     * Restituisce le informazioni giornaliere meteo della Citta <em>citta</em> per il giorno day
     *
     * @param day   giorno della previsione
     * @param citta citta per la quale si desidera la previsione
     * @return MeteoDaily con informazioni meteo della Citta <em>citta</em> per il giorno day
     */
    MeteoDaily getInfoMeteoDailyByDay(LocalDate day,Citta citta);

    /**
     * Restituisce le informazioni meteo giornaliere della Citta <em>citta</em> dal giorno init al giorno end.
     *
     * @param init  giorno inizio dell'intervallo
     * @param end   fine della previsione
     * @param citta citta per la quale si desidera la previsione
     * @return List<MeteoDaily> meteo della Citta <em>citta</em> dal giorno init al giorno end.
     */
    List<MeteoDaily> getInfoMeteoDailyByRangeOfDays(LocalDate init,LocalDate end,Citta citta);

}
