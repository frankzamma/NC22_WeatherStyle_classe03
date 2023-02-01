package weatherstyle.gestioneambiente.applicationlogic.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import weatherstyle.gestioneambiente.applicationlogic.logic.beans.RichiestaPromozione;
import weatherstyle.gestioneambiente.applicationlogic.logic.service.RichiestaPromozioneLogicImpl;
import weatherstyle.gestioneambiente.applicationlogic.logic.service.RichiestaPromozioneLogicService;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;
import java.io.IOException;

/**
 * @author angelopalmieri
 * Servlet che si occupa di aggiornare lo stato di una richiesta di promozione in "approvata" o "rifiutata".
 */
@WebServlet(name = "ValutaRichiesteServlet",value = "/ValutaRichiesteServlet")
public class ValutaRichiesteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            response.sendRedirect("index.html");
        } else {
            int idRichiestaPromozione =  Integer.parseInt(request.getParameter("idRichiestaPromozione"));
            String nuovoStato = request.getParameter("valutazione");

            RichiestaPromozioneLogicService richiestaPromozioneLogic = new RichiestaPromozioneLogicImpl();
            RichiestaPromozione richiestaPromozione = richiestaPromozioneLogic.ottieniRichiestaPromozionePerId(idRichiestaPromozione);
            richiestaPromozioneLogic.aggiornaStatoRichiestaPromozione(richiestaPromozione,nuovoStato,admin);

            RequestDispatcher dispatcher = request.getRequestDispatcher("GestioneRichiesteServlet");
            dispatcher.forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
