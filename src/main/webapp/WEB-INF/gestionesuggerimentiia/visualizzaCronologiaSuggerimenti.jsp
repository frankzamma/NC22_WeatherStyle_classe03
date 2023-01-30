<%@ page import="weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Suggerimento" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: rafau
  Date: 28/01/2023
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../links.jsp"%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Cronologia suggerimenti</title>
</head>
<body>
<% List<Suggerimento> suggerimentoList = (List<Suggerimento>) request.getAttribute("suggerimentoList"); %>
<%@include file="../navbar.jsp"%>
<h3>Cronologia suggerimenti:</h3>
<table>
    <tr>
        <th>
            Data suggerimento
        </th>
        <th>
            Citta
        </th>
        <th>
            Meteo
        </th>
        <th>
            Temperatura percepita
        </th>
        <th>
            Stagione
        </th>
        <th>
            Nome outfit
        </th>
        <th>
            Maglia
        </th>
        <th>
            Pantalone
        </th>
        <th>
            Scarpa
        </th>
    </tr>
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
            <img src="<%=suggerimento.getOutfit().getMaglia().getDirImmagine()%>">
        </td>
        <td>
            <img src="<%=suggerimento.getOutfit().getPantaloni().getDirImmagine()%>">
        </td>
        <td>
            <img src="<%=suggerimento.getOutfit().getScarpe().getDirImmagine()%>">
        </td>
    </tr>
<% } %>
</table>
</body>
</html>
