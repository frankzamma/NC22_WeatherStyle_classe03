<%@ page import="weatherstyle.gestioneambiente.applicationlogic.logic.beans.Evento" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: angelopalmieri
  Date: 29/01/23
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visualizza dettagli evento</title>
    <%@include file="../links.jsp"%>
</head>
<body>
<%@include file="../navbar.jsp"%>
<div class="container">
    <%
        Evento evento = (Evento) request.getAttribute("evento");
        SimpleDateFormat dateTimeFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm");
    %>
    <h1>Dettagli evento</h1>
    <h6 class="display-7">Ecco i dettagli dell'evento selezionato.</h6>
    <div class="container">
        <ul class="list-group">
            <li class="list-group-item">Nome evento: <%=evento.getNome()%></li>
            <li class="list-group-item">Data e ora: <%=dateTimeFormat.format(evento.getDataOraEvento())%></li>
            <li class="list-group-item">Luogo: <%=evento.getLuogo()%></li>
            <li class="list-group-item">Descrizione: <%=evento.getDescrizione()%></li>
            <li class="list-group-item">Altre informazioni: <%=evento.getAltreInformazioni()%></li>
        </ul>
    </div>
    <%@include file="../footer.jsp"%>
</div>
</body>
</html>