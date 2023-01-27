package Logics.controller;

import Model.Guardaroba;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "index",value = "/index.html")
public class IndexServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        // creo la sessione utente
        HttpSession httpSession = request.getSession();

        Guardaroba guardaroba = (Guardaroba) httpSession.getAttribute("guardaroba");

       if (guardaroba == null) {
           guardaroba = (Guardaroba) this.getServletContext().getAttribute("guardaroba_context");
           // copio nella sessione utente il guardaroba
           httpSession.setAttribute("guardaroba",guardaroba);
       }


        // rimanda alla home
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
