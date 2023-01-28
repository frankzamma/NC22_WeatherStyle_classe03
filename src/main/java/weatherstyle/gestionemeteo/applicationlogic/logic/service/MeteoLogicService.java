package weatherstyle.gestionemeteo.applicationlogic.logic.service;

import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDailyMin;
import weatherstyle.gestionemeteo.storage.dao.MeteoDAOInterface;

public class MeteoLogicService implements MeteoLogicInterface{

    private MeteoDAOInterface meteoDAOInterface;

    public MeteoLogicService(MeteoDAOInterface meteoDAOInterface){
        this.meteoDAOInterface = meteoDAOInterface;
    }
    @Override
    public boolean salvaMeteo(MeteoDailyMin meteoDailyMin) {
       if(meteoDailyMin != null){
           if(meteoDailyMin.getMeteoStringMin() != null && meteoDailyMin.getStagionePrevisione() != null) {
               return meteoDAOInterface.doSaveMeteo(meteoDailyMin);
           }else{
               throw new IllegalArgumentException("meteoDailyMin non ammissibile");
           }
       }else{
           throw new IllegalArgumentException("meteoDailyMin non può essere null");
       }
    }
}
