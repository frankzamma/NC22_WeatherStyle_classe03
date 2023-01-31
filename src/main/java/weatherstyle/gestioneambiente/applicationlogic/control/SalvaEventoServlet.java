package weatherstyle.gestioneambiente.applicationlogic.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestioneambiente.applicationlogic.logic.beans.Evento;
import weatherstyle.gestioneambiente.applicationlogic.logic.beans.RichiestaPromozione;
import weatherstyle.gestioneambiente.applicationlogic.logic.service.EventoLogicImpl;
import weatherstyle.gestioneambiente.applicationlogic.logic.service.EventoLogicInterface;
import weatherstyle.gestioneambiente.applicationlogic.logic.service.RichiestaPromozioneLogicImpl;
import weatherstyle.gestioneambiente.applicationlogic.logic.service.RichiestaPromozioneLogicInterface;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

@WebServlet(name = "SalvaEventoServlet", value = "/SalvaEventoServlet")
public class SalvaEventoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utente utente = (Utente)  session.getAttribute("utente");
        if (utente == null || !utente.isEcologista()){
            response.sendRedirect("index.html");
        }
        else{
            String nomeEvento = request.getParameter("nomeEvento");
            String luogo = request.getParameter("luogo");
            String descrizione = request.getParameter("descrizione");
            String altreInformazioni = request.getParameter("altreInformazioni");
            Timestamp dataOraEvento;
            String[] data = request.getParameter("data").split("-");
            String[] orario = request.getParameter("orario").split(":");
            GregorianCalendar dataNascita = new GregorianCalendar(Integer.parseInt(data[0]), Integer.parseInt(data[1])-1, Integer.parseInt(data[2]), Integer.parseInt(orario[0]), Integer.parseInt(orario[1]));
            dataOraEvento = new Timestamp(dataNascita.getTimeInMillis());

            EventoLogicInterface eventoLogic = new EventoLogicImpl();
            RequestDispatcher dispatcher;
            Evento evento = new Evento();
            evento.setNome(nomeEvento);
            evento.setDataOraEvento(dataOraEvento);
            evento.setLuogo(luogo);
            evento.setDescrizione(descrizione);
            evento.setAltreInformazioni(altreInformazioni);
            evento.setUtente(utente);
            try {
                eventoLogic.salvaEvento(evento);
            }catch (IllegalArgumentException e) {
                request.setAttribute("Errore", e.getMessage());
                dispatcher = request.getRequestDispatcher("/WEB-INF/gestioneambiente/creaEvento.jsp");
                dispatcher.forward(request, response);
            }
            response.sendRedirect("VisualizzaEventiServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
