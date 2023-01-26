package weatherstyle.gestionemeteo.storage.dao;

import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;

public interface MeteoDAOInterface {

    MeteoDaily doRetrieveMeteoBySuggerimentoID(int idSuggerimento);
}
