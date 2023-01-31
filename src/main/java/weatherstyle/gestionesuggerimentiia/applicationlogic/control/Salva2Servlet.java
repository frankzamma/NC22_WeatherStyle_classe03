package weatherstyle.gestionesuggerimentiia.applicationlogic.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDailyMin;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Outfit;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Suggerimento;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.service.SuggerimentoLogicImpl;
import weatherstyle.gestionesuggerimentiia.storage.dao.OutfitDAOImpl;
import weatherstyle.gestionesuggerimentiia.storage.dao.SuggerimentoDAOImpl;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

@WebServlet(name = "Salva2Servlet", value = "/Salva2Servlet")
public class Salva2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // parametri relativi ai capi d'abbigliamento scelti dall'utente
        String scarpeID = request.getParameter("scarpeID");
        String magliaID = request.getParameter("magliaID");
        String pantaloniID = request.getParameter("pantaloniID");

        HttpSession session = request.getSession(false);
        if (session == null)
            response.sendRedirect("index.html");
        else {
            Utente utente = (Utente) session.getAttribute("utente");
            Citta citta = (Citta) session.getAttribute("citta");
            MeteoDailyMin meteoDailyMin = (MeteoDailyMin) session.getAttribute("meteoDailyMin");

            Suggerimento suggerimento = new Suggerimento();
            suggerimento.setUtente(utente);
            suggerimento.setCitta(citta);
            suggerimento.setDate(new Date(new GregorianCalendar().getTimeInMillis()));
            suggerimento.setMeteoDailyMin(meteoDailyMin);

            // parametro nome outfit preso dalla request
            String nomeOutfit = request.getParameter("nomeOutfit");

            Outfit outfit = new Outfit();
            outfit.setNome(nomeOutfit);

            // si istanziano oggetti maglia, pantaloni e scarpe assegnando loro id presi dalla request
            if (scarpeID != null) {
                Scarpe scarpe = new Scarpe();
                scarpe.setId(Integer.parseInt(scarpeID));
                outfit.setScarpe(scarpe);
            }

            if (magliaID != null){
                Maglia maglia = new Maglia();
                maglia.setId(Integer.parseInt(magliaID));
                outfit.setMaglia(maglia);
            }

            if (pantaloniID != null){
                Pantaloni pantaloni = new Pantaloni();
                pantaloni.setId(Integer.parseInt(pantaloniID));
                outfit.setPantaloni(pantaloni);
            }

            suggerimento.setOutfit(outfit);

            // si salva l'outfit e si cattura l'eventuale eccezione
            try {
                SuggerimentoLogicImpl suggerimentoLogic = new SuggerimentoLogicImpl(new SuggerimentoDAOImpl(),
                        new OutfitDAOImpl());
                suggerimentoLogic.salvaSuggerimento(suggerimento);
            } catch (IllegalArgumentException e){
                request.setAttribute("errorSalvaSuggerimento", e.getMessage());
                request.getRequestDispatcher("WEB-INF/gestionesuggerimentiia/errorSalvaSuggerimento2.jsp").forward(request, response);
            }

            session.removeAttribute("citta");
            session.removeAttribute("meteoDailyMin");
            session.removeAttribute("maglieSuggerite");
            session.removeAttribute("pantaloniSuggeriti");
            session.removeAttribute("scarpeSuggerite");

            response.sendRedirect("index.html");
        }
    }

}
