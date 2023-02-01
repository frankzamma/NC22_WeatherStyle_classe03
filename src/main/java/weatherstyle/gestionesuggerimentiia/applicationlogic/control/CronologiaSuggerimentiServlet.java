package weatherstyle.gestionesuggerimentiia.applicationlogic.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Suggerimento;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.service.SuggerimentoLogicImpl;
import weatherstyle.gestionesuggerimentiia.storage.dao.OutfitDAOImpl;
import weatherstyle.gestionesuggerimentiia.storage.dao.SuggerimentoDAOImpl;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.io.IOException;
import java.util.List;

/**
 * @author Raffaele Aurucci
 * servlet che si occupa di recuperare la cronologia dei suggerimenti forniti all'utente nel corso dell'utilizzo del
 * sistema
 */
@WebServlet(name = "CronologiaSuggerimentiServlet",value = "/CronologiaSuggerimentiServlet")
public class CronologiaSuggerimentiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        SuggerimentoLogicImpl suggerimentoLogic = new SuggerimentoLogicImpl(
                new SuggerimentoDAOImpl(),new OutfitDAOImpl());

        Utente utente = (Utente) request.getSession(false).getAttribute("utente");

        List<Suggerimento> suggerimentoList = suggerimentoLogic.ottieniCronologiaSuggerimentiUtente(utente.getId());

        // invio della lista di suggerimenti contenenti tutti i dettagli relativi a un suggerimento
        request.setAttribute("suggerimentoList",suggerimentoList);

        request.getRequestDispatcher("/WEB-INF/gestionesuggerimentiia/"
                + "visualizzaCronologiaSuggerimenti.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
}
