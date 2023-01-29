<%@ page import="java.util.List" %>
<%@ page import="weatherstyle.gestioneambiente.applicationlogic.logic.beans.RichiestaPromozione" %><%--
  Created by IntelliJ IDEA.
  User: angelopalmieri
  Date: 29/01/23
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestisci richieste promozione in ecologista</title>
    <%@include file="../links.jsp" %>
</head>
<body>
<%@include file="../navbar.jsp" %>
<div class="container mt-3">
    <h1>Gestione richieste promozione.</h1>
    <br>
    <%
        List<RichiestaPromozione> listaRichiestePromozione = (List<RichiestaPromozione>) request.getAttribute("listaRichiestePromozione");
        if (listaRichiestePromozione == null) {
            %>
                <h6 class="display-7">Non ci sono richieste di promozione in attesa di essere valutate.</h6>
            <%
        }
        else {
                for(RichiestaPromozione richiestaPromozione: listaRichiestePromozione) {
                    %>
                        <form method="post" action="ValutaRichiesteServlet">
                            <div class="card" style="width: 18rem;">
                                <div class="card-body">
                                    <h5 class="text-dark">Richiesta promozione</h5>
                                    <p class="text-dark">Tematiche d'interesse: <%=richiestaPromozione.getTematiche()%></p>
                                    <p class="text-dark">Esperienze: <%=richiestaPromozione.getEsperienze()%></p>
                                    <input type="hidden" name="idRichiestaPromozione" value="<%=richiestaPromozione.getId()%>">
                                    <button name="valutazione" type="submit" value="approvata" class="btn btn-primary">Approva</button>
                                    <button name="valutazione" type="submit" value="rifiutata" class="btn btn-primary">Rifiuta</button>
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
