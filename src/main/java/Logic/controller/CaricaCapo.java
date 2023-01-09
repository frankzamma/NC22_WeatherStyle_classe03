package Logic.controller;

import Model.Guardaroba;
import Model.Maglia;
import Model.Pantalone;
import Model.Scarpa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "caricaCapoServlet", value = "/carica-capo")
public class CaricaCapo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String address;
        HttpSession httpSession = request.getSession(false);

        if (httpSession!=null) {
            Guardaroba guardaroba = (Guardaroba) httpSession.getAttribute("guardaroba");
            String tipoCapo = (String) request.getAttribute("tipologia");

            if (tipoCapo.equals("maglia")) {
                String materiale = (String) request.getAttribute("materiale");
                String colore = (String) request.getAttribute("colore");
                String manica = (String) request.getAttribute("manica");
                String stagione = (String) request.getAttribute("stagione");

                Maglia m = new Maglia(materiale, stagione, colore, manica);
                guardaroba.addCapoAbbigliamento(m);
            }
            if (tipoCapo.equals("pantalone")) {
                String materiale = (String) request.getAttribute("materiale");
                String colore = (String) request.getAttribute("colore");
                String stagione = (String) request.getAttribute("stagione");
                String lunghezza = (String) request.getAttribute("lungPantalone");

                Pantalone p = new Pantalone(materiale, stagione, colore, lunghezza);
                guardaroba.addCapoAbbigliamento(p);
            }
            if (tipoCapo.equals("scarpe")) {
                String colore = (String) request.getAttribute("colore");
                String stagione = (String) request.getAttribute("stagione");
                String tipo = (String) request.getAttribute("tipoScarpa");
                String scivoloso = (String) request.getAttribute("scivoloso");
                boolean scivol;
                if (scivoloso.equals("scivsi"))
                    scivol = true;
                else
                    scivol = false;
                String impermeabile = (String) request.getAttribute("impermeabile");
                boolean imper;
                if (impermeabile.equals("impsi"))
                    imper = true;
                else
                    imper = false;

                Scarpa s = new Scarpa(stagione, colore, tipo, scivol, imper);
                guardaroba.addCapoAbbigliamento(s);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/visualizzaGuardaroba.jsp");
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect("/index.html");
        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
