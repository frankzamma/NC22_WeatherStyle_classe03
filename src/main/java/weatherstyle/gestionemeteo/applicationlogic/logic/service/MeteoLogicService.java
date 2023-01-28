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
        return false;
    }
}
