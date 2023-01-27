package weatherstyle.gestionesuggerimentiia.applicationlogic.control;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Guardaroba;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDailyMin;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.algorithms.ImplementorAlgorithm;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.service.SuggerimentoLogicImpl;
import weatherstyle.gestionesuggerimentiia.storage.dao.OutfitDAOImpl;
import weatherstyle.gestionesuggerimentiia.storage.dao.SuggerimentoDAOImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * classe che raccoglie tutte le informazioni necessarie per fornire suggerimenti all'utente
 */
@WebServlet(name = "RichiestaSuggerimentoServlet",value = "/RichiestaSuggerimentoServlet")
public class RichiestaSuggerimentoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        //Si ricevono i vari parametri tramite request
        String meteo = request.getParameter("meteo");

        String temperaturaPer = request.getParameter("temperatura-percepita");

        //Si verifica che sia stata selezionata la temperatura percepita
        if ("temperaturaPercepita".equals(temperaturaPer)) {
            //Nel caso in cui non è stata selezionata la temperatura percepita si rimanda alla pagina home
            response.sendRedirect("index.html");
        }
        else {
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
            String stagionePrevisione = stagioneMesi[Integer.parseInt(data[1]) - 1];

            String algoritmoIA = request.getParameter("algo");

                /*  Si costruisce l'oggetto meteoInformation contenente gli attributi:
                    temperaturaPercepita, meteo e stagionePrevisione
                 */
            MeteoDailyMin meteoDailyMin = new MeteoDailyMin();
            meteoDailyMin.setMeteo(meteo);
            meteoDailyMin.setStagionePrevisione(stagionePrevisione);
            meteoDailyMin.setTemperaturaPercepitaMedia(temperaturaPercepita);

            //Restiutisce la sessione, se non c'è allora non la crea
            HttpSession session = request.getSession(false);
            if (session == null) {
                response.sendRedirect("index.html");
            } else {
                //  Si prende il guardaroba dal context
                Guardaroba guardaroba = (Guardaroba) getServletContext().getAttribute("guardaroba");
                //  Si prendono le varie liste di capi d'abbigliamento presenti nel guardaroba
                List<Maglia> listaMaglie = guardaroba.getMaglie();
                List<Pantaloni> listaPantaloni = guardaroba.getPantaloni();
                List<Scarpe> listaScarpe = guardaroba.getScarpe();

                //  Si istanziano le liste che conterranno i capi suggeriti
                List<Maglia> maglieSuggerite = new ArrayList<>();
                List<Pantaloni> pantaloniSuggeriti = new ArrayList<>();
                List<Scarpe> scarpeSuggerite = new ArrayList<>();

                //  Si controlla se l'algoritmo che l'utente ha richiesto è il Machine Learning
                if ("ml".equals(algoritmoIA)) {
                    /*  Si prendono i regressori presenti nel context che sono già stati addestrati
                        sui rispettivi dataset nella servlet StartupServlet
                     */
                    @SuppressWarnings("unchecked")
                    ImplementorAlgorithm<Maglia> magliaImplementorAlgorithmML = (ImplementorAlgorithm<Maglia>)
                            getServletContext().getAttribute("magliaML");

                    @SuppressWarnings("unchecked")
                    ImplementorAlgorithm<Pantaloni> pantaloniImplementorAlgorithmML = (ImplementorAlgorithm<Pantaloni>)
                            getServletContext().getAttribute("pantaloniML");

                    @SuppressWarnings("unchecked")
                    ImplementorAlgorithm<Scarpe> scarpeImplementorAlgorithmML = (ImplementorAlgorithm<Scarpe>)
                            getServletContext().getAttribute("scarpeML");

                    //  Si ottengono le migliori maglie, pantaloni e scarpe con i rispettivi punteggi
                    SuggerimentoLogicImpl suggerimentoLogicImpl = new SuggerimentoLogicImpl(
                            new SuggerimentoDAOImpl(), new OutfitDAOImpl());

                    maglieSuggerite = suggerimentoLogicImpl.ottieniSuggerimentiCapi(magliaImplementorAlgorithmML,
                            listaMaglie, meteoDailyMin);
                    System.out.println(maglieSuggerite);

                    pantaloniSuggeriti = suggerimentoLogicImpl.ottieniSuggerimentiCapi(pantaloniImplementorAlgorithmML,
                            listaPantaloni, meteoDailyMin);
                    System.out.println(pantaloniSuggeriti);

                    scarpeSuggerite = suggerimentoLogicImpl.ottieniSuggerimentiCapi(scarpeImplementorAlgorithmML,
                            listaScarpe, meteoDailyMin);
                    System.out.println(scarpeSuggerite);
                }
                else if ("ga".equalsIgnoreCase(algoritmoIA)) {

                    @SuppressWarnings("unchecked")
                    ImplementorAlgorithm<Maglia> magliaImplementorAlgorithmGA = (ImplementorAlgorithm<Maglia>)
                            getServletContext().getAttribute("magliaGA");

                    @SuppressWarnings("unchecked")
                    ImplementorAlgorithm<Pantaloni> pantaloniImplementorAlgorithmGA = (ImplementorAlgorithm<Pantaloni>)
                            getServletContext().getAttribute("pantaloniGA");

                    @SuppressWarnings("unchecked")
                    ImplementorAlgorithm<Scarpe> scarpeImplementorAlgorithmGA = (ImplementorAlgorithm<Scarpe>)
                            getServletContext().getAttribute("scarpeGA");

                    //  Si ottengono le migliori maglie, pantaloni e scarpe con i rispettivi punteggi
                    SuggerimentoLogicImpl suggerimentoLogicImpl = new SuggerimentoLogicImpl(
                            new SuggerimentoDAOImpl(), new OutfitDAOImpl());

                    maglieSuggerite = suggerimentoLogicImpl.ottieniSuggerimentiCapi(magliaImplementorAlgorithmGA,
                            listaMaglie, meteoDailyMin);
                    System.out.println(maglieSuggerite);

                    pantaloniSuggeriti = suggerimentoLogicImpl.ottieniSuggerimentiCapi(pantaloniImplementorAlgorithmGA,
                            listaPantaloni, meteoDailyMin);
                    System.out.println(pantaloniSuggeriti);

                    scarpeSuggerite = suggerimentoLogicImpl.ottieniSuggerimentiCapi(scarpeImplementorAlgorithmGA,
                            listaScarpe, meteoDailyMin);
                    System.out.println(scarpeSuggerite);

                }

                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
                dispatcher.forward(request, response);

            }
        }

    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        doGet(request,response);
    }

}
