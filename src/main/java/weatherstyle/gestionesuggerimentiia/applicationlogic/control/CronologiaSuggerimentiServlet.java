package weatherstyle.gestionesuggerimentiia.applicationlogic.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Suggerimento;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.service.SuggerimentoLogicImpl;
import weatherstyle.gestionesuggerimentiia.storage.dao.OutfitDAOImpl;
import weatherstyle.gestionesuggerimentiia.storage.dao.SuggerimentoDAOImpl;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CronologiaSuggerimentiServlet", value = "/CronologiaSuggerimentiServlet")
public class CronologiaSuggerimentiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SuggerimentoLogicImpl suggerimentoLogic = new SuggerimentoLogicImpl(
                new SuggerimentoDAOImpl(), new OutfitDAOImpl());

        Utente utente = (Utente) request.getSession(false).getAttribute("utente");

        List<Suggerimento> suggerimentoList = suggerimentoLogic.ottieniCronologiaSuggerimentiUtente(utente.getId());
        System.out.println(suggerimentoList);

        request.getRequestDispatcher("/WEB-INF/visualizzaCronologiaSuggerimenti.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
}
