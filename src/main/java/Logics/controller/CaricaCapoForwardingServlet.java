package Logics.controller;

import Model.Guardaroba;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CaricaCapoForwardingServlet", value = "/carica-capo-form")
public class CaricaCapoForwardingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Guardaroba guardaroba = (Guardaroba) session.getAttribute("guardaroba");

        if (guardaroba == null){
            response.sendRedirect("./index.html");
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/loadCapoAbbigliamento.jsp");
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
