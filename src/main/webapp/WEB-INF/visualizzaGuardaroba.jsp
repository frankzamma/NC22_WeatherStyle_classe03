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
            Guardaroba guardaroba = (Guardaroba) session.getAttribute("guardaroba");
            List<Maglia> listaMaglie = guardaroba.getMagliaList();
            List<Pantaloni> listaPantaloni = guardaroba.getPantaloneList();
            List<Scarpa> listaScarpe = guardaroba.getScarpaList();
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
                for(Maglia maglia: listaMaglie){ %>
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

            if(listaPantaloni.size() <= 0) { %>
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
                for(Pantaloni pantaloni : listaPantaloni){ %>
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
                for(Scarpa scarpa: listaScarpe){ %>
            <tr>
                <td><%=i%></td>
                <td><%=scarpa.getTipo()%></td>
                <% if(scarpa.getAntiscivolo()){ %>
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
