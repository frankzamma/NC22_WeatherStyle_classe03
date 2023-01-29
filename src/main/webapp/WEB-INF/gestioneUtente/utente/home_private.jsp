<%@ page import="weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta" %>
<%@ page import="weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily" %>
<%@ page import="weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoUtils" %><%--
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
        <%
            MeteoDaily meteoDaily = (MeteoDaily) request.getAttribute("meteo-daily");
            Citta c  = (Citta) request.getAttribute("citta");
        %>
        <div class="container h-50">
            <h1>Meteo <%=c.getNome()%> </h1>
            <div class="row">
                <div class="col-md-3">
                    <form method="post" action="#">
                        <!--TODO aggiungere i parametri per il suggerimento -->
                        <button type="submit">Richiedi Suggerimento</button>
                    </form>
                </div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-9">
                            <img src="<%=MeteoUtils.imageFromWeatherCode(meteoDaily.getWeatherCode())%>"
                                 class="rounded mx-auto d-block" width="150" height="150" alt="<%=meteoDaily.getMeteoString()%>">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6 h6">
                            <%=meteoDaily.getTemperaturaPercepitaMinima()%> C°
                        </div>
                        <div class="col-6 h6">
                            <%=meteoDaily.getTemperaturaPercepitaMassima()%>C°
                        </div>
                    </div>
                </div>

            </div>

            <a href="${pageContext.request.contextPath}/dammiCittaMeteoFiglioDiPuta.html">Fatemi andare all'altro mondo!</a></center>
        </div>
        <%@include file="../../footer.jsp"%>
    </body>
</html>
