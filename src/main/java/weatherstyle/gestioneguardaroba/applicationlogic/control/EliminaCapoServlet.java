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

@WebServlet(name = "EliminaCapoServlet", value = "/elimina-capo")
public class EliminaCapoServlet extends HttpServlet {
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
            dao.deleteMaglia(Integer.parseInt(idMaglia));
        }

        if (idPantaloni!=null) {
            dao.deletePantaloni(Integer.parseInt(idPantaloni));
        }

        if (idScarpe!=null){
            dao.deleteScarpe(Integer.parseInt(idScarpe));
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("visualizzaDettagliCapo.jsp");
        dispatcher.forward(request, response);
    }
}
