package weatherstyle.gestioneutenti.storage.dao;

import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;

public interface AdminDAOInterface {
    Admin doRetrieveAdminByEmailAndPassword(String email, String password);
    Admin doRetrieveAdminById(int id);
}
