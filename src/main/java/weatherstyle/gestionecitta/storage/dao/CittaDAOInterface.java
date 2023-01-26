package weatherstyle.gestionecitta.storage.dao;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;

public interface CittaDAOInterface {

    boolean doSaveCitta(Citta citta);
    Citta doRetrieveCittaBySuggerimentoID(int idSuggerimento);
}
