<%@ page import="Model.Guardaroba" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Maglia" %>
<%@ page import="Model.Pantalone" %>
<%@ page import="Model.Scarpa" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Guardaroba guardaroba = (Guardaroba) session.getAttribute("guardaroba");
        List<Maglia> listaMaglie = guardaroba.getMagliaList();
        List<Pantalone> listaPantaloni = guardaroba.getPantaloneList();
        List<Scarpa> listaScarpe = guardaroba.getScarpaList();
    %>
</body>
</html>
