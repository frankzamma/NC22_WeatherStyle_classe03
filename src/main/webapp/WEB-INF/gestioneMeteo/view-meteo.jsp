<%@ page import="java.util.List" %>
<%@ page import="weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="weatherstyle.gestionemeteo.applicationlogic.logic.beans.*" %><%--
  Created by IntelliJ IDEA.
  User: frank
  Date: 30/01/2023
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<MeteoDaily> meteoDaily = (List<MeteoDaily>) request.getAttribute("meteo-daily");
    List<MeteoHours> meteoHours =  (List<MeteoHours>) request.getAttribute("meteo-hours");
    Citta c  = (Citta) request.getAttribute("citta");
%>
<div class="container">
    <h1>Meteo <%=c.getNome()%> </h1>
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" onclick="changePage(0)" id="tab-0" aria-current="page" >Oggi</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" onclick="changePage(1)" id="tab-1" href="#">Domani</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" onclick="changePage(2)"id="tab-2" href="#">Dopodomani</a>
        </li>
    </ul>
    <%for (int i = 0; i < meteoDaily.size(); i++){%>
    <div id="meteo-<%=i%>"
            <%if (i != 0){%>
         style="display: none"
            <%}%>
    >
        <div class="row">
            <div class="col-md-3 mt-2">
                <form method="post" action="RichiestaSuggerimentoServlet">
                    <%
                        MeteoDailyMin meteoDailyMin =  meteoDaily.get(i).toMeteoDailyMin();
                    %>
                    <input type="hidden" name="meteo" value="<%=meteoDailyMin.getMeteoStringMin()%>">
                    <input type="hidden" name="temperaturaPercepita"
                           value="<%=meteoDailyMin.getTemperaturaPercepitaMedia()%>">
                    <input type="hidden" name="stagionePrevisione" value="<%=meteoDailyMin.getStagionePrevisione()%>">
                    <input type="hidden" name="nomeCitta" value="<%=c.getNome()%>">
                    <input type="hidden" name="lat" value="<%=c.getLat()%>">
                    <input type="hidden" name="lon" value="<%=c.getLon()%>">
                    <button type="submit" class="btn btn-warning">Richiedi Suggerimento</button>
                </form>
            </div>
            <div class="col-md-4">
                <div class="row">
                    <div class="col-9">
                        <img src="<%=MeteoUtils.imageFromWeatherCode(meteoDaily.get(i).getWeatherCode())%>"
                             class="rounded mx-auto d-block" width="150" height="150" alt="<%=meteoDaily.get(i).getMeteoString()%>">
                    </div>
                </div>
                <div class="row">
                    <div class="col-6 h6">
                        <%=meteoDaily.get(i).getTemperaturaPercepitaMinima()%> C°
                    </div>
                    <div class="col-6 h6">
                        <%=meteoDaily.get(i).getTemperaturaPercepitaMassima()%>C°
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <h2>Meteo Orario <%=meteoDaily.get(i).getTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))%></h2>
            <%MeteoHours today = meteoHours.get(i);%>

            <table class="table table-striped table-light">
                <thead>
                <th>
                    Ora
                </th>
                <th>
                    Meteo
                </th>
                <th>
                    Temperatura
                </th>
                <th>
                    Precipitazioni
                </th>
                <th>
                    Visibilità
                </th>
                <th>
                    Velocità del vento
                </th>
                <th>
                    Umidità relativa
                </th>
                </thead>
                <tbody>
                <%for(MeteoHour meteo: today.getMeteoInfo()){%>
                <tr>
                    <td>
                        <%=meteo.getTime()
                        %>
                    </td>
                    <td>
                        <div class="row">
                            <div class="col-1">
                                <img src="<%=MeteoUtils.imageFromWeatherCode(meteo.getWeatherCode())%>"
                                     class="rounded mx-auto d-block" width="20" height="20" alt="<%=meteo.getMeteoString()%>">
                            </div>
                            <div class="col-11">
                                <%=meteo.getMeteoString()%>
                            </div>
                        </div>
                    </td>
                    <td>
                        <%=meteo.getTemperatura() + "C°"%>
                    </td>
                    <td>
                        <%=meteo.getPrecipitazioni() + "mm"%>
                    </td>
                    <td>
                        <%=meteo.getVisibilitaMetri()/1000+ "km"%>
                    </td>
                    <td>
                        <%=meteo.getWindSpeed() + "km/h"%>
                    </td>
                    <td>
                        <%=meteo.getUmiditaRelativa() + "%"%>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
    <%}%>
</div>
<script src="./script/page-meteo-script.js" type="text/javascript"></script>