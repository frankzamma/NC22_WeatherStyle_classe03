<%--
  Created by IntelliJ IDEA.
  User: raffaele aurucci
--%>
<%@ page import="weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDailyMin" %>
<%@ page import="weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Suggerimento" %>
<%@ page import="weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia" %>
<%@ page import="java.util.List" %>
<%@ page import="weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni" %>
<%@ page import="weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe" %>
<%@ page import="weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visualizza suggerimenti</title>
    <%@include file="../links.jsp"%>
</head>
<body>
<%
    Suggerimento suggerimento = (Suggerimento) request.getAttribute("suggerimento");
    List<Maglia> maglieSuggerite = (List<Maglia>) request.getAttribute("maglieSuggerite");
    List<Pantaloni> pantaloniSuggeriti = (List<Pantaloni>) request.getAttribute("pantaloniSuggeriti");
    List<Scarpe> scarpeSuggerite = (List<Scarpe>) request.getAttribute("scarpeSuggerite");
    MeteoDailyMin meteoDailyMin = suggerimento.getMeteoDailyMin();
    Citta citta = suggerimento.getCitta();
    List<String> errorList = (List<String>) request.getAttribute("errorList");
%>
<%@include file="../navbar.jsp"%>
<br>
<div class="container">
    <% if (errorList.size()>=1) { %>
    <div class="alert alert-danger" role="alert">
        <ul>
            <% for (String s : errorList){ %>
            <li>
                <%=s%>
            </li>
            <% } %>
        </ul>
    </div>
    <% }
    else { %>

    <h3 style="text-align: center">Ecco i capi d'abbigliamento ritenuti più adatti in base alle seguenti informazioni:</h3>
    <table class="table table-striped table-light">
        <thead>
        <tr>
            <th scope="col">Meteo</th>
            <th scope="col">Temperatura percepita media</th>
            <th scope="col">Stagione previsione</th>
            <th scope="col">Citta</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><%=meteoDailyMin.getMeteoStringMin()%></td>
            <td><%=meteoDailyMin.getTemperaturaPercepitaMedia()%> gradi celsius</td>
            <td><%=meteoDailyMin.getStagionePrevisione()%></td>
            <td><%=citta.getNome()%></td>
        </tr>
        </tbody>
    </table>


    <form action="SalvaSuggerimentoServlet" method="post">
        <h4 style="text-align: center">Maglie suggerite</h4>
        <div class="row justify-content-center">
            <% for(Maglia maglia: maglieSuggerite){ %>
            <input type="radio" id="<%=maglia.getId()%>" name="magliaID" value="<%=maglia.getId()%>"  class="btn-check"
                   autocomplete="off">
            <label class="btn btn-outline-primary col-md-3 m-1 text-center"  for="<%=maglia.getId()%>"  >
                <div class="card text-center text-dark col-align-self-center" style="background-color: transparent; border-color: transparent">
                    <img src="<%=maglia.getDirImmagine()%>" class="card-img-top rounded mx-auto d-block vestiti">
                    <div class="card-body">
                        <h5 class="card-title "><%=maglia.getNome()%></h5>
                        <p class="card-text"><b>Materiale: </b><%=maglia.getMateriale()%></p>
                        <p class="card-text"><b>Colore: </b><%=maglia.getColore()%></p>
                        <p class="card-text"><b>Stagione: </b><%=maglia.getStagione()%></p>
                        <p class="card-text"><b>Manica: </b><%=maglia.getLunghezzaManica()%></p>
                    </div>
                </div>
            </label>
            <% } %>
        </div>

        <br>

        <h4 style="text-align: center">Pantaloni suggeriti</h4>
        <div class="row justify-content-center">
            <% for(Pantaloni pantaloni: pantaloniSuggeriti){ %>
            <input type="radio" id="<%=pantaloni.getId()%>" name="pantaloniID" value="<%=pantaloni.getId()%>"  class="btn-check"
                   autocomplete="off">
            <label class="btn btn-outline-primary col-md-3 m-1 text-center"  for="<%=pantaloni.getId()%>"  >
                <div class="card text-center text-dark col-align-self-center" style="background-color: transparent; border-color: transparent">
                    <img src="<%=pantaloni.getDirImmagine()%>" class="card-img-top rounded mx-auto d-block vestiti">
                    <div class="card-body">
                        <h5 class="card-title"><%=pantaloni.getNome()%></h5>
                        <p class="card-text"><b>Materiale: </b><%=pantaloni.getMateriale()%></p>
                        <p class="card-text"><b>Colore: </b><%=pantaloni.getColore()%></p>
                        <p class="card-text"><b>Stagione: </b><%=pantaloni.getStagione()%></p>
                        <p class="card-text"><b>Manica: </b><%=pantaloni.getLunghezza()%></p>
                    </div>
                </div>
            </label>
            <% } %>
        </div>

        <br>

        <h4 style="text-align: center">Scarpe suggerite</h4>
        <div class="row justify-content-center">
            <% for(Scarpe scarpe: scarpeSuggerite){ %>
            <input type="radio" id="<%=scarpe.getId()%>" name="scarpeID" value="<%=scarpe.getId()%>"  class="btn-check"
                   autocomplete="off">
            <label class="btn btn-outline-primary col-md-3 m-1 text-center"  for="<%=scarpe.getId()%>"  >
                <div class="card text-center text-dark col-align-self-center" style="background-color: transparent; border-color: transparent">
                    <img src="<%=scarpe.getDirImmagine()%>" class="card-img-top rounded mx-auto d-block vestiti">
                    <div class="card-body">
                        <h5 class="card-title"><%=scarpe.getNome()%></h5>
                        <p class="card-text"><b>Tipo: </b><%=scarpe.getTipo()%></p>
                        <p class="card-text"><b>Colore: </b><%=scarpe.getColore()%></p>
                        <p class="card-text"><b>Antiscivolo: </b><%=scarpe.isAntiscivolo() ? "SI" : "NO"%></p>
                        <p class="card-text"><b>Impermeabile: </b><%=scarpe.isImpermeabile() ? "SI" : "NO"%></p>
                    </div>
                </div>
            </label>
            <% } %>
        </div>

        <br>

        <div class="row">
            <div class="col">
                <h4>Inserisci nome outfit</h4>
                <input type="text" class="form-control" name="nomeOutfit" placeholder="Inserisci un nome" id="nomeOutfit">
            </div>
        </div>

        <input type="hidden" name="nomeCitta" value="<%=citta.getNome()%>">
        <input type="hidden" name="latitudine" value="<%=citta.getLat()%>">
        <input type="hidden" name="longitudine" value="<%=citta.getLon()%>">
        <input type="hidden" name="meteo" value="<%=meteoDailyMin.getMeteoStringMin()%>">
        <input type="hidden" name="temperaturaPercepita" value="<%=meteoDailyMin.getTemperaturaPercepitaMedia()%>">
        <input type="hidden" name="stagionePrevisione" value="<%=meteoDailyMin.getStagionePrevisione()%>">

        <br>
        <div class="d-grid gap-2 mt-2">
            <button class="btn btn-primary" type="submit">Conferma outfit</button>
        </div>
    </form>
    <% } %>

</div>
<%@include file="../footer.jsp"%>
</body>
</html>
