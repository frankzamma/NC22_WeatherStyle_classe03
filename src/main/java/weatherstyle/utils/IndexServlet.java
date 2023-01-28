package weatherstyle.utils;

import Model.GuardarobaLegacy;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "index",value = "/old_index.html")
public class IndexServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        // rimanda alla home
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
