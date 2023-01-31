package weatherstyle.gestionemeteo.applicationlogic.logic.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoHours;
import weatherstyle.gestionemeteo.storage.service.InfoMeteoDailyService;
import weatherstyle.gestionemeteo.storage.service.InfoMeteoDailyImpl;
import weatherstyle.gestionemeteo.storage.service.InfoMeteoHourImpl;
import weatherstyle.gestionemeteo.storage.service.InfoMeteoHourService;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Francesco Giuseppe Zammarrelli
 * La classe Meteo logic service.
 */
public class MeteoLogicService implements MeteoLogicInterface{

    private InfoMeteoDailyService meteoDailyService;
    private InfoMeteoHourService meteoHourService;


    /**
     * Instanzia a new Meteo logic service.
     */
    public MeteoLogicService() {
        this.meteoDailyService =  new InfoMeteoDailyImpl();
        this.meteoHourService =  new InfoMeteoHourImpl();
    }

    /**
     * Instanzia un nuovo Meteo logic service.
     *
     * @param meteoDailyService meteo daily service
     * @param meteoHourService  meteo hour service
     */
    public MeteoLogicService(InfoMeteoDailyService meteoDailyService,InfoMeteoHourService meteoHourService) {
        this.meteoDailyService = meteoDailyService;
        this.meteoHourService = meteoHourService;
    }

    @Override
    public List<MeteoDaily> getMeteoDaily(Citta citta) {
       if (citta != null) {
           if (citta.getLat() != null && citta.getLon() != null && citta.getNome() != null) {

               LocalDate date =  LocalDate.now();
               LocalDate end =  date.plusDays(2);
               List<MeteoDaily> meteoDaily = meteoDailyService.getInfoMeteoDailyByIntervallDay(date,end,citta);

               return meteoDaily;

           } else {
               throw new IllegalArgumentException("Citta non ammissibile");
           }
       } else {
           throw new IllegalArgumentException("Citta non può essere null");
       }
    }

    @Override
    public List<MeteoHours> getMeteoHours(Citta citta) {
        if (citta != null) {
            if (citta.getLat() != null && citta.getLon() != null && citta.getNome() != null) {

            LocalDate date =  LocalDate.now();
            LocalDate end =  date.plusDays(2);
            List<MeteoHours> meteo = meteoHourService.getInfoMeteoHourByRangeOfDays(date,end,citta);

            return meteo;

        } else {
            throw new IllegalArgumentException("Citta non ammissibile");
        }
    } else {
        throw new IllegalArgumentException("Citta non può essere null");
    }
    }


}
