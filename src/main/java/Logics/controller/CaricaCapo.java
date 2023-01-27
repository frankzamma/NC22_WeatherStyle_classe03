package Logics.controller;

import Model.Guardaroba;
import Model.Maglia;
import Model.Pantaloni;
import Model.Scarpa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "caricaCapoServlet",value = "/carica-capo")
public class CaricaCapo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String address;
        HttpSession httpSession = request.getSession(false);

        if (httpSession != null) {
            Guardaroba guardaroba = (Guardaroba) httpSession.getAttribute("guardaroba");
            String tipoCapo = request.getParameter("tipologia");

            if ("maglia".equals(tipoCapo)) {
                String materiale = request.getParameter("materiale");
                String colore = request.getParameter("colore");
                String manica = request.getParameter("manica");
                String stagione = request.getParameter("stagione");

                Maglia m = new Maglia(materiale,stagione,colore,manica);
                guardaroba.addCapoAbbigliamento(m);
            }
            if ("pantalone".equals(tipoCapo)) {
                String materiale = request.getParameter("materiale");
                String colore = request.getParameter("colore");
                String stagione = request.getParameter("stagione");
                String lunghezza = request.getParameter("lungPantalone");

                Pantaloni p = new Pantaloni(materiale,stagione,colore,lunghezza);
                guardaroba.addCapoAbbigliamento(p);
            }
            if ("scarpe".equals(tipoCapo)) {
                String colore = request.getParameter("colore");
                String stagione = request.getParameter("stagione");
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

                Scarpa s = new Scarpa(stagione,colore,tipo,scivol,imper);
                guardaroba.addCapoAbbigliamento(s);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/visualizzaGuardaroba.jsp");
            dispatcher.forward(request,response);
        } else {
            response.sendRedirect("/index.html");
        }




    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        doGet(request,response);
    }
}
