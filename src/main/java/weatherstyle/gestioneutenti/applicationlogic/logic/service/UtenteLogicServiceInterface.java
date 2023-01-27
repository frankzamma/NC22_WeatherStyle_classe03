package weatherstyle.gestioneutenti.applicationlogic.logic.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;
import weatherstyle.utils.ErrorParameterException;

import java.time.LocalDate;

public interface UtenteLogicServiceInterface {

    Utente registraUtente(String nome,String cognome,LocalDate dataNascita,
                          String email,String password,Citta citta)  throws ErrorParameterException;
    Utente loginUtente(String username,String password);
    void promuoviUtenteAdEcologista(Utente utente);
    boolean existsUtente(String email);

}
