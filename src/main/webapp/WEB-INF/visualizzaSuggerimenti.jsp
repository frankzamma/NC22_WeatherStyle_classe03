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
        String algoritmoIA = (String) request.getAttribute("algoritmoIA");
        MeteoInformation meteoInformation = (MeteoInformation) request.getAttribute("meteoInformation");
        List<CapoAbbigliamento> maglieSuggerite = (List<CapoAbbigliamento>) request.getAttribute("maglieSuggerite");
        List<CapoAbbigliamento> pantaloniSuggeriti = (List<CapoAbbigliamento>) request.getAttribute("pantaloniSuggeriti");
        List<CapoAbbigliamento> scarpeSuggerite = (List<CapoAbbigliamento>) request.getAttribute("scarpeSuggerite");
    %>
    <%@include file="navbar.jsp"%>
    <div class="container">
        <h3 class="display-6">Ecco i suggerimenti dei capi ritenuti più adatti in base alle seguenti informazioni metereologiche:</h3>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Meteo</th>
                    <th scope="col">Temperatura percepita</th>
                    <th scope="col">Stagione previsione</th>
                    <th scope="col">Tramite</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><%=meteoInformation.getMeteo()%></td>
                    <td><%=meteoInformation.getTemperaturaPercepita()%> gradi celsius</td>
                    <td><%=meteoInformation.getStagionePrevisione()%></td>
                    <%
                        if(algoritmoIA.equals("ga")){
                            %>
                                <td>Algoritmo genetico</td>
                        <% }
                        else {
                            if(algoritmoIA.equals("ml")){
                                %>
                                    <td>Machine learning</td>
                            <% }
                        }
                    %>
                </tr>
            </tbody>
        </table>
        <%
            if(maglieSuggerite.size() <= 0) { %>
        <br>
        <h3 class="display-6">Nessuna maglia è stata suggerita.</h3>
        <% }
        else {
                List<Double> punteggiMaglie = (List<Double>) request.getAttribute("punteggiMaglie");
        %>
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
                <%
                    if(punteggiMaglie != null){
                        %>
                        <th scope="col">Punteggio</th>
                        <%
                    }
                %>

            </tr>
            </thead>
            <tbody>
            <%
                int i = 0;
                for(CapoAbbigliamento capo: maglieSuggerite){
                    Maglia maglia = (Maglia) capo;
                %>
                    <tr>
                        <td><%=i%></td>
                        <td><%=maglia.getMateriale()%></td>
                        <td><%=maglia.getColore()%></td>
                        <td><%=maglia.getLunghezzaManica()%></td>
                        <td><%=maglia.getStagione()%></td>
                        <%
                            if(punteggiMaglie != null){
                                %>
                                    <td><%=punteggiMaglie.get(i)%></td>
                                <%
                            }
                        %>
                    </tr>
                <%  i++;
                } %>
            </tbody>
        </table>
        <% }

            if(pantaloniSuggeriti.size() <= 0) { %>
        <br>
        <h3 class="display-6">Nessun pantalone è stato suggerito.</h3>
        <% }
        else {
                List<Double> punteggiPantaloni = (List<Double>) request.getAttribute("punteggiPantaloni");
        %>
        <br>
        <h3 class="display-6">Pantaloni suggeriti</h3>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Materiale</th>
                <th scope="col">Colore</th>
                <th scope="col">Lunghezza pantalone</th>
                <th scope="col">Stagione</th>
                <%
                    if(punteggiPantaloni != null){
                        %>
                        <th scope="col">Punteggio</th>
                        <%
                    }
                %>
            </tr>
            </thead>
            <tbody>
            <%
                int i = 0;
                for(CapoAbbigliamento capo: pantaloniSuggeriti){
                    Pantalone pantalone = (Pantalone) capo;
                %>
                    <tr>
                        <td><%=i%></td>
                        <td><%=pantalone.getMateriale()%></td>
                        <td><%=pantalone.getColore()%></td>
                        <td><%=pantalone.getLunghezza()%></td>
                        <td><%=pantalone.getStagione()%></td>
                        <%
                            if(punteggiPantaloni != null){
                                %>
                                <td><%=punteggiPantaloni.get(i)%></td>
                                <%
                            }
                        %>
                    </tr>
                <%  i++;
            } %>
            </tbody>
        </table>
        <% }
 %>
    </div>
</body>
</html>
