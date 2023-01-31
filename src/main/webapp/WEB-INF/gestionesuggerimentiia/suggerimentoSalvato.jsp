<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visualizza suggerimenti</title>
    <%@include file="../links.jsp"%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%@include file="../navbar.jsp"%>
<br>
<% String suggerimento = (String) request.getAttribute("suggerimentoSalvato");%>
<div class="container">
    <div class="alert alert-success" role="alert">
        <%=suggerimento%><br>
    </div>
</div>

</body>
</html>
