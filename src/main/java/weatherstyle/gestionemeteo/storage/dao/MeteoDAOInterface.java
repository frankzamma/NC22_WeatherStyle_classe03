package weatherstyle.gestionemeteo.storage.dao;

import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDailyMin;

public interface MeteoDAOInterface {

    MeteoDailyMin doRetrieveMeteoBySuggerimentoID(int idSuggerimento);
    boolean doSaveMeteo(MeteoDailyMin meteo);
}
