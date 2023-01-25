package Logics.controller;

import Logics.machinelearning.BottomML;
import Logics.machinelearning.ShoesML;
import Logics.machinelearning.TopML;
import Model.Guardaroba;
import Model.RecoveryGuardaroba;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "StartupServlet", value = "/StartupServlet", loadOnStartup = 1)
public class StartupServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //Path dei dataset
        String shoesDataset = this.getServletContext().getRealPath("") + File.separator +
                "WEB-INF/resources/csv/shoes_meteo_dataset_labeled.csv";
        String bottomDataset = this.getServletContext().getRealPath("") + File.separator +
                "WEB-INF/resources/csv/bottom_meteo_dataset_labeled.csv";

        String topDataset = this.getServletContext().getRealPath("") + File.separator +
                "WEB-INF/resources/csv/top_meteo_dataset_labeled.csv";

        //Creazione dei ML (Durante la creazione si effettua anche l'addestramento)
        ShoesML shoesML =  new ShoesML(shoesDataset);
        BottomML bottomML = new BottomML(bottomDataset);
        TopML topML = new TopML(topDataset);

        // Caricamento del guardaroba d'esempio
        RecoveryGuardaroba recoveryGuardaroba =
                new RecoveryGuardaroba(this.getServletContext()
                        .getRealPath(""  + File.separator + "WEB-INF/resources/CapoAbbigliamentoList" ));
        Guardaroba guardaroba = recoveryGuardaroba.getGuardaroba();


        ServletContext context = this.getServletContext();
        context.setAttribute("shoesML", shoesML);
        context.setAttribute("bottomML", bottomML);
        context.setAttribute("topML", topML);
        context.setAttribute("guardaroba_context", guardaroba);



    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
}
