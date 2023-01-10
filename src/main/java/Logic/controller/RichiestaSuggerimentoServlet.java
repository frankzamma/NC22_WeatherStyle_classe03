package Logic.controller;

import Logic.ga.BottomClothesGA;
import Logic.ga.ShoesClothesGA;
import Logic.ga.TopClothesGA;
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
import java.util.*;

@WebServlet(name = "RichiestaSuggerimentoServlet", value = "/RichiestaSuggerimentoServlet")
public class RichiestaSuggerimentoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //Si ricevono i vari parametri tramite request
        String meteo = request.getParameter("meteo");

        String temperaturaPer = request.getParameter("temperatura-percepita");

        //Si verifica che sia stata selezionata la temperatura percepita
        if(temperaturaPer.equals("temperaturaPercepita")){
            //Nel caso in cui non è stata selezionata la temperatura percepita si rimanda alla pagina home
            response.sendRedirect("index.html");
        }
        else{
                //Si converte la temperatura percepita nel tipo double
                double temperaturaPercepita = Double.valueOf(temperaturaPer);

                /*  Si recupera la data dalla request e si divide tramite la funzione split
                    in modo tale da evere un array di stringhe che avrà come elemento in posizione 0
                    l'anno, come elemento in posizione 1 il mese e come elemento in posizione 2 il giorno
                 */
                String[] data = request.getParameter("data").split("-");

                /*  Vettore di stringhe dove l'indice corrisponde al mese (da 0 = Gennaio a 11 = Dicembre
                    e le stringhe alla stagione
                 */
                String[] stagioneMesi = {"inverno", "inverno", "primavera", "primavera", "primavera", "estate", "estate", "estate", "autunno", "autunno", "autunno", "inverno"};
                //Si ottiene la stagione della previsione
                String stagionePrevisione = stagioneMesi[Integer.parseInt(data[1])-1];

                String algoritmoIA = request.getParameter("algo");

                /*  Si costruisce l'oggetto meteoInformation contenente gli attributi:
                    temperaturaPercepita, meteo e stagionePrevisione
                 */
                MeteoInformation meteoInformation = new MeteoInformation(temperaturaPercepita, meteo, stagionePrevisione);

                //Restiutisce la sessione, se non c'è allora non la crea
                HttpSession session = request.getSession(false);
                if(session == null)
                    response.sendRedirect("index.html");
                else{
                        //  Si prende il guardaroba dal context
                        Guardaroba guardaroba = (Guardaroba) session.getAttribute("guardaroba");
                        //  Si prendono le varie liste di capi d'abbigliamento presenti nel guardaroba
                        List<Maglia> listaMaglie = guardaroba.getMagliaList();
                        List<Pantalone> listaPantaloni = guardaroba.getPantaloneList();
                        List<Scarpa> listaScarpe = guardaroba.getScarpaList();

                        //  Si istanziano le liste che conterranno i capi suggeriti
                        List<CapoAbbigliamento> maglieSuggerite = new ArrayList<>();
                        List<CapoAbbigliamento> pantaloniSuggeriti = new ArrayList<>();
                        List<CapoAbbigliamento> scarpeSuggerite = new ArrayList<>();

                        //  Si controlla se l'algoritmo che l'utente ha richiesto è il Machine Learning
                        if(algoritmoIA.equals("ml")){
                            /*  Si prendono i regressori presenti nel context che sono già stati addestrati
                                sui rispettivi dataset nella servlet StartupServlet
                             */
                            TopML topML = (TopML) getServletContext().getAttribute("topML");
                            BottomML bottomML = (BottomML) getServletContext().getAttribute("bottomML");
                            ShoesML shoesML = (ShoesML) getServletContext().getAttribute("shoesML");

                            //  Si ottengono le migliori maglie, pantaloni e scarpe con i rispettivi punteggi
                            List<ScoreCapoAbbigliamento> scoreBestTop = topML.classifyInstances(listaMaglie, meteoInformation, true);
                            List<ScoreCapoAbbigliamento> scoreBestBottom = bottomML.classifyInstances(listaPantaloni, meteoInformation, true);
                            List<ScoreCapoAbbigliamento> scoreBestShoes = shoesML.classifyIstances(listaScarpe, meteoInformation, true);

                            //  Lista che conterrà i punteggi relativi alle migliori 3 maglie
                            List<Double> punteggiMaglie = new ArrayList<>();
                            for(ScoreCapoAbbigliamento scoreCapoAbbigliamento: scoreBestTop){
                                maglieSuggerite.add(scoreCapoAbbigliamento.getCapoAbbigliamento());
                                punteggiMaglie.add(scoreCapoAbbigliamento.getPunteggio());
                            }

                            //  Lista che conterrà i punteggi relativi ai migliori 3 pantaloni
                            List<Double> punteggiPantaloni = new ArrayList<>();
                            for(ScoreCapoAbbigliamento scoreCapoAbbigliamento: scoreBestBottom){
                                pantaloniSuggeriti.add(scoreCapoAbbigliamento.getCapoAbbigliamento());
                                punteggiPantaloni.add(scoreCapoAbbigliamento.getPunteggio());
                            }

                            //  Lista che conterrà i punteggi relativi alle migliori 3 scarpe
                            List<Double> punteggiScarpe = new ArrayList<>();
                            for(ScoreCapoAbbigliamento scoreCapoAbbigliamento: scoreBestShoes){
                                scarpeSuggerite.add(scoreCapoAbbigliamento.getCapoAbbigliamento());
                                punteggiScarpe.add(scoreCapoAbbigliamento.getPunteggio());
                            }

                            request.setAttribute("punteggiMaglie", punteggiMaglie);
                            request.setAttribute("punteggiPantaloni", punteggiPantaloni);
                            request.setAttribute("punteggiScarpe", punteggiScarpe);
                        }
                        else
                            //  Si controlla se l'algoritmo che l'utente ha richiesto è l'algoritmo genetico
                            if(algoritmoIA.equals("ga")){
                                //  Si avviano i vari algoritmi genetici
                                TopClothesGA topClothesGA = new TopClothesGA(listaMaglie, meteoInformation);
                                BottomClothesGA bottomClothesGA = new BottomClothesGA(listaPantaloni, meteoInformation);
                                //ShoesClothesGA shoesClothesGA = new ShoesClothesGA(listaScarpe, meteoInformation);

                                // Si ottengono i migliori capi per ognuno degli algoritmi genetici avviati prima
                                maglieSuggerite = topClothesGA.getBestMaglie();
                                pantaloniSuggeriti = bottomClothesGA.getBestPantaloni();
                                //scarpeSuggerite = shoesClothesGA.getBestScarpe();
                            }

                        request.setAttribute("maglieSuggerite", maglieSuggerite);
                        request.setAttribute("pantaloniSuggeriti", pantaloniSuggeriti);
                        request.setAttribute("scarpeSuggerite", scarpeSuggerite);
                        request.setAttribute("meteoInformation", meteoInformation);
                        request.setAttribute("algoritmoIA", algoritmoIA);

                        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/visualizzaSuggerimenti.jsp");
                        dispatcher.forward(request, response);
                }

        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

}
