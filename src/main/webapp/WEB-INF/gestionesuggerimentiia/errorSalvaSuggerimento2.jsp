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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%
    List<Maglia> maglieSuggerite = (List<Maglia>) session.getAttribute("maglieSuggerite");
    List<Pantaloni> pantaloniSuggeriti = (List<Pantaloni>) session.getAttribute("pantaloniSuggeriti");
    List<Scarpe> scarpeSuggerite = (List<Scarpe>) session.getAttribute("scarpeSuggerite");
    MeteoDailyMin meteoDailyMin = (MeteoDailyMin) session.getAttribute("meteoDailyMin");
    Citta citta = (Citta) session.getAttribute("citta");
    String errorSalvaSuggerimento = (String) request.getAttribute("errorSalvaSuggerimento");
%>
<%@include file="../navbar.jsp"%>
<br>
<div class="container">
    <% if (errorSalvaSuggerimento != null) { %>
    <div class="alert alert-danger" role="alert">
        <ul>
            <li>
                <%=errorSalvaSuggerimento%>
            </li>
        </ul>
    </div>
    <% } %>

    <h3 class="display-6">Ecco i capi d'abbigliamento ritenuti più adatti in base alle seguenti informazioni:</h3>
    <table class="table table-striped">
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


    <form action="Salva2Servlet" method="post">
        <h3 class="display-6">Maglie suggerite</h3>
        <div class="row">
            <% for(Maglia maglia: maglieSuggerite){ %>
            <div class="card col-md-4" style="width: 18rem;">
                <img src="<%=maglia.getDirImmagine()%>" class="card-img-top">
                <div class="card-body">
                    <h5 class="card-title"><%=maglia.getNome()%></h5>
                    <p class="card-text"><b>Materiale: </b><%=maglia.getMateriale()%></p>
                    <p class="card-text"><b>Colore: </b><%=maglia.getColore()%></p>
                    <p class="card-text"><b>Stagione: </b><%=maglia.getStagione()%></p>
                    <p class="card-text"><b>Manica: </b><%=maglia.getLunghezzaManica()%></p>
                    <input type="radio" id="<%=maglia.getId()%>" name="magliaID" value="<%=maglia.getId()%>">
                </div>
            </div>
            <% } %>
        </div>

        <br>

        <h3 class="display-6">Pantaloni suggeriti</h3>
        <div class="row">
            <% for(Pantaloni pantaloni: pantaloniSuggeriti){ %>
            <div class="card col-md-4" style="width: 18rem;">
                <img src="<%=pantaloni.getDirImmagine()%>" class="card-img-top">
                <div class="card-body">
                    <h5 class="card-title"><%=pantaloni.getNome()%></h5>
                    <p class="card-text"><b>Materiale: </b><%=pantaloni.getMateriale()%></p>
                    <p class="card-text"><b>Colore: </b><%=pantaloni.getColore()%></p>
                    <p class="card-text"><b>Stagione: </b><%=pantaloni.getStagione()%></p>
                    <p class="card-text"><b>Manica: </b><%=pantaloni.getLunghezza()%></p>
                    <input type="radio" id="<%=pantaloni.getId()%>" name="pantaloniID" value="<%=pantaloni.getId()%>">
                </div>
            </div>
            <% } %>
        </div>

        <br>

        <h3 class="display-6">Scarpe suggerite</h3>
        <div class="row">
            <% for(Scarpe scarpe: scarpeSuggerite){ %>
            <div class="card col-md-4" style="width: 18rem;">
                <img src="<%=scarpe.getDirImmagine()%>" class="card-img-top">
                <div class="card-body">
                    <h5 class="card-title"><%=scarpe.getNome()%></h5>
                    <p class="card-text"><b>Tipo: </b><%=scarpe.getTipo()%></p>
                    <p class="card-text"><b>Colore: </b><%=scarpe.getColore()%></p>
                    <p class="card-text"><b>Antiscivolo: </b><%=scarpe.isAntiscivolo() ? "SI" : "NO"%></p>
                    <p class="card-text"><b>Impermeabile: </b><%=scarpe.isImpermeabile() ? "SI" : "NO"%></p>
                    <input type="radio" id="<%=scarpe.getId()%>" name="scarpeID" value="<%=scarpe.getId()%>">
                </div>
            </div>
            <% } %>
        </div>
        <label for="nomeOutfit">Inserisci nome outfit</label>
        <br>
        <input type="text" name="nomeOutfit" placeholder="Inserisci un nome" id="nomeOutfit">
        <br>

        <button type="submit">Conferma outfit</button>
    </form>

</div>
<%@include file="../footer.jsp"%>
</body>
</html>
