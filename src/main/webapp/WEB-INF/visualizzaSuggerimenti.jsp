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
        MeteoInformationLegacy meteoInformationLegacy = (MeteoInformationLegacy) request.getAttribute("meteoInformation");
        List<CapoAbbigliamentoLegacy> maglieSuggerite = (List<CapoAbbigliamentoLegacy>) request.getAttribute("maglieSuggerite");
        List<CapoAbbigliamentoLegacy> pantaloniSuggeriti = (List<CapoAbbigliamentoLegacy>) request.getAttribute("pantaloniSuggeriti");
        List<CapoAbbigliamentoLegacy> scarpeSuggerite = (List<CapoAbbigliamentoLegacy>) request.getAttribute("scarpeSuggerite");
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
                    <td><%=meteoInformationLegacy.getMeteo()%></td>
                    <td><%=meteoInformationLegacy.getTemperaturaPercepita()%> gradi celsius</td>
                    <td><%=meteoInformationLegacy.getStagionePrevisione()%></td>
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
                for(CapoAbbigliamentoLegacy capo: maglieSuggerite){
                    MagliaLegacy magliaLegacy = (MagliaLegacy) capo;
                %>
                    <tr>
                        <td><%=i%></td>
                        <td><%=magliaLegacy.getMateriale()%></td>
                        <td><%=magliaLegacy.getColore()%></td>
                        <td><%=magliaLegacy.getLunghezzaManica()%></td>
                        <td><%=magliaLegacy.getStagione()%></td>
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
        <h3 class="display-6">Nessun pantaloni è stato suggerito.</h3>
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
                <th scope="col">Lunghezza pantaloni</th>
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
                for(CapoAbbigliamentoLegacy capo: pantaloniSuggeriti){
                    PantaloniLegacy pantaloni = (PantaloniLegacy) capo;
                %>
                    <tr>
                        <td><%=i%></td>
                        <td><%=pantaloni.getMateriale()%></td>
                        <td><%=pantaloni.getColore()%></td>
                        <td><%=pantaloni.getLunghezza()%></td>
                        <td><%=pantaloni.getStagione()%></td>
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

            if(scarpeSuggerite.size() == 0) { %>
        <br>
        <h3 class="display-6">Nessun pantaloni è stato suggerito.</h3>
        <% }
        else {
            List<Double> punteggiScarpe = (List<Double>) request.getAttribute("punteggiScarpe");
        %>
        <br>
        <h3 class="display-6">Scarpe suggerite</h3>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Tipo</th>
                <th scope="col">Colore</th>
                <th scope="col">Antiscivolo</th>
                <th scope="col">Impermeabile</th>
                <th scope="col">Stagione</th>
                <%
                    if(punteggiScarpe != null){
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
                for(CapoAbbigliamentoLegacy capo: scarpeSuggerite){
                    ScarpaLegacy scarpa = (ScarpaLegacy) capo;
            %>
            <tr>
                <td><%=i%></td>
                <td><%=scarpa.getTipo()%></td>
                <td><%=scarpa.getColore()%></td>
                <td><%=scarpa.getAntiscivolo() ? "SI" : "NO"%></td>
                <td><%=scarpa.getImpermeabile() ? "SI" : "NO"%></td>
                <td><%=scarpa.getStagione()%></td>
                <%
                    if(punteggiScarpe != null){
                %>
                <td><%=punteggiScarpe.get(i)%></td>
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
    <%@include file="footer.jsp"%>
</body>
</html>
