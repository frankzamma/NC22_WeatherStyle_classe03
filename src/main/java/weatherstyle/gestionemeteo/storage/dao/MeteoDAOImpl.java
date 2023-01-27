package weatherstyle.gestionemeteo.storage.dao;

import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;

public class MeteoDAOImpl implements MeteoDAOInterface{
    @Override
    public MeteoDaily doRetrieveMeteoBySuggerimentoID(int idSuggerimento) {
        return null;
    }

    @Override
    public boolean doSaveMeteo(MeteoDaily meteo) {
        return false;
    }
}
