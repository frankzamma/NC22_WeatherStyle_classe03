package weatherstyle.gestionecitta.applicationlogic.logic.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionecitta.storage.dao.CittaDAOInterface;
import weatherstyle.gestionecitta.storage.service.InfoCittaService;

import java.util.ArrayList;
import java.util.List;

public class CittaLogicService implements CittaLogicInterface{

    private final CittaDAOInterface cittaDAO;
    private final InfoCittaService infoCittaService;

    public CittaLogicService(CittaDAOInterface cittaDAO, InfoCittaService infoCittaService){
        this.cittaDAO= cittaDAO;
        this.infoCittaService = infoCittaService;
    }

    @Override
    public boolean salvaCitta(Citta citta) {
        if (citta == null)
            throw new IllegalArgumentException("Città non può essere null");

        if (cittaDAO.doRetrieveCittaByLatLon(citta.getLat(), citta.getLon()))
            return false;

        return cittaDAO.doSaveCitta(citta);
    }

    @Override
    public List<Citta> recuperaCittaDaSuggerimentiID(List<Integer> idSuggerimenti) {
        if (idSuggerimenti == null || idSuggerimenti.size() == 0)
            throw new IllegalArgumentException("Lista id suggerimenti vuota o null");

        List<Citta> cittaList = new ArrayList<>();

        for (Integer id: idSuggerimenti){
            Citta citta = cittaDAO.doRetrieveCittaBySuggerimentoID(id);
            cittaList.add(citta);
        }

        return cittaList;
    }

    @Override
    public List<Citta> ottieniCittaByName(String name) {
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException("Stringa name troppo corta o null");

        return infoCittaService.getCittaByName(name);
    }
}
