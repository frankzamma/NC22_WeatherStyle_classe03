<%@ page import="weatherstyle.gestioneambiente.applicationlogic.logic.beans.Evento" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: angelopalmieri
  Date: 29/01/23
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visualizza eventi per l'ambiente</title>
    <%@include file="../links.jsp" %>
</head>
<body>
<%@include file="../navbar.jsp" %>
<div class="container mt-3">
    <h1>Gestione richieste promozione.</h1>
    <br>
    <%
        List<Evento> listaEventi = (List<Evento>) request.getAttribute("listaEventi");
        SimpleDateFormat dateTimeFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if (listaEventi == null) {
            %>
            <h6 class="display-7">Non ci sono eventi ambientali in programma, ci rincresce.</h6>
            <%
        }
        else {
                for(Evento evento: listaEventi) {
                %>
                <form method="post" action="VisualizzaDettagliEventoServlet">
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="text-dark"><%=evento.getNome()%></h5>
                            <p class="text-dark">Data e Ora: <%=dateTimeFormat.format(evento.getDataOraEvento())%></p>
                            <p class="text-dark">Luogo: <%=evento.getLuogo()%></p>
                            <input type="hidden" name="idEvento" value="<%=evento.getId()%>">
                            <button name="valutazione" type="submit" value="approvata" class="btn btn-primary">Visualizza dettagli</button>
                        </div>
                    </div>
                </form>
                <%
                }
            %>
    <%
        }

    %>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>

