<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
User: Annalaura Miglino
Date: 25/01/2023
Time: 15:56
To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
    <head>
    <title>Inserimento capo</title>
    <meta charset="utf-8">
    <%@include file="../links.jsp"%>
    </head>
    <body>
    <%
    List<String> errorListService = (List<String>) request.getAttribute("errorListService");
    String errore = (String) request.getAttribute("message");
    %>
        <%@include file="../navbar.jsp"%>
    <br>

    <%
        if (errore!=null){
    %>
    <div class="alert alert-danger" role="alert">
        <%=errore%>
    </div>
    <%
        }
    %>


    <%
        if ((errorListService!=null) && (!errorListService.isEmpty())){
    %>
    <div class="alert alert-danger" role="alert">


             <%
                for (String s : errorListService){
            %>
            <%=s%><br>
            <%
                }
            %>

    </div>
    <%
        }
    %>
        <form method="post" action="inserisci-capo" name="carica-capo-form" id="carica-capo-form" enctype="multipart/form-data">
        <div class="container" style="background-color: white">
            <legend style="background-color: #337AB8">Inserimento di un nuovo capo d'abbigliamento</legend>
                <div class="col align-self-center">
                    <label style="color: black"> Scegli tipo di capo </label>
                    <select class="form-select" id="tipologia" name="tipologia" onchange="changeSelectedParameter()">
                        <option value="" selected >Apri menu di selezione</option>
                        <option value="maglia">Maglia</option>
                        <option value="pantaloni">Pantaloni</option>
                        <option value="scarpe">Scarpe</option>
                    </select>
    <br>
            <div class="mb-3">
                <label for="nomeCapo" class="form-label" style="color: black"> Nome del capo: </label>
                <input type="text"  class="form-control" id="nomeCapo" name="nomeCapo">
            </div>

            <div class="mb-3">
                <label for="foto" style="color: black">Inserire una foto del prodotto</label>
                <input class="form-control" type="file" name="foto" id="foto" accept="image/*">
            </div>

            <div class="mb-3">
                <label style="color: black"> Inserire colore </label>
                <select class="form-select" id="colore" name="colore" disabled>
                    <option selected>Seleziona un colore</option>
                    <option value="chiaro">Chiaro</option>
                    <option value="scuro">Scuro</option>
                    <option value="colorato">Colorato</option>
                </select>
            </div>

            <div class="mb-3">
                <label style="color: black"> Inserire stagione </label>
                <select class="form-select" id="stagione" name="stagione" disabled>
                    <option selected>Seleziona una stagione</option>
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
                <label style="color: black"> Inserire materiale </label>
                <select class="form-select" id="materiale" name="materiale" disabled>
                    <option selected>Seleziona un materiale</option>
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
                <label style="color: black"> Inserire lunghezza manica </label>
                <select class="form-select" id="manica" name="manica" disabled>
                    <option selected>Seleziona una lunghezza manica</option>
                    <option value="lunga">Lunga</option>
                    <option value="corta">Corta</option>
                </select>
            </div>



            <div class="mb-3">
                <label style="color: black"> Inserire lunghezza pantaloni </label>
                <select class="form-select" id="lungPantalone" name="lungPantalone" disabled>
                    <option selected>Seleziona lunghezza pantaloni</option>
                    <option value="lunga">Lungo</option>
                    <option value="corta">Corto</option>
                    <option value="media">Medio</option>
                </select>
            </div>

            <div class="mb-3">
                <label style="color: black"> Inserire tipo di scarpa </label>
                <select class="form-select" id="tipoScarpa" name="tipoScarpa" disabled>
                    <option selected>Seleziona un tipo di scarpa</option>
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
                <label style="color: black"> Indicare se è una scarpa scivolosa </label>
                    <select class="form-select" id="scivoloso" name="scivoloso" disabled>
                        <option selected>Selezionare una delle opzioni</option>
                        <option value="scivsi">Scivolosa</option>
                        <option value="scivno">Non scivolosa</option>
                    </select>
            </div>

            <div class="mb-3">
                <label style="color: black"> Indicare se è una scarpa impermeabile </label>
                <select class="form-select" id="impermeabile" name="impermeabile" disabled>
                    <option selected>Selezionare una delle opzioni</option>
                    <option value="impsi">Impermeabile</option>
                    <option value="impno">Non impermeabile</option>
                </select>
            </div>

            <div class="d-grid gap-2 mt-2">
                <button type="submit" class="btn btn-primary">Carica capo</button>
            </div>
            <br>
            </div>
        </div>
    </form>
    </div>

    <br>

    <script src="script/script-caricamento.js" type="text/javascript"></script>

    <%@include file="../footer.jsp"%>
    </body>
</html>
