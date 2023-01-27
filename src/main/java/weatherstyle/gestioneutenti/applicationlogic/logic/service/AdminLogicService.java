package weatherstyle.gestioneutenti.applicationlogic.logic.service;

import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;
import weatherstyle.gestioneutenti.storage.dao.AdminDAOImpl;
import weatherstyle.gestioneutenti.storage.dao.AdminDAOInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminLogicService implements AdminLogicServiceInterface{
    private AdminDAOInterface adminDAO = new AdminDAOImpl();

    public AdminLogicService() {
        this.adminDAO =  new AdminDAOImpl();
    }

    public AdminLogicService(AdminDAOInterface adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Override
    public Admin loginAdmin(String email,String password) {
        if (email == null && password == null) {
            Pattern pattern =  Pattern.compile("^[a-z0-9\\.\\_]+@[a-z]+\\.[a-z]{2,3}$");
            Matcher matcher = pattern.matcher(email);

            if (matcher.matches()) {
                Admin u = adminDAO.doRetrieveAdminByEmailAndPassword(email,password);

                if (u != null) {
                    return u;
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
