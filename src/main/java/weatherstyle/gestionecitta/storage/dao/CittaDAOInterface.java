package weatherstyle.gestionecitta.storage.dao;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;

import java.util.List;

public interface CittaDAOInterface {

    boolean doSaveCitta(Citta citta);
    Citta doRetrieveCittaBySuggerimentoID(int idSuggerimento);
    List<Citta> doRetrieveCittaByUtenteID(int idUtente);
    boolean doSaveCittaUtente(int idUtente,Citta citta);
}
