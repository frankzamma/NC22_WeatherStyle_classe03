<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Driver WeatherStyle</title>
    <meta charset="utf-8">
    <%@include file="WEB-INF/links.jsp"%>
</head>
<body>
<%
List<String> errorListService = (List<String>) request.getAttribute("errorListService");
String erroreTipo = (String) request.getAttribute("erroreTipo");
%>
    <%@include file="WEB-INF/navbar.jsp"%>

<%
    if (erroreTipo!=null){
%>
    <h2><%=erroreTipo%></h2>
<%
    }
%>



<%
    if ((errorListService!=null) && (!errorListService.isEmpty())){
%>
<h2>Errori riscontrati:</h2><br>
<ul>
    <%
        for (String s : errorListService){
    %>
    <li><%=s%></li>
    <%
        }
    %>
</ul>
<%
    }
%>

    <form method="post" action="inserisci-capo" name="carica-capo-form" id="carica-capo-form">
        <div class="container">

            <div class="mb-3">
                <label> Scegli tipo di capo </label>
                <select class="form-select" id="tipologia" name="tipologia" onchange="changeSelectedParameter()" required>
                    <option value="" selected >Apri menu di selezione</option>
                    <option value="maglia">Maglia</option>
                    <option value="pantaloni">Pantaloni</option>
                    <option value="scarpe">Scarpe</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="nomeCapo"> Nome del capo: </label>
                <input type="text" id="nomeCapo" name="nomeCapo" required>
            </div>

            <div class="mb-3">
                <label for="directoryCapo"> Directory del capo: </label>
                <input type="text" id="directoryCapo" name="directoryCapo" required>
            </div>

            <div class="mb-3">
                <label> Inserire colore </label>
                <select class="form-select" id="colore" name="colore" disabled>
                    <option value="chiaro">Chiaro</option>
                    <option value="scuro">Scuro</option>
                    <option value="colorato">Colorato</option>
                </select>
            </div>

            <div class="mb-3">
                <label> Inserire stagione </label>
                <select class="form-select" id="stagione" name="stagione" disabled>
                    <option value="inverno">Inverno</option>
                    <option value="autunno">Autunno</option>
                    <option value="primavera">Primavera</option>
                    <option value="estate">Estate</option>
                    <option value="primavera_estate">Primavera-Estate</option>
                    <option value="autunno_inverno">Autunno-Inverno</option>
                    <option value="all">All</option>
                </select>
            </div>

            <div class="mb-3">
                <label> Inserire materiale </label>
                <select class="form-select" id="materiale" name="materiale" disabled>
                    <option value="cotone">Cotone</option>
                    <option value="poliestere">Poliestere</option>
                    <option value="cashmere">Cashmere</option>
                    <option value="lino">Lino</option>
                    <option value="seta">Seta</option>
                    <option value="tweed">Tweed</option>
                    <option value="velluto">Velluto</option>
                    <option value="lana">Lana</option>
                    <option value="raso">Raso</option>
                </select>
            </div>



            <div class="mb-3">
                <label> Inserire lunghezza manica </label>
                <select class="form-select" id="manica" name="manica" disabled>
                    <option value="lunga">Lunga</option>
                    <option value="corta">Corta</option>
                </select>
            </div>



            <div class="mb-3">
                <label> Inserire lunghezza pantaloni </label>
                <select class="form-select" id="lungPantalone" name="lungPantalone" disabled>
                    <option value="lunga">Lungo</option>
                    <option value="corta">Corto</option>
                    <option value="media">Medio</option>
                </select>
            </div>

            <div class="mb-3">
                <label> Inserire tipo di scarpa </label>
                <select class="form-select" id="tipoScarpa" name="tipoScarpa" disabled>
                    <option value="stivaletto alla caviglia">Stivaletto alla caviglia</option>
                    <option value="scarpa da ginnastica">Scarpa da ginnastica</option>
                    <option value="scarpa classica">Scarpa classica</option>
                    <option value="scarpe con tacchi">Scarpe con tacchi</option>
                    <option value="scarpe aperte">Scarpe aperte</option>
                    <option value="anfibi">Anfibi</option>
                    <option value="stivali">Stivali</option>
                </select>
            </div>

            <div class="mb-3">
                <p> Indicare se è una scarpa scivolosa </p>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="scivoloso" id="scivsi" value="scivsi" disabled>
                    <label class="form-check-label" for="scivsi"> Si </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="scivoloso" id="scivno" value="scivno" disabled>
                    <label class="form-check-label" for="scivno"> No </label>
                </div>
            </div>

            <div class="mb-3">
                <p> Indicare se è una scarpa impermeabile </p>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="impermeabile" id="impsi" value="impsi" disabled>
                    <label class="form-check-label" for="impsi"> Si </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="impermeabile" id="impno" value="impno" disabled>
                    <label class="form-check-label" for="impno"> No </label>
                </div>
            </div>

            <button type="submit" class="btn btn-primary">Carica capo</button>
        </div>
    </form>

    <br>

    <script>
        function changeSelectedParameter(){
            let x = document.getElementById("tipologia").value;
            if(x === "maglia"){
                document.getElementById("materiale").removeAttribute("disabled");
                document.getElementById("colore").removeAttribute("disabled");
                document.getElementById("manica").removeAttribute("disabled");
                document.getElementById("stagione").removeAttribute("disabled");
                document.getElementById("lungPantalone").setAttribute("disabled","");
                document.getElementById("tipoScarpa").setAttribute("disabled","");
                document.getElementById("scivsi").setAttribute("disabled","");
                document.getElementById("scivno").setAttribute("disabled","");
                document.getElementById("impsi").setAttribute("disabled","");
                document.getElementById("impno").setAttribute("disabled","");
            }else if(x === "pantaloni"){
                document.getElementById("materiale").removeAttribute("disabled");
                document.getElementById("colore").removeAttribute("disabled");
                document.getElementById("manica").setAttribute("disabled","");
                document.getElementById("stagione").removeAttribute("disabled");
                document.getElementById("lungPantalone").removeAttribute("disabled");
                document.getElementById("tipoScarpa").setAttribute("disabled","");
                document.getElementById("scivsi").setAttribute("disabled","");
                document.getElementById("scivno").setAttribute("disabled","");
                document.getElementById("impsi").setAttribute("disabled","");
                document.getElementById("impno").setAttribute("disabled","");
            }else if(x === "scarpe"){
                document.getElementById("materiale").setAttribute("disabled","");
                document.getElementById("colore").removeAttribute("disabled");
                document.getElementById("manica").setAttribute("disabled","");
                document.getElementById("stagione").removeAttribute("disabled");
                document.getElementById("lungPantalone").setAttribute("disabled","");
                document.getElementById("tipoScarpa").removeAttribute("disabled");
                document.getElementById("scivsi").removeAttribute("disabled");
                document.getElementById("scivno").removeAttribute("disabled");
                document.getElementById("impsi").removeAttribute("disabled");
                document.getElementById("impno").removeAttribute("disabled");
            }
            else {
                document.getElementById("materiale").setAttribute("disabled","");
                document.getElementById("colore").setAttribute("disabled","");
                document.getElementById("manica").setAttribute("disabled","");
                document.getElementById("stagione").setAttribute("disabled","");
                document.getElementById("lungPantalone").setAttribute("disabled","");
                document.getElementById("tipoScarpa").setAttribute("disabled","");
                document.getElementById("scivsi").setAttribute("disabled","");
                document.getElementById("scivno").setAttribute("disabled","");
                document.getElementById("impsi").setAttribute("disabled","");
                document.getElementById("impno").setAttribute("disabled","");
            }
        }
    </script>

    <%@include file="WEB-INF/footer.jsp"%>
</body>
</html>
