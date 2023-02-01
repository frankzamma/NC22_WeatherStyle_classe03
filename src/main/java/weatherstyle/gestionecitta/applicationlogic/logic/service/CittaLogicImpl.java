package weatherstyle.gestionecitta.applicationlogic.logic.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionecitta.storage.dao.CittaDAOInterface;
import weatherstyle.gestionecitta.storage.service.InfoCittaService;

import java.lang.reflect.Type;
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

    public CittaLogicImpl(CittaDAOInterface cittaDAO,InfoCittaService infoCittaService) {
        this.cittaDAO = cittaDAO;
        this.infoCittaService = infoCittaService;
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

    /**
     * metodo che ritorna una stringa json da una lista di cittò
     * @param cittaList lista di citta che si vuole definire in JSON
     * @return stringa json se cittaList contiene almeno una citta, altrimenti stringa vuota
     */
    @Override
    public String ottieniJsonDaCitta(List<Citta> cittaList) {
        if (cittaList == null || cittaList.size() == 0) {
            return "";
        }
        Type listType = new TypeToken<List<Citta>>() {
        }.getType();
        Gson gson = new Gson();
        return gson.toJson(cittaList,listType);
    }
}
