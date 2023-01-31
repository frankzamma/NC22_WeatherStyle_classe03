package weatherstyle.gestioneambiente.applicationlogic.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestioneambiente.applicationlogic.logic.beans.RichiestaPromozione;
import weatherstyle.gestioneambiente.applicationlogic.logic.service.RichiestaPromozioneLogicImpl;
import weatherstyle.gestioneambiente.applicationlogic.logic.service.RichiestaPromozioneLogicInterface;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.io.IOException;

@WebServlet(name = "SalvaRichiestaPromozioneServlet", value = "/SalvaRichiestaPromozioneServlet")
public class SalvaRichiestaPromozioneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utente u  = (Utente) session.getAttribute("utente");
        if (u == null)
            response.sendRedirect("index.html");
        else {

            String[] tematiche = request.getParameterValues("tematiche");
            String s = "";
            if(tematiche != null) {
                for(int i=0; i<tematiche.length; i++)
                    s += tematiche[i] + " - ";
            }

            String esperienze = request.getParameter("esperienze");

            RichiestaPromozioneLogicInterface richiestaPromozioneLogic = new RichiestaPromozioneLogicImpl();
                RequestDispatcher dispatcher;

                Utente utente = (Utente) session.getAttribute("utente");
                RichiestaPromozione richiestaPromozione = new RichiestaPromozione();
                richiestaPromozione.setTematiche(s);
                richiestaPromozione.setEsperienze(esperienze);
                richiestaPromozione.setUtente(utente);

                try {
                        richiestaPromozioneLogic.salvaRichiestaPromozione(richiestaPromozione);
                        dispatcher = request.getRequestDispatcher("/WEB-INF/gestioneUtente/utente/areaPersonale.jsp");
                        dispatcher.forward(request, response);
                }catch (IllegalArgumentException e) {
                    request.setAttribute("Errore", e.getMessage());
                    dispatcher = request.getRequestDispatcher("/WEB-INF/gestioneambiente/compilaRichiestaPromozione.jsp");
                    dispatcher.forward(request, response);
                }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
