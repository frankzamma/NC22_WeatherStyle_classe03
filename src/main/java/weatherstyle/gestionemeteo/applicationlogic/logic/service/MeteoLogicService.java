package weatherstyle.gestionemeteo.applicationlogic.logic.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoHours;
import weatherstyle.gestionemeteo.storage.dao.MeteoDAOImpl;
import weatherstyle.gestionemeteo.storage.dao.MeteoDAOInterface;
import weatherstyle.gestionemeteo.storage.service.InfoMeteoDailyService;
import weatherstyle.gestionemeteo.storage.service.InfoMeteoDailyiImpl;
import weatherstyle.gestionemeteo.storage.service.InfoMeteoHourImpl;
import weatherstyle.gestionemeteo.storage.service.InfoMeteoHourService;

import java.time.LocalDate;
import java.util.List;

public class MeteoLogicService implements MeteoLogicInterface{

    private MeteoDAOInterface meteoDAOInterface;
    private InfoMeteoDailyService meteoDailyService;
    private InfoMeteoHourService meteoHourService;


    public MeteoLogicService() {
        this.meteoDAOInterface = new MeteoDAOImpl();
        this.meteoDailyService =  new InfoMeteoDailyiImpl();
        this.meteoHourService =  new InfoMeteoHourImpl();
    }
    public MeteoLogicService(MeteoDAOInterface meteoDAOInterface,
                             InfoMeteoDailyService meteoDailyService, InfoMeteoHourService meteoHourService) {
        this.meteoDAOInterface = meteoDAOInterface;
        this.meteoDailyService = meteoDailyService;
        this.meteoHourService = meteoHourService;
    }

    public MeteoLogicService(MeteoDAOInterface meteoDAOInterface){
        this.meteoDAOInterface = meteoDAOInterface;
        this.meteoDailyService =  new InfoMeteoDailyiImpl();
        this.meteoHourService =  new InfoMeteoHourImpl();
    }



    @Override
    public List<MeteoDaily> getMeteoDaily(Citta citta) {
       if(citta != null){
           if(citta.getLat() != null && citta.getLon() != null && citta.getNome() != null){

               LocalDate date =  LocalDate.now();
               LocalDate end =  date.plusDays(2);
               List<MeteoDaily> meteoDaily = meteoDailyService.getInfoMeteoDailyByIntervallDay(date, end, citta);

               return meteoDaily;

           }else {
               throw new IllegalArgumentException("Citta non ammissibile");
           }
       }else{
           throw new IllegalArgumentException("Citta non può essere null");
       }
    }

    @Override
    public List<MeteoHours> getMeteoHours(Citta citta) {
        if(citta != null){
            if(citta.getLat() != null && citta.getLon() != null && citta.getNome() != null){

            LocalDate date =  LocalDate.now();
            LocalDate end =  date.plusDays(2);
            List<MeteoHours> meteo = meteoHourService.getInfoMeteoHourByRangeOfDays(date, end, citta);

            return meteo;

        }else {
            throw new IllegalArgumentException("Citta non ammissibile");
        }
    }else{
        throw new IllegalArgumentException("Citta non può essere null");
    }
    }


}
