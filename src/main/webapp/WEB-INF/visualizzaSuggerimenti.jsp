<%@ page import="java.util.List" %>
<%@ page import="Model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visualizza suggerimenti</title>
    <%@include file="links.jsp"%>
</head>
<body>
    <%
        MeteoInformation meteoInformation = (MeteoInformation) request.getAttribute("meteoInformation");
        List<ScoreCapoAbbigliamento> scoreBestTop = (List<ScoreCapoAbbigliamento>) request.getAttribute("scoreBestTop");
        List<ScoreCapoAbbigliamento> scoreBestBottom = (List<ScoreCapoAbbigliamento>) request.getAttribute("scoreBestBottom");
        List<ScoreCapoAbbigliamento> scoreBestShoes = (List<ScoreCapoAbbigliamento>) request.getAttribute("scoreBestShoes");
    %>
    <%@include file="navbar.jsp"%>
    <h3 class="display-6">Ecco i suggerimenti dei capi ritenuti più adatti in base alle seguenti informazioni metereologiche:</h3>
    <h5 class="display-6">Meteo: <%=meteoInformation.getMeteo()%>; <br> Temperatura Percepita: <%=meteoInformation.getTemperaturaPercepita()%>; <br> Stagione previsione: <%=meteoInformation.getStagionePrevisione()%>;</h5>
    <%
        if(scoreBestTop.size() <= 0) { %>
    <br>
    <h3 class="display-6">Nessuna maglia è stata suggerita.</h3>
    <% }
    else { %>
    <br>
    <h3 class="display-6">Maglie suggerite</h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Materiale</th>
            <th scope="col">Colore</th>
            <th scope="col">Manica</th>
            <th scope="col">Stagione</th>
            <th scope="col">Punteggio</th>
        </tr>
        </thead>
        <tbody>
        <%
            int i = 1;
            for(ScoreCapoAbbigliamento capo: scoreBestTop){
                Maglia maglia = (Maglia) capo.getCapoAbbigliamento();
            %>
                <tr>
                    <td><%=i%></td>
                    <td><%=maglia.getMateriale()%></td>
                    <td><%=maglia.getColore()%></td>
                    <td><%=maglia.getLunghezzaManica()%></td>
                    <td><%=maglia.getStagione()%></td>
                    <td><%=capo.getPunteggio()%></td>
                </tr>
            <%  i++;
            } %>
        </tbody>
    </table>
    <% }

        if(scoreBestBottom.size() <= 0) { %>
    <br>
    <h3 class="display-6">Nessun pantalone è stato suggerito.</h3>
    <% }
    else { %>
    <br>
    <h3 class="display-6">Pantaloni suggeriti</h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Materiale</th>
            <th scope="col">Colore</th>
            <th scope="col">Manica</th>
            <th scope="col">Stagione</th>
            <th scope="col">Punteggio</th>
        </tr>
        </thead>
        <tbody>
        <%
            int i = 1;
            for(ScoreCapoAbbigliamento capo: scoreBestBottom){
                Pantalone pantalone = (Pantalone) capo.getCapoAbbigliamento();
            %>
                <tr>
                    <td><%=i%></td>
                    <td><%=pantalone.getMateriale()%></td>
                    <td><%=pantalone.getColore()%></td>
                    <td><%=pantalone.getLunghezza()%></td>
                    <td><%=pantalone.getStagione()%></td>
                    <td><%=capo.getPunteggio()%></td>
                </tr>
            <%  i++;
        } %>
        </tbody>
    </table>
    <% }

        if(scoreBestShoes.size() <= 0) { %>
    <br>
    <h3 class="display-6">Nessuna scarpa è stata suggerita.</h3>
    <% }
    else { %>
    <br>
    <h3 class="display-6">Scarpe suggerite</h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Tipo</th>
            <th scope="col">Scivoloso</th>
            <th scope="col">Impermeabile</th>
            <th scope="col">Colore</th>
            <th scope="col">Stagione</th>
            <th scope="col">Punteggio</th>
        </tr>
        </thead>
        <tbody>
        <%
            int i = 1;
            for(ScoreCapoAbbigliamento capo: scoreBestShoes){
                Scarpa scarpa = (Scarpa) capo.getCapoAbbigliamento();
            %>
                <tr>
                    <td><%=i%></td>
                    <td><%=scarpa.getTipo()%></td>
                    <% if(scarpa.getScivoloso()){ %>
                    <td>Si</td>
                    <% }
                    else { %>
                    <td>No</td>
                    <% }
                        if(scarpa.getImpermeabile()){ %>
                    <td>Si</td>
                    <% }
                    else { %>
                    <td>No</td>
                    <% } %>
                    <td><%=scarpa.getColore()%></td>
                    <td><%=scarpa.getStagione()%></td>
                    <td><%=capo.getPunteggio()%></td>
                </tr>
            <%  i++;
        } %>
        </tbody>
    </table>
    <% } %>

</body>
</html>
