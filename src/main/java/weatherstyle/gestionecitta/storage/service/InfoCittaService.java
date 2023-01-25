package weatherstyle.gestionecitta.storage.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;

import java.util.List;

public interface InfoCittaService {

    List<Citta> getCittaByName(String name);
}
