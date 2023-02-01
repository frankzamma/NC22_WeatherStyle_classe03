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
    <%@include file="/WEB-INF/links.jsp"%>
</head>
<body>
<%@include file="/WEB-INF/navbar.jsp"%>
<%
String result = (String) request.getAttribute("message");
%>
<p id="message"><%=result%></p>
<div class="alert alert-success" role="alert">

    <a href="visualizza-guardaroba">Visualizza tutto il tuo guardaroba!</a>
</div>
<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>
