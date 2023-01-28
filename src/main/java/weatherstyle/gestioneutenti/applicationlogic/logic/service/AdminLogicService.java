package weatherstyle.gestioneutenti.applicationlogic.logic.service;

import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;

public interface AdminLogicService {
    Admin loginAdmin(String email,String password);
}
