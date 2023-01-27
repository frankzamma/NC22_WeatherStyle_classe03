package weatherstyle.gestionecitta.storage.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;

import java.util.List;

/**
 * @author Raffaele Aurucci
 * interfaccia che definisce i metodi dell'adapter all'API per le città
 */
public interface InfoCittaService {

    List<Citta> getCittaByName(String name);
}
