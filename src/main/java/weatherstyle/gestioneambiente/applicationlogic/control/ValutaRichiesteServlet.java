package weatherstyle.gestioneambiente.applicationlogic.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestioneambiente.applicationlogic.logic.beans.RichiestaPromozione;
import weatherstyle.gestioneambiente.applicationlogic.logic.service.RichiestaPromozioneLogicImpl;
import weatherstyle.gestioneambiente.applicationlogic.logic.service.RichiestaPromozioneLogicInterface;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;

import javax.sound.midi.SysexMessage;
import java.io.IOException;

@WebServlet(name = "ValutaRichiesteServlet", value = "/ValutaRichiesteServlet")
public class ValutaRichiesteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idRichiestaPromozione =  Integer.parseInt(request.getParameter("idRichiestaPromozione"));
        String nuovoStato = request.getParameter("valutazione");
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");

        RichiestaPromozioneLogicInterface richiestaPromozioneLogic = new RichiestaPromozioneLogicImpl();
        RichiestaPromozione richiestaPromozione = richiestaPromozioneLogic.ottieniRichiestaPromozionePerId(idRichiestaPromozione);
        richiestaPromozioneLogic.aggiornaStatoRichiestaPromozione(richiestaPromozione, nuovoStato, admin);

        RequestDispatcher dispatcher = request.getRequestDispatcher("GestioneRichiesteServlet");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
