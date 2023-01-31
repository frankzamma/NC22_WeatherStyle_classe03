package weatherstyle.gestioneutenti.applicationlogic.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;
import weatherstyle.gestioneutenti.applicationlogic.logic.service.UtenteLogicImpl;
import weatherstyle.utils.ErrorParameterException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Francesco Giuseppe Zammarrelli
 * La classe Registrazione utente servlet.
 */
@WebServlet(name = "RegistrazioneUtenteServlet", value = "/registra-utente")
public class RegistrazioneUtenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utente u =  (Utente) session.getAttribute("utente");

        if(u == null){
            String nome = request.getParameter("nome");
            String cognome = request.getParameter("cognome");
            String dataNascita = request.getParameter("data-nascita");
            String email =  request.getParameter("email");
            String password =  request.getParameter("password");
            String cittaName =  request.getParameter("citta");
            String lat =  request.getParameter("lat");
            String lon = request.getParameter("lon");

            UtenteLogicImpl service =  new UtenteLogicImpl();
            if(!service.existsUtente(email)){
                try{
                    LocalDate date = LocalDate.parse(dataNascita);

                    Citta citta = null;
                    if(cittaName != null && lat != null && lon != null ){
                        citta =  new Citta();
                        citta.setLat(lat);
                        citta.setLon(lon);
                        citta.setNome(cittaName);
                    }

                    service.registraUtente(nome, cognome, date, email, password, citta);


                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/gestioneUtente/utente/registrazione_result.jsp");

                    dispatcher.forward(request, response);

                } catch (ErrorParameterException e) {
                    List<String> errorPar =  e.getErrorParameter();

                    request.setAttribute("errorPar", errorPar);

                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/gestioneUtente/utente/registrazione.jsp");

                    dispatcher.forward(request, response);
                }
            }else{

                request.setAttribute("message", "Sembra esista già un utente registrato con la mail " + email);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/gestioneUtente/utente/registrazione.jsp");
                dispatcher.forward(request, response);
            }
        }else{
            response.sendRedirect("index.html");
        }
    }
}
