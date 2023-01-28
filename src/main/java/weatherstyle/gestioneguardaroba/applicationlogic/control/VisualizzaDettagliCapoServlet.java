package weatherstyle.gestioneguardaroba.applicationlogic.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.CapoAbbigliamento;
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
        int idCapo = Integer.parseInt(request.getParameter("id"));

        CapoAbbigliamentoDAOInterface dao = new CapoAbbigliamentoDAOImpl();

        CapoAbbigliamento c = dao.doRetrieveCapoById(idCapo);

        request.setAttribute("capo", c);

        RequestDispatcher dispatcher = request.getRequestDispatcher("visualizzaDettagliCapo.jsp");
        dispatcher.forward(request, response);

    }
}
