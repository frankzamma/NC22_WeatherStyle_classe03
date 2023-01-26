package weatherstyle.gestioneutenti.applicationlogic.logic.service;

import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

public class UtenteLogicService implements UtenteLogicServiceInterface{
    @Override
    public boolean registraUtente(Utente utente) {
        return false;
    }

    @Override
    public Utente loginUtente(String username, String password) {
        return null;
    }

    @Override
    public void promuoviUtenteAdEcologista(Utente utente) {

    }

    @Override
    public boolean existsUtente(String email) {
        return false;
    }
}
