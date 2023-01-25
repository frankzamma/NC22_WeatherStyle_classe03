package weatherstyle.gestioneutenti.applicationlogic.logic.service;

import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

public interface UtenteLogicServiceInterface {

    boolean registraUtente(Utente utente);
    Utente loginUtente(String username, String password);
    void promuoviUtenteAdEcologista(Utente utente);
    boolean existsUtente(String email);

}
