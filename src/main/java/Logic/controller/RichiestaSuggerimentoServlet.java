package Logic.controller;

import Logic.machinelearning.BottomML;
import Logic.machinelearning.ShoesML;
import Logic.machinelearning.TopML;
import Model.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

@WebServlet(name = "RichiestaSuggerimentoServlet", value = "/RichiestaSuggerimentoServlet")
public class RichiestaSuggerimentoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String meteo = request.getParameter("meteo");

        String temperaturaPer = request.getParameter("temperatura-percepita");
        if(temperaturaPer.equals("temperaturaPercepita")){
            response.sendRedirect("index.html");
        }
        else{
                double temperaturaPercepita = Double.valueOf(temperaturaPer);

                GregorianCalendar dataPrevisione;
                String[] data = request.getParameter("data").split("-");
                dataPrevisione = new GregorianCalendar(Integer.parseInt(data[0]), Integer.parseInt(data[1])-1, Integer.parseInt(data[2]));
                String[] stagioneMesi = {"inverno", "inverno", "primavera", "primavera", "primavera", "estate", "estate", "estate", "autunno", "autunno", "autunno", "inverno"};
                String stagionePrevisione = stagioneMesi[dataPrevisione.get(Calendar.MONTH)];

                String algoritmoIA = request.getParameter("algo");

                MeteoInformation meteoInformation = new MeteoInformation(temperaturaPercepita, meteo, stagionePrevisione);

                HttpSession session = request.getSession(false);
                if(session == null)
                    response.sendRedirect("index.html");
                else{
                        if(algoritmoIA.equals("ml")){
                            TopML topML = (TopML) getServletContext().getAttribute("topML");
                            BottomML bottomML = (BottomML) getServletContext().getAttribute("bottomML");
                            ShoesML shoesML = (ShoesML) getServletContext().getAttribute("shoesML");

                            Guardaroba guardaroba = (Guardaroba) session.getAttribute("guardaroba");
                            List<Maglia> listaMaglie = guardaroba.getMagliaList();
                            List<Pantalone> listaPantaloni = guardaroba.getPantaloneList();
                            List<Scarpa> listaScarpe = guardaroba.getScarpaList();

                            List<ScoreCapoAbbigliamento> scoreBestTop = topML.classifyInstances(listaMaglie, meteoInformation, true);
                            List<ScoreCapoAbbigliamento> scoreBestBottom = bottomML.classifyInstances(listaPantaloni, meteoInformation, true);
                            List<ScoreCapoAbbigliamento> scoreBestShoes = shoesML.classifyIstances(listaScarpe, meteoInformation, true);

                            request.setAttribute("scoreBestTop", scoreBestTop);
                            request.setAttribute("scoreBestBottom", scoreBestBottom);
                            request.setAttribute("scoreBestShoes", scoreBestShoes);
                            request.setAttribute("meteoInformation", meteoInformation);

                            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/visualizzaSuggerimenti.jsp");
                            dispatcher.forward(request, response);
                        }
                        else
                            if(algoritmoIA.equals("ga")){

                            }
                }

        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

}
