<%@ page import="java.util.List" %>
<%@ page import="Model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visualizza Guardaroba</title>
    <%@include file="links.jsp"%>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <div class="container">
        <%
            GuardarobaLegacy guardarobaLegacy = (GuardarobaLegacy) session.getAttribute("guardaroba");
            List<MagliaLegacy> listaMaglie = guardarobaLegacy.getMagliaList();
            List<PantaloniLegacy> listaPantaloniLegacy = guardarobaLegacy.getPantaloneList();
            List<ScarpaLegacy> listaScarpe = guardarobaLegacy.getScarpaList();
        %>

        <%
            if(listaMaglie.size() <= 0) { %>
        <br>
        <h3 class="display-6">Nessuna maglia presente nel guardaroba.</h3>
        <% }
        else { %>
        <br>
        <h3 class="display-6">Maglie</h3>
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
                int i = 1;
                for(MagliaLegacy maglia: listaMaglie){ %>
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
        <% }

            if(listaPantaloniLegacy.size() <= 0) { %>
        <br>
        <h3 class="display-6">Nessun pantaloni presente nel guardaroba.</h3>
        <% }
        else { %>
        <br>
        <h3 class="display-6">Pantaloni</h3>
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
                int i = 1;
                for(PantaloniLegacy pantaloni : listaPantaloniLegacy){ %>
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
        <% }

            if(listaScarpe.size() <= 0) { %>
        <br>
        <h3 class="display-6">Nessuna scarpa presente nel guardaroba.</h3>
        <% }
        else { %>
        <br>
        <h3 class="display-6">Scarpe</h3>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Tipo</th>
                <th scope="col">Antiscivolo</th>
                <th scope="col">Impermeabile</th>
                <th scope="col">Colore</th>
                <th scope="col">Stagione</th>
            </tr>
            </thead>
            <tbody>
            <%
                int i = 1;
                for(ScarpaLegacy scarpaLegacy : listaScarpe){ %>
            <tr>
                <td><%=i%></td>
                <td><%=scarpaLegacy.getTipo()%></td>
                <% if(scarpaLegacy.getAntiscivolo()){ %>
                <td>Si</td>
                <% }
                else { %>
                <td>No</td>
                <% }
                    if(scarpaLegacy.getImpermeabile()){ %>
                <td>Si</td>
                <% }
                else { %>
                <td>No</td>
                <% } %>
                <td><%=scarpaLegacy.getColore()%></td>
                <td><%=scarpaLegacy.getStagione()%></td>
            </tr>
            <%  i++;
            } %>
            </tbody>
        </table>
        <% } %>
    </div>
    <%@include file="footer.jsp"%>
</body>
</html>
