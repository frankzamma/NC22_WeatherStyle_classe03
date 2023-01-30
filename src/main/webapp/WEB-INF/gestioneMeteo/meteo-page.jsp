<%@ page import="weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta" %><%--
  Created by IntelliJ IDEA.
  User: frank
  Date: 30/01/2023
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <%
            Citta citta = (Citta) request.getAttribute("citta");
        %>
        <title>Meteo <%=citta.getNome()%></title>
        <%@include file="../links.jsp" %>
    </head>
    <body>
        <%@include file="../navbar.jsp" %>
        <%@include file="view-meteo.jsp"%>
        <%@include file="../footer.jsp" %>
    </body>
</html>
