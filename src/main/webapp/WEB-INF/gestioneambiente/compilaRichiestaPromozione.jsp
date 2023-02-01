<%--
  Created by IntelliJ IDEA.
  User: angelopalmieri
  Date: 29/01/23
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Compila richiesta promozione</title>
    <%@include file="../links.jsp"%>
</head>
<body>
<%@include file="../navbar.jsp"%>
<div class="container">

    <h1>Richiedi promozione in ecologista.</h1>
    <h6 class="display-7">Compila i campi di seguito per richiedere una promozione in ecologista.
    <br>Se verrà accettata si sbloccheranno nuove funzionalità come creare eventi volti a salvaguardare l'ambiente.
    <br>Si tenga presente che è possibile richiedere <b>una sola volta</b> la promozione in ecologista,
        se verrà rifiutata non sarà possibile richiederne un'altra, dunque si presti attenzione.</h6>

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
    %>

    <form method="post" action="SalvaRichiestaPromozioneServlet">
        <div class="container">

            <br>
            <h6 class="display-7">Si indichino le tematiche ambientali a cui si è interessati maggiormente.</h6>
            <div class="mb-3">
                <br>
                <div class="form-check form-switch">
                    <input class="form-check-input" type="checkbox" id="tematiche1" name="tematiche" value="Cambiamenti climatici">
                    <label class="form-check-label" for="tematiche1">Cambiamenti climatici</label>
                </div>
                <div class="form-check form-switch">
                    <input class="form-check-input" type="checkbox" id="tematiche2" name="tematiche" value="Inquinamento dell'aria">
                    <label class="form-check-label" for="tematiche2">Inquinamento dell'aria</label>
                </div>
                <div class="form-check form-switch">
                    <input class="form-check-input" type="checkbox" id="tematiche3" name="tematiche" value="Smaltimento rifiuti">
                    <label class="form-check-label" for="tematiche3">Smaltimento rifiuti</label>
                </div>
                <div class="form-check form-switch">
                    <input class="form-check-input" type="checkbox" id="tematiche4" name="tematiche" value="Inquinamento dell'acqua">
                    <label class="form-check-label" for="tematiche4">Inquinamento dell'acqua</label>
                </div>
                <div class="form-check form-switch">
                    <input class="form-check-input" type="checkbox" id="tematiche5" name="tematiche" value="Effetto serra">
                    <label class="form-check-label" for="tematiche5">Effetto serra</label>
                </div>
                <div class="form-check form-switch">
                    <input class="form-check-input" type="checkbox" id="tematiche6" name="tematiche" value="Inquinamento del suolo">
                    <label class="form-check-label" for="tematiche6">Inquinamento del suolo</label>
                </div>
                <div class="form-check form-switch">
                    <input class="form-check-input" type="checkbox" id="tematiche7" name="tematiche" value="Dissesto idrogeologico">
                    <label class="form-check-label" for="tematiche7">Dissesto idrogeologico</label>
                </div>
                <div class="form-check form-switch">
                    <input class="form-check-input" type="checkbox" id="tematiche8" name="tematiche" value="Distruzione foreste">
                    <label class="form-check-label" for="tematiche8">Distruzione foreste</label>
                </div>
                <div class="form-check form-switch">
                    <input class="form-check-input" type="checkbox" id="tematiche9" name="tematiche" value="Pulizia Aree Publiche">
                    <label class="form-check-label" for="tematiche9">Pulizia Aree Publiche</label>
                </div>
                <div class="form-check form-switch">
                    <input class="form-check-input" type="checkbox" id="tematiche10" name="tematiche" value="Tutela del patrimonio naturale">
                    <label class="form-check-label" for="tematiche10">Tutela del patrimonio naturale</label>
                </div>
                <div class="form-check form-switch">
                    <input class="form-check-input" type="checkbox" id="tematiche11" name="tematiche" value="Inquinamento acustico">
                    <label class="form-check-label" for="tematiche11">Inquinamento acustico</label>
                </div>
                <div class="form-check form-switch">
                    <input class="form-check-input" type="checkbox" id="tematiche12" name="tematiche" value="Pulizia di spiagge">
                    <label class="form-check-label" for="tematiche11">Pulizia di spiagge</label>
                </div>
                <div class="form-check form-switch">
                    <input class="form-check-input" type="checkbox" id="tematiche13" name="tematiche" value="Rovina del paesaggio">
                    <label class="form-check-label" for="tematiche11">Rovina del paesaggio</label>
                </div>
                <div class="form-check form-switch">
                    <input class="form-check-input" type="checkbox" id="tematiche13" name="tematiche" value="Specie in via d'estinzione">
                    <label class="form-check-label" for="tematiche11">Specie in via d'estinzione</label>
                </div>
                <br>
                <div class="col-md-6">
                    <label for="esperienze" class="form-label">Si fornisca una breve descrizione delle esperienze
                        che si hanno in ambito ambientale.</label>
                    <input type="text" name="esperienze" class="form-control" id="esperienze">
                </div>

            <br>
            <button type="submit" class="btn btn-primary">Invia richiesta</button>
        </div>
        </div>
    </form>
</div>
    <%@include file="../footer.jsp"%>
</body>
</html>
