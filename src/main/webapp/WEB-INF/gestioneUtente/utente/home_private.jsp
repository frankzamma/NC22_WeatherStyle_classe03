<%@ page import="weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta" %>
<%@ page import="weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily" %>
<%@ page import="weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoUtils" %>
<%@ page import="java.util.List" %>
<%@ page import="weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoHours" %>
<%@ page import="weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoHour" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: frank
  Date: 28/01/2023
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>WeatherStyle</title>
        <%@include file="../../links.jsp"%>
    </head>
    <body>
        <%@include file="../../navbar.jsp"%>
        <%@include file="../../gestioneMeteo/view-meteo.jsp"%>
        <%@include file="../../footer.jsp"%>
        <script src="./script/page-meteo-script.js" type="text/javascript"></script>
    </body>
</html>
