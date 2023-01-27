package weatherstyle.gestionemeteo.storage.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoHour;

import java.time.LocalDate;
import java.util.List;

public interface InfoMeteoHourService {
      MeteoHour getInfoMeteoHourByDay(LocalDate day, LocalDate citta);
      List<MeteoHour> getInfoMeteoHourByRangeOfDays(LocalDate init, LocalDate end, Citta citta);
}
