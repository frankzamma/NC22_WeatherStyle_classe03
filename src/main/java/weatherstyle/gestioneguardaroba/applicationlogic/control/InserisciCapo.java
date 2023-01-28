package weatherstyle.gestioneguardaroba.applicationlogic.control;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.service.CapoAbbigliamentoService;
import weatherstyle.utils.ErrorParameterException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "InserisciCapo", value = "/inserisci-capo")
public class InserisciCapo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address;
        List<String> errorService = new ArrayList<>();
        CapoAbbigliamentoService service = new CapoAbbigliamentoService();

        String tipoCapo = request.getParameter("tipologia");
        if ((tipoCapo==null) || (tipoCapo.equals(""))){
            request.setAttribute("errore tipo", "erroreTipo");
            response.sendRedirect("loadCapoAbbigliamento.jsp");
        }


        String nomeCapo = request.getParameter("nomeCapo");
        String directoryCapo = request.getParameter("directoryCapo");
        String colore = request.getParameter("colore");
        String stagione = request.getParameter("stagione");


        if ("maglia".equals(tipoCapo)) {
            String materiale = request.getParameter("materiale");
            String manica = request.getParameter("manica");

            Maglia m = new Maglia(nomeCapo, directoryCapo, stagione,colore,manica, materiale);
            try {
                service.salvaMaglia(m);
            } catch (ErrorParameterException e) {
                errorService = e.getErrorParameter();
            }
        }

        if ("pantaloni".equals(tipoCapo)) {
            String materiale = request.getParameter("materiale");
            String lunghezza = request.getParameter("lungPantalone");

            Pantaloni p = new Pantaloni(nomeCapo, directoryCapo, stagione, colore, lunghezza, materiale);
            try {
                service.salvaPantaloni(p);
            } catch (ErrorParameterException e) {
                errorService = e.getErrorParameter();
            }
        }

        if ("scarpe".equals(tipoCapo)) {
            String tipo = request.getParameter("tipoScarpa");
            String scivoloso = request.getParameter("scivoloso");
            boolean scivol;
            if ("scivsi".equals(scivoloso)) {
                scivol = true;
            } else {
                scivol = false;
            }
            String impermeabile = request.getParameter("impermeabile");
            boolean imper;
            if ("impsi".equals(impermeabile)) {
                imper = true;
            } else {
                imper = false;
            }
            Scarpe s = new Scarpe(nomeCapo, directoryCapo, stagione, colore, tipo, scivol, imper);
            try {
                service.salvaScarpe(s);
            } catch (ErrorParameterException e) {
                errorService = e.getErrorParameter();
            }
        }

        if (errorService.isEmpty())
            address = "visualizzaGuardaroba.jsp";

        else{
            request.setAttribute("errorListService", errorService);
            address = "loadCapoAbbigliamento.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request,response);
    }
}
