<%--
  Created by IntelliJ IDEA.
  User: raffaele aurucci
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visualizza suggerimenti</title>
    <%@include file="../links.jsp"%>
</head>
<body>
<%
    String error = (String) request.getAttribute("errorSalvaSuggerimento");
%>
<%@include file="../navbar.jsp"%>
<br>
<div class="container">
    <div class="alert alert-danger" role="alert">

                <% if (error.equals("Outfit non contiene maglia")) { %>
                Non è stato possibile salvare il suggerimento. <br>
                L'outfit realizzato non contiene una maglia! <br>
                Un outfit è composto da maglia + pantaloni + scarpe + nome outfit.
                <% } %>
                <% if (error.equals("Outfit non contiene pantaloni")) { %>
                Non è stato possibile salvare il suggerimento. <br>
                L'outfit realizzato non contiene dei pantaloni! <br>
                Un outfit è composto da maglia + pantaloni + scarpe + nome outfit.
                <% } %>
                <% if (error.equals("Outfit non contiene scarpe")) { %>
                Non è stato possibile salvare il suggerimento. <br>
                L'outfit realizzato non contiene delle scarpe! <br>
                Un outfit è composto da maglia + pantaloni + scarpe + nome outfit.
                <% } %>
                <% if (error.equals("Outfit lunghezza nome deve essere tra 1 e 30 caratteri")) { %>
                Non è stato possibile salvare il suggerimento. <br>
                Non è stato assegnato un nome valido all'outfit realizzato! <br>
                La lunghezza del nome assegnato deve essere compresa tra 1 e 30 caratteri e può contenere qualsiasi
                carattere.<br>
                Un outfit è composto da maglia + pantaloni + scarpe + nome outfit.
                <% } %>

    </div>
</div>
<%@include file="../footer.jsp"%>
</body>
</html>
