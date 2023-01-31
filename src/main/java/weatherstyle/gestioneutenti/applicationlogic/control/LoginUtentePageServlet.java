package weatherstyle.gestioneutenti.applicationlogic.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.io.IOException;

/**
 * @author Francesco Giuseppe Zammarrelli
 * La classe Login utente page servlet.
 */
@WebServlet(name = "LoginUtentePageServlet",value = "/login-page")
public class LoginUtentePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =  request.getSession();

        Utente u =  (Utente) session.getAttribute("utente");

        if (u == null) {
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/WEB-INF/gestioneUtente/utente/login_utente.jsp");

            dispatcher.forward(request,response);
        } else {
            response.sendRedirect("index.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
}
