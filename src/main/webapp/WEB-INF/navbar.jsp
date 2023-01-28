<%@ page import="weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente" %>
<%@ page import="weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin" %>
<div class="container-fluid text-center">
  <div class="row">
    <div class="col-1">
      <img src="logo.png" class="rounded mx-auto d-block" width="100" height="100">
    </div>
    <div class="col-10">
      <h1 class="mt-4">WEATHERSTYLE</h1>
    </div>
  </div>
</div>
<nav class="navbar navbar-expand navbar-light text-white" data-bs-theme="dark" style="background-color:#337AB8;">
  <div class="container">
    <ul class="navbar-nav ">
      <li class="nav-item">
        <a class="nav-link" aria-current="page" href="index.html">Home</a>
      </li>
      <%
        Utente u = (Utente) session.getAttribute("utente");
        if(u != null){
      %>
        <li class="nav-item">
          <a class="nav-link" href="GuardarobaServlet">Guardaroba</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="loadCapoAbbigliamento.jsp">Inserisci capo</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="logout">Logout</a>
        </li>
        <%
          if(u.isEcologista()){
        %>
        <li class="nav-item">
          <a class="nav-link" href="#">Visualizza Eventi</a>
        </li>
      <%}
        }else{
          Admin admin = (Admin) session.getAttribute("admin");
            if(admin != null){ %>
            <li class="nav-item">
              <a class="nav-link" aria-current="page" href="#">Gestione Richieste</a>
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