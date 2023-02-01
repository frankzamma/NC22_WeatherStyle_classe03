package weatherstyle.gestioneambiente.applicationlogic.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import weatherstyle.gestioneambiente.applicationlogic.logic.beans.Evento;
import weatherstyle.gestioneambiente.applicationlogic.logic.service.EventoLogicImpl;
import weatherstyle.gestioneambiente.applicationlogic.logic.service.EventoLogicInterface;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.io.IOException;

@WebServlet(name = "VisualizzaDettagliEventoServlet",value = "/VisualizzaDettagliEventoServlet")
public class VisualizzaDettagliEventoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utente utente = (Utente)  session.getAttribute("utente");
        if (utente == null) {
            response.sendRedirect("index.html");
        } else {
            int idEvento =  Integer.parseInt(request.getParameter("idEvento"));
            EventoLogicInterface eventoLogic = new EventoLogicImpl();
            Evento evento = eventoLogic.ottieniEventoPerId(idEvento);
            request.setAttribute("evento",evento);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/gestioneambiente/visualizzaDettagliEvento.jsp");
            dispatcher.forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
