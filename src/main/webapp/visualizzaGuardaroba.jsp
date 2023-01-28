<%@ page import="weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Guardaroba" %>
<%@ page import="weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia" %>
<%@ page import="weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni" %>
<%@ page import="weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe" %><%--
  Created by IntelliJ IDEA.
  User: migli
  Date: 27/01/2023
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guardaroba</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%
Guardaroba g = (Guardaroba) request.getAttribute("guardaroba");
%>

<h2>Maglie</h2>
<%
for (Maglia m : g.getMaglie()){
%>
<div class="card" style="width: 18rem;">
    <img src="<%=m.getDirImmagine()%>" class="card-img-top">
    <div class="card-body">
        <h5 class="card-title"><%=m.getNome()%>></h5>
        <!--<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>-->
        <form action="visualizza-dettagli-capo" method="post">
            <input type="hidden" value="<%=m.getId()%>" name="idMaglia" id="idMaglia">
            <input type="submit" value="Visualizza dettagli">
        </form>
    </div>
</div>
<%
    }
%>
<br>
<h2>Pantaloni</h2>
<%
    for (Pantaloni p : g.getPantaloni()){
%>
<div class="card" style="width: 18rem;">
    <img src="<%=p.getDirImmagine()%>" class="card-img-top">
    <div class="card-body">
        <h5 class="card-title"><%=p.getNome()%>></h5>
        <!--<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>-->
        <form action="visualizza-dettagli-capo" method="post">
            <input type="hidden" value="<%=p.getId()%>" name="idPantaloni" id="idPantaloni">
            <input type="submit" value="Visualizza dettagli">
        </form>
    </div>
</div>
<%
    }
%>
<br>
<h2>Scarpe</h2>
<%
    for (Scarpe s : g.getScarpe()){
%>
<div class="card" style="width: 18rem;">
    <img src="<%=s.getDirImmagine()%>" class="card-img-top">
    <div class="card-body">
        <h5 class="card-title"><%=s.getNome()%>></h5>
        <!--<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>-->
        <form action="visualizza-dettagli-capo" method="post">
            <input type="hidden" value="<%=s.getId()%>" name="idScarpe" id="idScarpe">
            <input type="submit" value="Visualizza dettagli">
        </form>
    </div>
</div>
<%
    }
%>
</body>
</html>
