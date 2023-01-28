package weatherstyle.gestionemeteo.storage.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoHour;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoHours;

import java.time.LocalDate;
import java.util.List;

public interface InfoMeteoHourService {
      MeteoHours getInfoMeteoHourByDay(LocalDate day, Citta citta);
      List<MeteoHours> getInfoMeteoHourByRangeOfDays(LocalDate init, LocalDate end, Citta citta);
}
