package weatherstyle.gestioneutenti.applicationlogic.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;
import weatherstyle.gestioneutenti.applicationlogic.logic.service.UtenteLogicImpl;

import java.io.IOException;

/**
 * @author Francesco Giuseppe Zammarrelli
 * La classe Login utente servlet.
 */
@WebServlet(name = "LoginUtenteServlet",value = "/login-utente")
public class LoginUtenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login-page");
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Utente u = (Utente) session.getAttribute("utente");

        if (u == null) {
            String email =  request.getParameter("email");
            String password =  request.getParameter("password");
            UtenteLogicImpl service =  new UtenteLogicImpl();
            try {
                u = service.loginUtente(email,password);

                session.setAttribute("utente",u);

                response.sendRedirect("index.html");
            } catch (IllegalArgumentException e) {
                String message =  e.getMessage();

                request.setAttribute("error-message",message);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/gestioneUtente/utente/login_utente.jsp");

                dispatcher.forward(request,response);
            }
        } else {
            response.sendRedirect("index.html");
        }
    }
}
