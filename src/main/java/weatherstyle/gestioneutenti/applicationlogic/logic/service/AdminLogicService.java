package weatherstyle.gestioneutenti.applicationlogic.logic.service;

import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;

/**
 * @author Francesco Giuseppe Zammarrelli
 * Interfaccia Admin logic service.
 */
public interface AdminLogicService {
    /**
     * Metodo per effettuare il login di un a.
     *
     * @param email    email
     * @param password  password
     * @return l'admin se email e password sono corrette, null altrimenti
     */
    Admin loginAdmin(String email,String password);
}
