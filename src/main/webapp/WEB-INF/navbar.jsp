<%@ page import="weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente" %>
<%@ page import="weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin" %>
<%
  Utente u = (Utente) session.getAttribute("utente");
%>
<div class="container-fluid text-center">
  <div class="row">
    <div class="col-1">
      <img src="logo.png" class="rounded mx-auto d-block" width="100" height="100">
    </div>
    <div class="col-10">
      <h1 class="mt-4">WEATHERSTYLE</h1>
    </div>
    <%if(u != null){%>
      <div class="col-1 dropdown mt-1" >

         <img src="./image/user.png" data-bs-toggle="dropdown" class="dropdown-toggle rounded mx-auto d-block" width="90" height="90">
        <ul class="dropdown-menu">
          <li><a class="dropdown-item" href="AreaPersonaleServlet">Area Personale</a></li>
          <li><a class="dropdown-item" href="visualizza-guardaroba">Il mio guardaroba</a></li>
          <li> <a class="dropdown-item" href="CronologiaSuggerimentiServlet">Cronologia suggerimenti</a> </li>
          <li><a class="dropdown-item" style="background-color: red; color:white" href="logout">Logout</a></li>
        </ul>
      </div>
    <%}%>
  </div>
</div>
<nav class="navbar navbar-expand navbar-light text-white" data-bs-theme="dark" style="background-color:#337AB8;">
  <div class="container">
    <%if(u != null){%>
    <div class="col-6">
      <form class="d-flex mb-0 " role="search">
        <input onkeyup="getCittaNav()" class="form-control me-2" type="search" id="name-citta" name="name-citta"
               placeholder="Roma..." aria-label="Roma..">
        <button class="btn btn-warning" type="submit"><i class="fa fa-search"></i></button>
      </form>
      <div id="suggest">
      </div>
    </div>
    <%}%>
    <ul class="navbar-nav me-auto mb-2 mb-lg-0" >
      <li class="nav-item">
        <a class="nav-link" aria-current="page" href="index.html">Home</a>
      </li>
      <%
        if(u != null){
      %>
        <li class="nav-item">
          <a class="nav-link" href="loadCapoAbbigliamento.jsp">Inserisci capo</a>
        </li>
        <div class="nav-item dropdown" >
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Eventi
          </a>
          <ul class="dropdown-menu " style="background-color:#337AB8">
            <li><a class="dropdown-item text-white" href="VisualizzaEventiServlet">Visualizza Eventi</a></li>
            <%
              if(u.isEcologista()){
            %>
            <li><a class="dropdown-item text-white" href="CreaEventoServlet">Crea Evento</a></li>
            <% } %>
          </ul>
        </div>
        <% }else{
          Admin admin = (Admin) session.getAttribute("admin");
            if(admin != null){ %>
            <li class="nav-item">
              <a class="nav-link" aria-current="page" href="GestioneRichiesteServlet">Gestione Richieste</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" aria-current="page" href="logout">Logout</a>
            </li>
          <%}else{%>
              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="login-page">Login/Registrazione</a>
              </li>
           <%}
        }%>
    </ul>
  </div>
</nav>