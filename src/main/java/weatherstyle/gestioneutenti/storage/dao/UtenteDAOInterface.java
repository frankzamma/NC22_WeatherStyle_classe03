package weatherstyle.gestioneutenti.storage.dao;

import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

/**
 * @author Francesco Giuseppe Zammarrelli
 * Interfaccia Utente dao interface.
 */
public interface UtenteDAOInterface {
    /**
     * Salva un utente nel database
     *
     * @param utente utente
     * @return True se l'operazione va a buon fine, false altrimenti
     */
    boolean doSaveUtente(Utente utente);

    /**
     * Trova un utente tramite id
     *
     * @param id  id
     * @return  utente se esiste un utente con id <em>id</em>, null altrimenti
     */
    Utente doRetrieveUtenteByID(int id);

    /**
     * Trova un utente tramite email e password
     *
     * @param email email
     * @param password password
     * @return utente
     */
    Utente doRetrieveUtenteByUsernameAndPassword(String email,String password);

    /**
     * Verifica se esiste un utente con email <em>email</em>.
     *
     * @param email email
     * @return true se esiste un utente con email <em>email</em>
     */
    boolean doExistsEmail(String email);

    /**
     * Metodo per promuovere ad un utente a ecologista
     *
     * @param u  utente
     * @return true se l'operazione va buon fine, false altrimenti.
     */
    boolean doUpdateUtenteToEcologista(Utente u);

}
