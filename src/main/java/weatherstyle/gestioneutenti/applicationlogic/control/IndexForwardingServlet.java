package weatherstyle.gestioneutenti.applicationlogic.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoHours;
import weatherstyle.gestionemeteo.applicationlogic.logic.service.MeteoLogicService;
import weatherstyle.gestionemeteo.storage.service.InfoMeteoDailyService;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.io.IOException;
import java.util.List;

/**
 * @author Francesco Giuseppe Zammarrelli
 * La classe Index forwarding servlet.
 */
@WebServlet(name = "IndexForwardingServlet", value = "/index.html")
public class IndexForwardingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = "/WEB-INF/home_public.jsp";

        HttpSession session = request.getSession();

        Utente u  = (Utente) session.getAttribute("utente");

        if(u != null){
            Citta citta = u.getCitta().isEmpty() ?
                    (Citta) getServletContext().getAttribute("citta_default"):u.getCitta().get(0);
            MeteoLogicService meteoLogicService =  new MeteoLogicService();

            List<MeteoDaily> meteoDaily =  meteoLogicService.getMeteoDaily(citta);
            List<MeteoHours> meteoHours =  meteoLogicService.getMeteoHours(citta);

            request.setAttribute("meteo-hours", meteoHours);
            request.setAttribute("meteo-daily", meteoDaily);
            request.setAttribute("citta", citta);
            address =  "/WEB-INF/gestioneUtente/utente/home_private.jsp";
        }else{
            Admin admin  = (Admin) session.getAttribute("admin");

            if(admin != null){
                address =  "/WEB-INF/gestioneUtente/admin/home_admin.jsp";
            }
        }


        RequestDispatcher dispatcher =  request.getRequestDispatcher(address);

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
}
