package weatherstyle.gestioneambiente.applicationlogic.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.io.IOException;

/**
 * @author angelopalmieri
 * Servlet che si occupa d'indirizzare l'utente verso compilaRichiestaPromozione.jsp.
 * Li sarà possibile, per gli utenti, compilare i vari campi necessari per richiedere
 * la promozione in ecologista.
 */
@WebServlet(name = "RichiestaPromozioneServlet",value = "/RichiestaPromozioneServlet")
public class RichiestaPromozioneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utente utente = (Utente)  session.getAttribute("utente");
        if (utente == null || utente.isEcologista()) {
            response.sendRedirect("index.html");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/gestioneambiente/compilaRichiestaPromozione.jsp");
            dispatcher.forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
