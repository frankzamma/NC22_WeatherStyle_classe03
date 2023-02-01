package weatherstyle.gestionemeteo.applicationlogic.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoHours;
import weatherstyle.gestionemeteo.applicationlogic.logic.service.MeteoLogicService;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.io.IOException;
import java.util.List;

/**
 * @author Francesco Giuseppe Zammarrelli
 * Servlet per richiedere informazioni meteo
 */
@WebServlet(name = "CercaMeteoServlet",value = "/cerca-meteo")
public class CercaMeteoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utente  u = (Utente) session.getAttribute("utente");

        if (u != null) {
            String nomeCitta =  request.getParameter("citta-nome");
            String lat =  request.getParameter("lat");
            String lon =  request.getParameter("lon");

            Citta citta = new Citta();

            citta.setNome(nomeCitta);
            citta.setLat(lat);
            citta.setLon(lon);
            try {
                MeteoLogicService meteoLogicService =  new MeteoLogicService();

                List<MeteoDaily> meteoDaily =  meteoLogicService.getMeteoDaily(citta);
                List<MeteoHours> meteoHours =  meteoLogicService.getMeteoHours(citta);

                request.setAttribute("meteo-hours",meteoHours);
                request.setAttribute("meteo-daily",meteoDaily);
                request.setAttribute("citta",citta);

                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/gestioneMeteo/meteo-page.jsp");
                dispatcher.forward(request,response);
            } catch (IllegalArgumentException e) {
                response.sendRedirect("Siamo spiacienti, si è verficato un errore");
            }
        } else {
            response.sendRedirect("login-utente");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
}
