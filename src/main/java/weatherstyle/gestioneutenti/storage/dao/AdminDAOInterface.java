package weatherstyle.gestioneutenti.storage.dao;

import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;

/**
 * @author Francesco Giuseppe Zammarrelli
 * Interfaccia Admin dao interface.
 */
public interface AdminDAOInterface {
    /**
     * Trova un admin tramite email e password.
     *
     * @param email     email
     * @param password  password
     * @return Admin se esiste un admin con email <em>email</em> e password <em>password</em>, null altrimenti
     */
    Admin doRetrieveAdminByEmailAndPassword(String email,String password);

    /**
     * Trova un admin tramite id.
     *
     * @param id id
     * @return Admin se esiste un admin con id <em>id</em>, null altrimenti.
     */
    Admin doRetrieveAdminById(int id);
}
