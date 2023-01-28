package weatherstyle.gestioneutenti.storage.dao;

import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

public interface UtenteDAOInterface {
    boolean doSaveUtente(Utente utente);
    Utente doRetrieveUtenteByID(int id);
    Utente doRetrieveUtenteByUsernameAndPassword(String email,String password);
    boolean doExistsEmail(String email);

    boolean doUpdateUtenteToEcologista(Utente u);

}
