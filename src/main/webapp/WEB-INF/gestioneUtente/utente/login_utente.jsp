<%--
  Created by IntelliJ IDEA.
  User: frank
  Date: 28/01/2023
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Utente</title>
    <%@include file="../../links.jsp" %>
</head>
    <body>
    <%@include file="../../navbar.jsp" %>
    <div class="container mt-3">
        <%
            String message = (String) request.getAttribute("error-message");

            if(message != null){
        %>      <div class="alert alert-danger" role="alert">
                    <%=message%>
                </div>
        <%}%>
        <form method="post" action="login-utente">
            <div class="col">
                <label for="email" class="form-label">Email address</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="mario.rossi@example.com">
            </div>
            <div class="col">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password">
            </div>
            <div class="d-grid gap-2 mt-2">
                <button type="submit" class="btn btn-primary" type="button">Login</button>
            </div>
        </form>
        <p>Se non sei iscritto puoi registrarti da <a href="registrazione-utente">qui</a></p>
    </div>
    <%@include file="../../footer.jsp" %>
    </body>
</html>
