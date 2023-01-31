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

@WebServlet(name = "VisualizzaGuardaroba",value = "/visualizza-guardaroba")
public class VisualizzaGuardarobaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Utente u = (Utente) session.getAttribute("utente");
        if (u != null) {
            GuardarobaLogicInterface service = new GuardarobaLogicImpl();

            List<CapoAbbigliamento> all = service.getAll(u.getId());

            request.setAttribute("all",all);
            request.setAttribute("utente",u);


            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/gestioneguardaroba/visualizzaGuardaroba.jsp");
            dispatcher.forward(request,response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/gestioneUtente/utente/login_utente.jsp");
            dispatcher.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {



    }
}
