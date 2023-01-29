<%@ page import="weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia" %>
<%@ page import="weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni" %>
<%@ page import="weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe" %>
<%@ page import="weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.CapoAbbigliamento" %><%--
  Created by IntelliJ IDEA.
  User: migli
  Date: 28/01/2023
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dettagli capo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%
    Maglia m = (Maglia) request.getAttribute("maglia");
    Pantaloni p = (Pantaloni) request.getAttribute("pantaloni");
    Scarpe s = (Scarpe) request.getAttribute("scarpe");
%>

<%
if (m!=null){
%>

<div class="card" style="width: 18rem;">
    <img src="<%=m.getDirImmagine()%>" class="card-img-top">
    <div class="card-body">
        <h5 class="card-title"><%=m.getNome()%></h5>
    </div>
    <ul class="list-group list-group-flush">
        <li class="list-group-item">Categoria: Maglia</li>
        <li class="list-group-item">Materiale: <%=m.getMateriale()%></li>
        <li class="list-group-item">Lunghezza manica: <%=m.getLunghezzaManica()%></li>
        <li class="list-group-item">Colore: <%=m.getColore()%></li>
        <li class="list-group-item">Stagione: <%=m.getStagione()%></li>
    </ul>
</div>

<%
    }else{
        if (p != null){
%>
<div class="card" style="width: 18rem;">
    <img src="<%=p.getDirImmagine()%>" class="card-img-top">
    <div class="card-body">
        <h5 class="card-title"><%=p.getNome()%></h5>
    </div>
    <ul class="list-group list-group-flush">
        <li class="list-group-item">Categoria: Pantaloni</li>
        <li class="list-group-item">Materiale: <%=p.getMateriale()%></li>
        <li class="list-group-item">Lunghezza: <%=p.getLunghezza()%></li>
        <li class="list-group-item">Colore: <%=p.getColore()%></li>
        <li class="list-group-item">Stagione: <%=p.getStagione()%></li>
    </ul>
</div>
<%
        }else{
%>
<div class="card" style="width: 18rem;">
    <img src="<%=s.getDirImmagine()%>" class="card-img-top">
    <div class="card-body">
        <h5 class="card-title"><%=s.getNome()%></h5>
    </div>
    <ul class="list-group list-group-flush">
        <li class="list-group-item">Categoria: Scarpe</li>
        <li class="list-group-item">Tipo: <%=s.getTipo()%></li>
        <li class="list-group-item">Colore: <%=s.getColore()%></li>
        <li class="list-group-item">Stagione: <%=s.getStagione()%></li>
        <li class="list-group-item">Antiscivolo: <%=s.isAntiscivolo()%></li>
        <li class="list-group-item">Impermeabile: <%=s.isImpermeabile()%></li>
    </ul>
</div>

<%
    }
%>
<%
    }
%>




</body>
</html>
