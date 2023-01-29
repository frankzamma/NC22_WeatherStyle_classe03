package weatherstyle.gestioneambiente.applicationlogic.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestioneambiente.applicationlogic.logic.beans.Evento;
import weatherstyle.gestioneambiente.applicationlogic.logic.service.EventoLogicImpl;
import weatherstyle.gestioneambiente.applicationlogic.logic.service.EventoLogicInterface;

import java.io.IOException;

@WebServlet(name = "VisualizzaDettagliEventoServlet", value = "/VisualizzaDettagliEventoServlet")
public class VisualizzaDettagliEventoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idEvento =  Integer.parseInt(request.getParameter("idEvento"));
        EventoLogicInterface eventoLogic = new EventoLogicImpl();
        Evento evento = eventoLogic.ottieniEventoPerId(idEvento);
        request.setAttribute("evento", evento);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/gestioneambiente/visualizzaDettagliEvento.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
