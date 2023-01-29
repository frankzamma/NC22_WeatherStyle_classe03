package weatherstyle.gestionecitta.applicationlogic.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionecitta.applicationlogic.logic.service.CittaLogicImpl;
import weatherstyle.gestionecitta.applicationlogic.logic.service.CittaLogicService;
import weatherstyle.gestionecitta.storage.dao.CittaDAOImpl;
import weatherstyle.gestionecitta.storage.service.InfoCittaImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "RichiestaCittaServlet", value = "/get-citta")
public class RichiestaCittaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String citta = request.getParameter("citta");
        CittaLogicService cittaLogicService = new CittaLogicImpl(new CittaDAOImpl(), new InfoCittaImpl());
        List<Citta> cittaList = cittaLogicService.ottieniCittaByName(citta);
        String json = cittaLogicService.ottieniJsonDaCitta(cittaList);

        if (json.length() > 0) {
            response.setContentType("application/json");
            response.getWriter().print(json);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
}
