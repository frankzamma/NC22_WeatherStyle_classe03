package weatherstyle.gestionemeteo.storage.dao;

import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDailyMin;

/**
 * @author Francesco Giuseppe Zammarrelli
 * Interfaccia per i metodi del package gestionemeteo.storage.dao
 */
public interface MeteoDAOInterface {
    MeteoDailyMin doRetrieveMeteoBySuggerimentoID(int idSuggerimento);
    boolean doSaveMeteo(MeteoDailyMin meteo);
}
