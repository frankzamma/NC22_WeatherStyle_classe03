<%--
  Created by IntelliJ IDEA.
  User: frank
  Date: 28/01/2023
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>WeatherStyle</title>
        <%@include file="links.jsp"%>
    </head>
    <body>
        <%@include file="navbar.jsp"%>
        <div class="container text-center mt-2">
            <div class="row">
                <div class="col">
                    <img src="logo.png" class="rounded mx-auto d-block" width="200" height="200">
                </div>
                <div class="row">
                   <h3>Per utilizzare i servizi di WeatherStyle devi effettuare il <a href="login-page">Login</a></h3>
                    <h5>Se non sei ancora registrato puoi farlo da <a href="registrazione-utente">qui</a></h5>
                </div>
            </div>
        </div>

        <%@include file="footer.jsp"%>
    </body>
</html>
