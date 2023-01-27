package weatherstyle.gestionecitta.applicationlogic.logic.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionecitta.storage.dao.CittaDAOInterface;
import weatherstyle.gestionecitta.storage.service.InfoCittaService;

import java.util.List;

/**
 * @author Raffaele Aurucci
 * classe che offre servizi alle servlet in merito alle città
 */
public class CittaLogicImpl implements CittaLogicService {

    /**
     * interfaccia verso il DB
     */
    private final CittaDAOInterface cittaDAO;

    /**
     * interfaccia adapter verso l'API città
     */
    private final InfoCittaService infoCittaService;

    public CittaLogicImpl(CittaDAOInterface cittaDAO, InfoCittaService infoCittaService) {
        this.cittaDAO = cittaDAO;
        this.infoCittaService = infoCittaService;
    }

    /**
     * metodo che permette di salvare una citta nel DB
     * @param citta che si vuole salvare dopo aver ricevuto un suggerimento
     * @throws IllegalArgumentException se città è null
     * @return true se è stato possibile salvare la città, false altrimenti
     */
    @Override
    public boolean salvaCitta(Citta citta) {
        if (citta == null) {
            throw new IllegalArgumentException("Città non può essere null");
        }

        return cittaDAO.doSaveCitta(citta);
    }

    /**
     * metodo che permette di ottenere una lista di citta rispetto al nome inserito dall'utente
     * @param name della città ricercata
     * @throws IllegalArgumentException se città è null
     * @return lista di città con name passata in input
     */
    @Override
    public List<Citta> ottieniCittaByName(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Stringa name troppo corta o null");
        }

        return infoCittaService.getCittaByName(name);
    }
}
