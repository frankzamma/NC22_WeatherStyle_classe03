package weatherstyle.gestioneguardaroba.applicationlogic.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.*;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.service.GuardarobaLogicImpl;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.service.GuardarobaLogicInterface;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "VisualizzaGuardaroba", value = "/visualizza-guardaroba")
public class VisualizzaGuardarobaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Utente u = (Utente) session.getAttribute("utente");

        GuardarobaLogicInterface service = new GuardarobaLogicImpl();

        List<Maglia> maglie = service.getMaglie(u.getId());
        List<Pantaloni> pantaloni = service.getPantaloni(u.getId());
        List<Scarpe> scarpe = service.getScarpe(u.getId());
        List<CapoAbbigliamento> all = service.getAll(u.getId());

        Guardaroba g = new Guardaroba();

        g.setMaglie(maglie);
        g.setPantaloni(pantaloni);
        g.setScarpe(scarpe);

        request.setAttribute("guardaroba", g);
        request.setAttribute("all", all);

        RequestDispatcher dispatcher = request.getRequestDispatcher("visualizzaGuardaroba.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
