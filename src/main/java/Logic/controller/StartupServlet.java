package Logic.controller;

import Logic.machinelearning.ShoesML;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "StartupServlet", value = "/StartupServlet", loadOnStartup = 1)
public class StartupServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //Il costruttore crea e allena il ML
        ShoesML shoesML =  new ShoesML();
        //TODO Aggiungere gli altri ML

        ServletContext context = this.getServletContext();
        context.setAttribute("shoesML", shoesML);


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
