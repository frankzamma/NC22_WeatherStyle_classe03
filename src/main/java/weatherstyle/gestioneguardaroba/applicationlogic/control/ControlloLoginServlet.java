package weatherstyle.gestioneguardaroba.applicationlogic.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.io.IOException;

@WebServlet(name = "ControlloLoginServlet", value = "/controllo-login")
public class ControlloLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Utente u = (Utente) session.getAttribute("utente");

        String address;

        if (u!=null){
            address = "loadCapoAbbigliamento.jsp";
        }else{
            address = "/WEB-INF/gestioneUtente/utente/login_utente.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
