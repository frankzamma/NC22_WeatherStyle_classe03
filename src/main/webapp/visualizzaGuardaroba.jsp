<%@ page import="weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.*" %>
<%@ page import="java.util.List" %>
<%@ page import="weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente" %><%--
  Created by IntelliJ IDEA.
  User: migli
  Date: 27/01/2023
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guardaroba</title>
    <%@include file="/WEB-INF/links.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/navbar.jsp"%>
<br>
<div class="container">

<%
List<CapoAbbigliamento> all = (List<CapoAbbigliamento>) request.getAttribute("all");
Utente ut = (Utente) request.getAttribute("utente");
%>

<h2>Guardaroba di <%=ut.getNome()%> <%=ut.getCognome()%></h2>
    <div class="row">
<%
for (CapoAbbigliamento c : all){
%>
        <div class="col">
            <div class="card" style="width: 18rem;">
                <img src="<%=c.getDirImmagine()%>" class="card-img-top">
                <div class="card-body">
                    <h5 class="card-title"><%=c.getNome()%></h5>
                    <form action="visualizza-dettagli-capo" method="get">
                        <input type="hidden" value="<%=c.getId()%>" name="id" id="id">
                        <input type="submit" value="Visualizza dettagli">
                    </form>
                </div>
            </div>
        </div>
<br>
<%
    }
%>
    </div>
</div>
<br>
<a href="controllo-login">Inserisci un capo d'abbigliamento nel guardaroba</a>
<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>
