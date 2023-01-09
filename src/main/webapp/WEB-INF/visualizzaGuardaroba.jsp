<%@ page import="java.util.List" %>
<%@ page import="Model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visualizza Guardaroba</title>
    <%@include file="links.jsp"%>
</head>
<body>
    <%
        Guardaroba guardaroba = (Guardaroba) session.getAttribute("guardaroba");
        List<Maglia> listaMaglie = guardaroba.getMagliaList();
        List<Pantalone> listaPantaloni = guardaroba.getPantaloneList();
        List<Scarpa> listaScarpe = guardaroba.getScarpaList();
    %>
    <%@include file="navbar.jsp"%>
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
        <h3 class="display-6">Nessun pantalone presente nel guardaroba.</h3>
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
                    for(Pantalone pantalone: listaPantaloni){ %>
                        <tr>
                            <td><%=i%></td>
                            <td><%=pantalone.getMateriale()%></td>
                            <td><%=pantalone.getColore()%></td>
                            <td><%=pantalone.getLunghezza()%></td>
                            <td><%=pantalone.getStagione()%></td>
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

</body>
</html>
