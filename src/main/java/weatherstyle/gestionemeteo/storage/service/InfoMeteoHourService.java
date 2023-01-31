package weatherstyle.gestionemeteo.storage.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoHour;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoHours;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Francesco Giuseppe Zammarrelli
 * Interfaccia Info meteo hour service.
 */
public interface InfoMeteoHourService {
      /**
       * Restituisce le informazioni meteo orarie della Citta <em>citta</em> per il giorno day
       *
       * @param day   giorno della previsione
       * @param citta citta per la quale si desidera la previsione
       * @return MeteoHours con informazioni meteo della Citta <em>citta</em> per il giorno day
       */
      MeteoHours getInfoMeteoHourByDay(LocalDate day,Citta citta);

      /**
       * Restituisce le informazioni meteo orarie della Citta <em>citta</em> dal giorno init al giorno end.
       *
       * @param init  giorno inizio dell'intervallo
       * @param end   fine della previsione
       * @param citta citta per la quale si desidera la previsione
       * @return List<MeteoHours> meteo della Citta <em>citta</em> dal giorno init al giorno end.
       */
      List<MeteoHours> getInfoMeteoHourByRangeOfDays(LocalDate init,LocalDate end,Citta citta);
}
