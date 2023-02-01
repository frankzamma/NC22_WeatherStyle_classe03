package Logics.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet(name = "GuardarobaServlet",value = "/GuardarobaServlet")
public class GuardarobaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/visualizzaGuardaroba.jsp");
            dispatcher.forward(request,response);
        } else {
            response.sendRedirect("index.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        doGet(request,response);
    }
}
