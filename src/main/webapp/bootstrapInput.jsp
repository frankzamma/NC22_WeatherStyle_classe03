<%--
  Created by IntelliJ IDEA.
  User: frank
  Date: 25/01/2023
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pagina temporanea per input bootstrap</title>
    <%@include file="WEB-INF/links.jsp"%>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <label for="example" class="form-label">Email address</label>
                <input type="text" class="form-control" id="example" placeholder="name@example.com">
            </div>
            <div class="col-md-6">
                <label for="example1" class="form-label">Email address</label>
                <input type="text" class="form-control" id="example1" placeholder="name@example.com">
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <label for="example2" class="form-label">Email address</label>
                <input type="text" class="form-control" id="example2" placeholder="name@example.com">
            </div>
            <div class="col-md-4">
                <label for="example3" class="form-label">Email address</label>
                <input type="text" class="form-control" id="example3" placeholder="name@example.com">
            </div>
            <div class="col-md-4">
                <label for="example4" class="form-label">Email address</label>
                <input type="text" class="form-control" id="example4" placeholder="name@example.com">
            </div>
            <!-- Per i button, per ottenere il responsive è necessario usare anche il div esterno-->
            <div class="d-grid gap-2 mt-2">
                <button class="btn btn-primary" type="button">Button</button>
                <button class="btn btn-danger" type="button">Button</button>
                <button class="btn btn-secondary" type="button">Button</button>
                <button class="btn btn-warning" type="button">Button</button>
                <button class="btn btn-light" type="button">Button</button>
                <button class="btn btn-dark" type="button">Button</button>
            </div>


        </div>
    </div>


</body>
</html>
