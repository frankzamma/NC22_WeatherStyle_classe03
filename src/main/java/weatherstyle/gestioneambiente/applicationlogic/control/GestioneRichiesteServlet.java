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
import java.util.List;

/**
 * @author angelopalmieri
 * Servlet che si occupa d'indirizzare l'admin verso gestioneRichieste.jsp.
 * Li sarò possibile per gli admin visualizzare le varie richieste di promozione
 * in ecologista, e scegliere quale approvare e quali rifiutare.
 */
@WebServlet(name = "GestioneRichiesteServlet",value = "/GestioneRichiesteServlet")
public class GestioneRichiesteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin admin = (Admin)  session.getAttribute("admin");
        if (admin == null) {
            response.sendRedirect("index.html");
        } else {
            RichiestaPromozioneLogicService richiestaPromozioneLogic = new RichiestaPromozioneLogicImpl();
            List<RichiestaPromozione> listaRichiestePromozione = richiestaPromozioneLogic.ottieniListaRichiestePromozionePerStato("in attesa");
            request.setAttribute("listaRichiestePromozione",listaRichiestePromozione);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/gestioneambiente/gestioneRichieste.jsp");
            dispatcher.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
