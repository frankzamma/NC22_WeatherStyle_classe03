package weatherstyle.gestioneguardaroba.applicationlogic.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Guardaroba;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.service.CapoAbbigliamentoLogicServiceInterface;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.service.CapoAbbigliamentoService;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "VisualizzaGuardaroba", value = "/visualizza-guardaroba")
public class VisualizzaGuardarobaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO Dopo il login, controllare se l'utente è loggato

        HttpSession session = request.getSession();

        Utente u = (Utente) session.getAttribute("utente");

        CapoAbbigliamentoLogicServiceInterface service = new CapoAbbigliamentoService();

        List<Maglia> maglie = service.getMaglie(u.getId());
        List<Pantaloni> pantaloni = service.getPantaloni(u.getId());
        List<Scarpe> scarpe = service.getScarpe(u.getId());

        Guardaroba g = new Guardaroba();

        g.setMaglie(maglie);
        g.setPantaloni(pantaloni);
        g.setScarpe(scarpe);

        request.setAttribute("guardaroba", g);

        RequestDispatcher dispatcher = request.getRequestDispatcher("visualizzaGuardaroba.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
