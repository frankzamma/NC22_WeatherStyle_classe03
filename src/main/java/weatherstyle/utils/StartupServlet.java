package weatherstyle.utils;

import Model.RecoveryGuardaroba;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Guardaroba;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.algorithms.AbstractAlgorithm;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.algorithms.ImplementorAlgorithm;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "StartupServlet", value = "/StartupServlet", loadOnStartup = 1)
public class StartupServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        AbstractAlgorithm<Maglia> magliaAbstractAlgorithmGA = new AbstractAlgorithm<>();
        AbstractAlgorithm<Pantaloni> pantaloniAbstractAlgorithmGA = new AbstractAlgorithm<>();
        AbstractAlgorithm<Scarpe> scarpeAbstractAlgorithmGA = new AbstractAlgorithm<>();

        AbstractAlgorithm<Maglia> magliaAbstractAlgorithmML = new AbstractAlgorithm<>(AbstractAlgorithm.MAGLIA,
                this.getServletContext().getRealPath(""));
        AbstractAlgorithm<Pantaloni> pantaloniAbstractAlgorithmML = new AbstractAlgorithm<>(AbstractAlgorithm.PANTALONI,
                this.getServletContext().getRealPath(""));
        AbstractAlgorithm<Scarpe> scarpeAbstractAlgorithmML = new AbstractAlgorithm<>(AbstractAlgorithm.SCARPE,
                this.getServletContext().getRealPath(""));

        ImplementorAlgorithm<Maglia> magliaImplementorAlgorithmGA = magliaAbstractAlgorithmGA.getImplementorGA();
        ImplementorAlgorithm<Pantaloni> pantaloniImplementorAlgorithmGA = pantaloniAbstractAlgorithmGA.getImplementorGA();
        ImplementorAlgorithm<Scarpe> scarpeImplementorAlgorithmGA = scarpeAbstractAlgorithmGA.getImplementorGA();

        ImplementorAlgorithm<Maglia> magliaImplementorAlgorithmML = magliaAbstractAlgorithmML.getImplementorML();
        ImplementorAlgorithm<Pantaloni> pantaloniImplementorAlgorithmML = pantaloniAbstractAlgorithmML.getImplementorML();
        ImplementorAlgorithm<Scarpe> scarpeImplementorAlgorithmML = scarpeAbstractAlgorithmML.getImplementorML();

        // Caricamento del guardaroba d'esempio
        RecoveryGuardaroba recoveryGuardaroba =
                new RecoveryGuardaroba(this.getServletContext()
                        .getRealPath(""  + File.separator + "WEB-INF/resources/CapoAbbigliamentoList"));
        Guardaroba guardaroba = recoveryGuardaroba.getGuardaroba();

        ServletContext context = this.getServletContext();

        context.setAttribute("scarpeGA", scarpeImplementorAlgorithmGA);
        context.setAttribute("pantaloniGA",pantaloniImplementorAlgorithmGA);
        context.setAttribute("magliaGA",magliaImplementorAlgorithmGA);

        context.setAttribute("scarpeML", scarpeImplementorAlgorithmML);
        context.setAttribute("pantaloniML",pantaloniImplementorAlgorithmML);
        context.setAttribute("magliaML",magliaImplementorAlgorithmML);

        context.setAttribute("guardaroba",guardaroba);
    }

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws  IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws  IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
}
