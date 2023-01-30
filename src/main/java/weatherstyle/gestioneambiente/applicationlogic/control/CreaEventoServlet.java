package weatherstyle.gestioneambiente.applicationlogic.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.io.IOException;

@WebServlet(name = "CreaEventoServlet", value = "/CreaEventoServlet")
public class CreaEventoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utente utente = (Utente)  session.getAttribute("utente");
        if (utente == null){
            response.sendRedirect("index.html");
        }
        else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/gestioneambiente/creaEvento.jsp");
            dispatcher.forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
