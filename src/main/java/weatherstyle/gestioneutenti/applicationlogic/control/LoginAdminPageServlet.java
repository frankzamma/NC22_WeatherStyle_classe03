package weatherstyle.gestioneutenti.applicationlogic.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.io.IOException;

/**
 * @author Francesco Giuseppe Zammarrelli
 * La classe Login admin page servlet.
 */
@WebServlet(name = "LoginAdminPageServlet", value = "/login-admin-page")
public class LoginAdminPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =  request.getSession();

        Admin admin =  (Admin) session.getAttribute("admin");
        Utente utente = (Utente) session.getAttribute("utente");
        if(admin == null && utente == null){
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/WEB-INF/gestioneUtente/admin/login_admin.jsp");
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect("index.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
