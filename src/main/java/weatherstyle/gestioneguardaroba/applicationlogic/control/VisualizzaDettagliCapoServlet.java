package weatherstyle.gestioneguardaroba.applicationlogic.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;
import weatherstyle.gestioneguardaroba.storage.dao.CapoAbbigliamentoDAOImpl;
import weatherstyle.gestioneguardaroba.storage.dao.CapoAbbigliamentoDAOInterface;

import java.io.IOException;

@WebServlet(name = "VisualizzaDettagliCapoServlet", value = "/visualizza-dettagli-capo")
public class VisualizzaDettagliCapoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idMaglia = request.getParameter("idMaglia");
        String idPantaloni = request.getParameter("idPantaloni");
        String idScarpe = request.getParameter("idScarpe");

        CapoAbbigliamentoDAOInterface dao = new CapoAbbigliamentoDAOImpl();

        if (idMaglia!=null){
            Maglia m = dao.doRetrieveMagliaByIdCapoAbbigliamento(Integer.parseInt(idMaglia));
            request.setAttribute("maglia", m);
        }

        if (idPantaloni!=null) {
            Pantaloni p = dao.doRetrievePantaloniByIdCapoAbbigliamento(Integer.parseInt(idPantaloni));
            request.setAttribute("pantaloni", p);
        }

        if (idScarpe!=null){
            Scarpe s = dao.doRetrieveScarpeByIdCapoAbbigliamento(Integer.parseInt(idScarpe));
            request.setAttribute("scarpe", s);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("visualizzaDettagliCapo.jsp");
        dispatcher.forward(request, response);


    }
}
