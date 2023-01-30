package weatherstyle.gestionemeteo.applicationlogic.logic.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoHour;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoHours;

import java.util.List;

public interface MeteoLogicInterface {
    List<MeteoDaily> getMeteoDaily(Citta citta);
    List<MeteoHours> getMeteoHours(Citta citta);
}
