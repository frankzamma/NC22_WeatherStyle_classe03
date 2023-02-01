package weatherstyle.gestioneutenti.applicationlogic.logic.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;
import weatherstyle.utils.ErrorParameterException;

import java.time.LocalDate;

/**
 * Interfaccia Utente logic service.
 */
public interface UtenteLogicService {

    /**
     * Meteodo per registrare un utente.
     *
     * @param nome        nome
     * @param cognome     cognome
     * @param dataNascita data nascita
     * @param email       email
     * @param password    password
     * @param citta       citta
     * @return Metodo per registrare un nuovo utente
     * @throws ErrorParameterException nel caso i parametri non siano ammissibili
     */
    Utente registraUtente(String nome,String cognome,LocalDate dataNascita,
            String email,String password,Citta citta)  throws ErrorParameterException;

    /**
     * Metodo per effettuare il login di un utente.
     * @param email email
     * @param password password
     * @return utente
     */
    Utente loginUtente(String email,String password);

    /**
     * Metodo per verificare se esiste già un utente registrato con la mail.
     *
     * @param email email
     * @return true se esiste un utente registrato con quella email, false altrimenti.
     */
    boolean existsUtente(String email);

}
