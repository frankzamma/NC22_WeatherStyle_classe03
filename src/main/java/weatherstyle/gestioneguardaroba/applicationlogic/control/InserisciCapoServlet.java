package weatherstyle.gestioneguardaroba.applicationlogic.control;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Guardaroba;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.service.GuardarobaLogicImpl;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.service.GuardarobaLogicInterface;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;
import weatherstyle.utils.ErrorParameterException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(name = "InserisciCapo", value = "/inserisci-capo")
public class InserisciCapoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = null;
        List<String> errorService = new ArrayList<>();
        GuardarobaLogicImpl service = new GuardarobaLogicImpl();

        HttpSession session = request.getSession();
        Utente u = (Utente) session.getAttribute("utente");

        if (u != null) {

            String tipoCapo = request.getParameter("tipologia");
            if ((tipoCapo==null) || (tipoCapo.equals(""))){
                request.setAttribute("message", "Selezionare un tipo di capo d'abbigliamento");
                RequestDispatcher dispatcher = request.getRequestDispatcher("loadCapoAbbigliamento.jsp");
                dispatcher.forward(request,response);
            }

            String nomeCapo = request.getParameter("nomeCapo");

            String colore = request.getParameter("colore");
            String stagione = request.getParameter("stagione");

            String manica = null;
            String materialeM = null;
            if ("maglia".equals(tipoCapo)) {
                materialeM = request.getParameter("materiale");
                manica = request.getParameter("manica");
            }

            String materialeP = null;
            String lunghezza = null;
            if ("pantaloni".equals(tipoCapo)) {
                materialeP= request.getParameter("materiale");
                lunghezza = request.getParameter("lungPantalone");
            }

            String tipo = null;
            boolean scivol = false;
            boolean imper = false;
            if ("scarpe".equals(tipoCapo)) {
                tipo = request.getParameter("tipoScarpa");
                String scivoloso = request.getParameter("scivoloso");
                if ("scivsi".equals(scivoloso))
                    scivol = true;

                String impermeabile = request.getParameter("impermeabile");
                if ("impsi".equals(impermeabile))
                    imper = true;

            }

            String[] tmp = {"jpg", "png"};
            List<String> extensions = Arrays.asList(tmp);
            Part foto = request.getPart("foto");
            String fileName = foto.getSubmittedFileName();
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);

            if (!extensions.contains(extension)){
                request.setAttribute("message", "Errore formato immagine");
                RequestDispatcher dispatcher = request.getRequestDispatcher("loadCapoAbbigliamento.jsp");
                dispatcher.forward(request,response);

            }else{
                String path = request.getServletContext().getRealPath("") + "images";

                File pathNew = new File(path);

                //creo la cartella
                if (!pathNew.exists()) {
                    pathNew.mkdir();
                }

                String extendendPath =  path + File.separator + nomeCapo + tipoCapo;
                File fileExtendendPath =  new File(extendendPath);

                if(!fileExtendendPath.exists())
                    fileExtendendPath.mkdir();

                String fullPath = extendendPath+File.separator+fileName;

                foto.write(fullPath);

                if ("maglia".equals(tipoCapo)){
                    Maglia m = new Maglia(nomeCapo, fullPath, stagione,colore, manica, materialeM);
                    try {
                        service.salvaMaglia(m, u.getId());
                    } catch (ErrorParameterException e) {
                        errorService = e.getErrorParameter();
                    }
                }
                if ("pantaloni".equals(tipoCapo)){
                    Pantaloni p = new Pantaloni(nomeCapo, fullPath, stagione, colore, lunghezza, materialeP);
                    try {
                        service.salvaPantaloni(p, u.getId());
                    } catch (ErrorParameterException e) {
                        errorService = e.getErrorParameter();
                    }
                }
                if ("scarpe".equals(tipoCapo)){
                    Scarpe s = new Scarpe(nomeCapo, fullPath, stagione, colore, tipo, scivol, imper);
                    try {
                        service.salvaScarpe(s, u.getId());
                    } catch (ErrorParameterException e) {
                        errorService = e.getErrorParameter();
                    }
                }

                if (errorService.isEmpty()) {
                    service.aggiornaNumeroCapi(u.getId());
                    address = "inserimentoResult.jsp";
                    request.setAttribute("message", "L'inserimento è andato a buon fine");
                }else{
                    request.setAttribute("errorListService", errorService);
                    address = "loadCapoAbbigliamento.jsp";
                }
            }
        }else{
            address = "/WEB-INF/gestioneUtente/utente/login_utente.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request,response);
    }
}
