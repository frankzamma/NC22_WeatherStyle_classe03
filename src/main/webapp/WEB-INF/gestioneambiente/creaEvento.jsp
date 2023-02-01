<%--
  Created by IntelliJ IDEA.
  User: angelopalmieri
  Date: 29/01/23
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crea evento</title>
    <%@include file="../links.jsp"%>
</head>
<body>
<%@include file="../navbar.jsp"%>
<div class="container">

    <h1>Creazione evento</h1>
    <h6 class="display-7">Compila i campi di seguito per creare un evento volto alla salvaguardia dell'ambiente.</h6>

    <%
        String errore = (String) request.getAttribute("Errore");
        if(errore != null) {
    %>
    <div class="alert alert-danger" role="alert">
        <ul>
            <li>
                <%=errore%>
            </li>
        </ul>
    </div>
    <%
        }
        else {
            String eventoCreatoCorrettamente = (String) request.getAttribute("EventoCreatoCorrettamente");
            if (eventoCreatoCorrettamente != null) {
                %>
                    <div class="alert alert-success" role="alert">
                        <ul>
                            <li>
                                <%=eventoCreatoCorrettamente%>
                            </li>
                        </ul>
                        <h6 class="display-7">Clicca il pulsante in basso per visualizzare tutti gli eventi in programma,
                            oppure continua a creare nuovi eventi!</h6>
                        <a class="btn btn-primary" href="VisualizzaEventiServlet" role="button">Visualizza Eventi</a>
                    </div>
                <%
            }
        }
    %>

    <form method="post" action="SalvaEventoServlet">
        <div class="container">

            <br>
            <div class="mb-3">
                <br>
                <div class="col-md-6">
                    <label for="nomeEvento" class="form-label">Nome evento</label>
                    <input type="text" name="nomeEvento" class="form-control" id="nomeEvento">
                </div>
                <br>
                <div class="col-md-6">
                    <label for="luogo" class="form-label">Luogo</label>
                    <input type="text" name="luogo" class="form-control" id="luogo" required>
                </div>
                <br>
                <div class="col-md-6">
                    <label for="data" class="form-label">Data</label>
                    <input type="date" class="form-control" name="data" id="data" required>
                </div>
                <br>
                <div class="col-md-6">
                    <label for="orario">Scelga l'orario:</label>
                    <input type="time" id="orario" name="orario" required>
                </div>
                <br>
                <div class="col-md-6">
                    <label for="descrizione" class="form-label">Descrizione</label>
                    <input type="text" name="descrizione" class="form-control" id="descrizione">
                </div>
                <br>
                <div class="col-md-6">
                    <label for="altreInformazioni" class="form-label">Altre informazioni</label>
                    <input type="text" name="altreInformazioni" class="form-control" id="altreInformazioni">
                </div>
                <br>
                <button type="submit" class="btn btn-primary">Crea evento</button>
            </div>
        </div>
    </form>
    <%@include file="../footer.jsp"%>
</div>
</body>
</html>