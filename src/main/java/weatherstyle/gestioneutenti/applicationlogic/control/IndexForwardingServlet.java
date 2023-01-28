package weatherstyle.gestioneutenti.applicationlogic.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.io.IOException;

@WebServlet(name = "IndexForwardingServlet", value = "/index.html")
public class IndexForwardingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = "/WEB-INF/home_public.jsp";

        HttpSession session = request.getSession();

        Utente u  = (Utente) session.getAttribute("utente");

        if(u != null){
            address =  "/WEB-INF/gestioneUtente/utente/home_admin.jsp";
        }else{
            Admin admin  = (Admin) session.getAttribute("admin");

            if(admin != null){
                address =  "/WEB-INF/gestioneUtente/admin/home_admin.jsp";
            }
        }


        RequestDispatcher dispatcher =  request.getRequestDispatcher(address);

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
}
