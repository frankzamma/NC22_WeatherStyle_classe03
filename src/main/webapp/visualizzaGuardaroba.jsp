<%@ page import="weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.*" %>
<%@ page import="java.util.List" %><%--
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
List<CapoAbbigliamento> all = (List<CapoAbbigliamento>) request.getAttribute("all");
%>


<%
for (CapoAbbigliamento c : all){
%>
<div class="card" style="width: 18rem;">
    <img src="<%=c.getDirImmagine()%>" class="card-img-top">
    <div class="card-body">
        <h5 class="card-title"><%=c.getNome()%></h5>
        <!--<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>-->
        <form action="visualizza-dettagli-capo" method="post">
            <input type="hidden" value="<%=c.getId()%>" name="id" id="id">
            <input type="submit" value="Visualizza dettagli">
        </form>
    </div>
</div>
<%
    }
%>
</body>
</html>
