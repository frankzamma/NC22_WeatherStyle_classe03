<%--
  Created by IntelliJ IDEA.
  User: Annalaura Miglino
  Date: 28/01/2023
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inserimento capo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%
String result = (String) request.getAttribute("message");
%>
<div class="alert alert-success" role="alert">
    <%=result%><br>
    <a href="visualizza-guardaroba">Visualizza tutto il tuo guardaroba!</a>
</div>

</body>
</html>
