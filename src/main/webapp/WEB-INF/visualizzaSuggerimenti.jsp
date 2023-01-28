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
    <%@include file="links.jsp"%>
</head>
<body>
    <%
        Suggerimento suggerimento = (Suggerimento) request.getAttribute("suggerimento");
        List<Maglia> maglieSuggerite = (List<Maglia>) request.getAttribute("maglieSuggerite");
        List<Pantaloni> pantaloniSuggeriti = (List<Pantaloni>) request.getAttribute("pantaloniSuggeriti");
        List<Scarpe> scarpeSuggerite = (List<Scarpe>) request.getAttribute("scarpeSuggerite");
        MeteoDailyMin meteoDailyMin = suggerimento.getMeteoDailyMin();
        Citta citta = suggerimento.getCitta();
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
                    <td><%=meteoDailyMin.getMeteoStringMin()%></td>
                    <td><%=meteoDailyMin.getTemperaturaPercepitaMedia()%> gradi celsius</td>
                    <td><%=meteoDailyMin.getStagionePrevisione()%></td>
                </tr>
            </tbody>
        </table>

        <% if(maglieSuggerite.size() == 0) { %>
            <br>
            <h3 class="display-6">Nessuna maglia è stata suggerita, per ricevere suggerimenti devi avere almeno 3 maglie!</h3>
        <% } else { %>
            <h3 class="display-6">Maglie suggerite</h3>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Materiale</th>
                    <th scope="col">Colore</th>
                    <th scope="col">Manica</th>
                    <th scope="col">Stagione</th>

                </tr>
                </thead>
                <tbody>
                <%
                    int i = 0;
                    for(Maglia maglia: maglieSuggerite){ %>
                        <tr>
                            <td><%=i%></td>
                            <td><%=maglia.getMateriale()%></td>
                            <td><%=maglia.getColore()%></td>
                            <td><%=maglia.getLunghezzaManica()%></td>
                            <td><%=maglia.getStagione()%></td>
                        </tr>
                    <%  i++;
                    } %>
                </tbody>
            </table>
        <% } %>


        <% if(pantaloniSuggeriti.size() == 0) { %>
            <br>
            <h3 class="display-6">Nessun pantalone è stata suggerito, per ricevere suggerimenti devi avere almeno 3 pantaloni!</h3>
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
                    <th scope="col">Lunghezza pantaloni</th>
                    <th scope="col">Stagione</th>
                </tr>
                </thead>
                <tbody>
                <%
                    int i = 0;
                    for(Pantaloni pantaloni: pantaloniSuggeriti){ %>
                        <tr>
                            <td><%=i%></td>
                            <td><%=pantaloni.getMateriale()%></td>
                            <td><%=pantaloni.getColore()%></td>
                            <td><%=pantaloni.getLunghezza()%></td>
                            <td><%=pantaloni.getStagione()%></td>
                        </tr>
                    <%  i++;
                } %>
                </tbody>
            </table>
        <% } %>

        <% if(scarpeSuggerite.size() == 0) { %>
            <br>
            <h3 class="display-6">Nessun paio di scarpe è stato suggerito, devi avere almeno 3 paia di scarpe!</h3>
        <% }
        else { %>
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
                </tr>
                </thead>
                <tbody>
                <%
                    int i = 0;
                    for(Scarpe scarpe: scarpeSuggerite){ %>
                <tr>
                    <td><%=i%></td>
                    <td><%=scarpe.getTipo()%></td>
                    <td><%=scarpe.getColore()%></td>
                    <td><%=scarpe.isAntiscivolo() ? "SI" : "NO"%></td>
                    <td><%=scarpe.isImpermeabile() ? "SI" : "NO"%></td>
                    <td><%=scarpe.getStagione()%></td>
                </tr>
                <%  i++; } %>
                </tbody>
            </table>
            <% } %>
    </div>
    <%@include file="footer.jsp"%>
</body>
</html>
