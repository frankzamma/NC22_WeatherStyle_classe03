<%--
  Created by IntelliJ IDEA.
  User: rafau
  Date: 30/01/2023
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visualizza suggerimenti</title>
    <%@include file="../links.jsp"%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <%
        String error = (String) request.getAttribute("errorSalvaSuggerimento");
    %>
<%@include file="../navbar.jsp"%>
<br>

<div class="container">
    <div class="alert alert-danger" role="alert">
        <ul>
            <li>
                <%=error%>
            </li>
        </ul>
    </div>
</div>

</body>
</html>
