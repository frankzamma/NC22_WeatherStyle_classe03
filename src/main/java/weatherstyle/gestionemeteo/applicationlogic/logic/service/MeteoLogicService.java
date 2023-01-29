package weatherstyle.gestionemeteo.applicationlogic.logic.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDailyMin;
import weatherstyle.gestionemeteo.storage.dao.MeteoDAOImpl;
import weatherstyle.gestionemeteo.storage.dao.MeteoDAOInterface;
import weatherstyle.gestionemeteo.storage.service.InfoMeteoDailyService;
import weatherstyle.gestionemeteo.storage.service.InfoMeteoDailyiImpl;

import java.time.LocalDate;

public class MeteoLogicService implements MeteoLogicInterface{

    private MeteoDAOInterface meteoDAOInterface;
    private InfoMeteoDailyService meteoDailyService;


    public MeteoLogicService() {
        this.meteoDAOInterface = new MeteoDAOImpl();
        this.meteoDailyService =  new InfoMeteoDailyiImpl();
    }
    public MeteoLogicService(MeteoDAOInterface meteoDAOInterface, InfoMeteoDailyService meteoDailyService) {
        this.meteoDAOInterface = meteoDAOInterface;
        this.meteoDailyService = meteoDailyService;
    }

    public MeteoLogicService(MeteoDAOInterface meteoDAOInterface){
        this.meteoDAOInterface = meteoDAOInterface;
        this.meteoDailyService =  new InfoMeteoDailyiImpl();
    }

    @Override
    public MeteoDaily getMeteoDaily(Citta citta) {
       if(citta != null){
           if(citta.getLat() != null && citta.getLon() != null && citta.getNome() != null){

               LocalDate date =  LocalDate.now();
               MeteoDaily meteoDaily = meteoDailyService.getInfoMeteoDailyByDay(date, citta);

               return meteoDaily;
           }else {
               throw new IllegalArgumentException("Citta non ammissibile");
           }
       }else{
           throw new IllegalArgumentException("Citta non può essere null");
       }
    }
}
