package weatherstyle.gestioneambiente.applicationlogic.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestioneambiente.applicationlogic.logic.beans.RichiestaPromozione;
import weatherstyle.gestioneambiente.applicationlogic.logic.service.RichiestaPromozioneLogicImpl;
import weatherstyle.gestioneambiente.applicationlogic.logic.service.RichiestaPromozioneLogicInterface;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GestioneRichiesteServlet", value = "/GestioneRichiesteServlet")
public class GestioneRichiesteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RichiestaPromozioneLogicInterface richiestaPromozioneLogic = new RichiestaPromozioneLogicImpl();
        List<RichiestaPromozione> listaRichiestePromozione = richiestaPromozioneLogic.ottieniListaRichiestePromozionePerStato("in attesa");
        request.setAttribute("listaRichiestePromozione", listaRichiestePromozione);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/gestioneambiente/gestioneRichieste.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
