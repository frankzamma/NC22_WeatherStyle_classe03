package weatherstyle.gestioneutenti.applicationlogic.logic.service;

import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;
import weatherstyle.gestioneutenti.storage.dao.AdminDAOImpl;
import weatherstyle.gestioneutenti.storage.dao.AdminDAOInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Francesco Giuseppe Zammarrelli La classe Admin logic.
 */
public class AdminLogicImpl implements AdminLogicService {
    private AdminDAOInterface adminDAO = new AdminDAOImpl();

    /**
     * Instanzia a new AdminlogicImp.
     */
    public AdminLogicImpl() {
        this.adminDAO =  new AdminDAOImpl();
    }

    /**
     * Instanzia a new AdminlogicImp.
     *
     * @param adminDAO admin dao
     */
    public AdminLogicImpl(AdminDAOInterface adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Override
    public Admin loginAdmin(String email,String password) {
        if (email != null && password != null) {
            Pattern pattern =  Pattern.compile("^[a-z0-9\\.\\_]+@[a-z]+\\.[a-z]{2,3}$");
            Matcher matcher = pattern.matcher(email);

            if (matcher.matches()) {
                Admin a = new Admin();
                a.setPassword(password);
                a = adminDAO.doRetrieveAdminByEmailAndPassword(email,a.getPassword());
                if (a != null) {
                    return a;
                } else {
                    throw new IllegalArgumentException("Email e/o password non corretti");
                }
            } else {
                throw new IllegalArgumentException("Formato email non corretto");
            }
        } else {
            throw new IllegalArgumentException("Email e/o password richiesti per accedere!");
        }
    }
}
