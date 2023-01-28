<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: frank
  Date: 28/01/2023
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Registrazione Utente</title>
        <%@include file="../../links.jsp" %>
    </head>
    <body>
        <%@include file="../../navbar.jsp" %>
        <form method="post" action="registra-utente" onsubmit="return validateForm()">
            <div class="container">
                <h1>Registrazione</h1>
                <%
                    String message = (String) request.getAttribute("message");

                    if(message != null){%>
                        <div class="alert alert-warning" role="alert">
                            <%=message%>
                        </div>
                <%}
                    List<String> errorPar = (List<String>) request.getAttribute("errorPar");

                    if(errorPar != null && !errorPar.isEmpty()){%>
                        <div class="alert alert-danger" role="alert">
                            I seguenti parametri non sono ammissibili:
                            <ul>
                                <%for(String s: errorPar){%>
                                    <li><%=s%></li>
                                <%}%>
                            </ul>
                        </div>
                    <%}%>

                <div class="row">
                    <div class="col-md-6">
                        <label for="nome" class="form-label">Nome</label>
                        <input type="text" name="nome" class="form-control" id="nome" placeholder="Mario" required pattern="^[A-Za-z\s]{3,30}">
                    </div>
                    <div class="col-md-6">
                        <label for="cognome" class="form-label">Cognome</label>
                        <input type="text" name="cognome" class="form-control" id="cognome" placeholder="Rossi" required pattern="^[A-Za-z\s]{3,30}">
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-md-12">
                        <label for="email" class="form-label">Email address</label>
                        <input type="email" name="email" class="form-control" id="email" placeholder="mario.rossi@example.com">
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" name="password" onkeyup="validatePassword('password')"
                               class="form-control" id="password">
                    </div>
                    <div class="row">
                        <div class="col">
                            <div id="password-check" >
                                <ul id="password-check-list">
                                    <li id="min-lenght"><i class="fa fa-circle-o"></i> Lunghezza minima 8 caratteri</li>
                                    <li id="min-symbol"><i class="fa fa-circle-o"></i> Almeno un simbolo tra !_;,:.-+</li>
                                    <li id="min-letter"><i class="fa fa-circle-o"></i> Almeno una lettera minuscola e una maiuscola</li>
                                    <li id="min-number"><i class="fa fa-circle-o"></i> Almeno un numero</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col">
                        <label for="data-nascita" class="form-label">Data Nascita</label>
                        <input type="date" class="form-control" name="data-nascita" id="data-nascita" placeholder="mario.rossi@example.com">
                    </div>
                </div>
                <div class="d-grid gap-2 mt-3">
                     <button type="submit" class="btn btn-primary" >Registrati</button>
                </div>
            </div>
        </form>
        <%@include file="../../footer.jsp" %>
        <script src="./script/script-registrazione.js" type="text/javascript"></script>
    </body>
</html>
