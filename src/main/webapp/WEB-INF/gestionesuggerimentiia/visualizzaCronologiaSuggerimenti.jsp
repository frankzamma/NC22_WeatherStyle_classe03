<%--
  Created by IntelliJ IDEA.
  User: raffaele aurucci
--%>
<%@ page import="weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Suggerimento" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../links.jsp"%>
    <title>Cronologia suggerimenti</title>
</head>
<body>
<% List<Suggerimento> suggerimentoList = (List<Suggerimento>) request.getAttribute("suggerimentoList"); %>
<%@include file="../navbar.jsp"%>

<div class="container">

    <h3>Cronologia suggerimenti:</h3>

    <% if (suggerimentoList.size() == 0){ %>
        <p>Non hai ancora salvato alcun suggerimento, cosa aspetti a farlo?</p>
    <% } else { %>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">
                        Data suggerimento
                    </th>
                    <th scope="col">
                        Citta
                    </th>
                    <th scope="col">
                        Meteo
                    </th>
                    <th scope="col">
                        Temperatura percepita
                    </th>
                    <th scope="col">
                        Stagione
                    </th>
                    <th scope="col">
                        Nome outfit
                    </th>
                    <th scope="col">
                        Maglia
                    </th>
                    <th scope="col">
                        Pantalone
                    </th>
                    <th scope="col">
                        Scarpe
                    </th>
                </tr>
            </thead>
        <tbody>
        <%for (Suggerimento suggerimento: suggerimentoList) { %>
            <tr>
                <td>
                    <%=suggerimento.getDate()%>
                </td>
                <td>
                    <%=suggerimento.getCitta().getNome()%>
                </td>
                <td>
                    <%=suggerimento.getMeteoDailyMin().getMeteoStringMin()%>
                </td>
                <td>
                    <%=suggerimento.getMeteoDailyMin().getTemperaturaPercepitaMedia()%>
                </td>
                <td>
                    <%=suggerimento.getMeteoDailyMin().getStagionePrevisione()%>
                </td>
                <td>
                    <%=suggerimento.getOutfit().getNome()%>
                </td>
                <td>
                    <img src="<%=suggerimento.getOutfit().getMaglia().getDirImmagine()%>" width="60" height="60">
                </td>
                <td>
                    <img src="<%=suggerimento.getOutfit().getPantaloni().getDirImmagine()%>" width="60" height="60">
                </td>
                <td>
                    <img src="<%=suggerimento.getOutfit().getScarpe().getDirImmagine()%>" width="60" height="60">
                </td>
            </tr>
        <% } %>
        </tbody>
        </table>
    <% } %>
    </div>
<%@include file="../footer.jsp"%>
</body>
</html>
