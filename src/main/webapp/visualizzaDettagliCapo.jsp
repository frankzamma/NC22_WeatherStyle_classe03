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
    <%@include file="/WEB-INF/links.jsp" %>
 </head>
<body>
<%@include file="/WEB-INF/navbar.jsp"%>
<%
    Maglia m = (Maglia) request.getAttribute("maglia");
    Pantaloni p = (Pantaloni) request.getAttribute("pantaloni");
    Scarpe s = (Scarpe) request.getAttribute("scarpe");
%>
<div class="container">
<%
if (m!=null){
%>
<br>
    <h2 style="color: white"><%=m.getNome()%></h2>
    <div class="row">
        <div class="col-8">
            <ul class="list-group">
                <li class="list-group-item">Categoria: Maglia</li>
                <li class="list-group-item">Materiale: <%=m.getMateriale()%></li>
                <li class="list-group-item">Lunghezza manica: <%=m.getLunghezzaManica()%></li>
                <li class="list-group-item">Colore: <%=m.getColore()%></li>
                <li class="list-group-item">Stagione: <%=m.getStagione()%></li>
            </ul>
        </div>
        <div class="col-4">
            <img src="<%=m.getDirImmagine()%>" class="rounded float-end">
        </div>
    </div>
<%
    }else{
        if (p != null){
%>
    <h2 style="color: white"><%=p.getNome()%></h2>
    <div class="row">
        <div class="col-8">
            <ul class="list-group">
                <li class="list-group-item">Categoria: Pantaloni</li>
                <li class="list-group-item">Materiale: <%=p.getMateriale()%></li>
                <li class="list-group-item">Lunghezza: <%=p.getLunghezza()%></li>
                <li class="list-group-item">Colore: <%=p.getColore()%></li>
                <li class="list-group-item">Stagione: <%=p.getStagione()%></li>
            </ul>
        </div>
        <div class="col-4">
            <img src="<%=p.getDirImmagine()%>" class="rounded float-end">
        </div>
    </div>
<%
        }else{
%>
    <h2 style="color: white"><%=s.getNome()%></h2>
    <div class="row">
        <div class="col-8">
            <ul class="list-group">
                <li class="list-group-item">Categoria: Scarpe</li>
                <li class="list-group-item">Tipo: <%=s.getTipo()%></li>
                <li class="list-group-item">Colore: <%=s.getColore()%></li>
                <li class="list-group-item">Stagione: <%=s.getStagione()%></li>
                <li class="list-group-item">Antiscivolo: <%=s.isAntiscivolo()%></li>
                <li class="list-group-item">Impermeabile: <%=s.isImpermeabile()%></li>
            </ul>
        </div>
        <div class="col-4">
            <img src="<%=s.getDirImmagine()%>" class="rounded float-end">
        </div>
    </div>
<%
    }
%>
<%
    }
%>
</div>
<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>
