package weatherstyle.gestionecitta.storage.dao;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;

public interface CittaDAOInterface {

    int doSaveCitta(Citta citta);
    Citta doRetrieveCittaBySuggerimentoID(int idSuggerimento);

}
