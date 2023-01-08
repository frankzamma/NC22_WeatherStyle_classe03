<%@ page import="Model.Guardaroba" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Maglia" %>
<%@ page import="Model.Pantalone" %>
<%@ page import="Model.Scarpa" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visualizza Guardaroba</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
    <%
        Guardaroba guardaroba = (Guardaroba) session.getAttribute("guardaroba");
        List<Maglia> listaMaglie = guardaroba.getMagliaList();
        List<Pantalone> listaPantaloni = guardaroba.getPantaloneList();
        List<Scarpa> listaScarpe = guardaroba.getScarpaList();
    %>

    <div class="container text-center">
        <div class="row">
            <div class="col">
                <img src="logo.png" class="rounded mx-auto d-block" width="100" height="100">
            </div>
        </div>
        <div class="row">
            <div class="col">
                <h1>WeatherStyle</h1>
            </div>
        </div>
    </div>

    <nav class="navbar navbar-expand-lg navbar-light" style="background-color:#e3f2fd;">
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.html">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="GuardarobaServlet">Guardaroba</a>
                </li>
            </ul>
        </div>
    </nav>

    <%
        if(listaMaglie.size() <= 0) { %>
    <h3 class="display-6">Nessuna maglia presente nel guardaroba.</h3>
    <% }
    else { %>
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
    <h3 class="display-6">Nessun pantalone presente nel guardaroba.</h3>
    <% }
    else { %>
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
        <h3 class="display-6">Nessuna scarpa presente nel guardaroba.</h3>
    <% }
    else { %>
            <h3 class="display-6">Scarpe</h3>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Tipo</th>
                    <th scope="col">Scivoloso</th>
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
                        </tr>
                        <%  i++;
                    } %>
                </tbody>
            </table>
    <% } %>

</body>
</html>
