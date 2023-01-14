<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Driver WeatherStyle</title>
    <%@include file="links.jsp"%>
  </head>
  <body>
    <%@include file="navbar.jsp"%>
    <div class="container">
      <form method="post" action="RichiestaSuggerimentoServlet">
        <div class="row mt-3 mb-3">
          <div class="col-12 col-md-4">
            <label for="meteo"> Meteo </label>
            <select id="meteo" name="meteo" class="form-select" required>
              <option value="soleggiato">Soleggiato</option>
              <option value="pioggia">Piovoso</option>
              <option value="nuvoloso">Nuvoloso</option>
            </select>
          </div>
          <div class="col-12 col-md-4 mt-3 mt-md-0" >
            <label for="temperatura-percepita">Temperatura percepita</label>
            <select name="temperatura-percepita" id="temperatura-percepita" class="form-select" required>
              <option value="temperaturaPercepita"></option>
              <% for(int i = -15; i<=40; i++){ %>
                    <option value=<%=i%>><%=i%></option>
              <% } %>
            </select>
          </div>

          <div class="col-12 col-md-4 mt-3 mt-md-0" >
            <label for="data">Data della previsione</label>
            <input class="form-control" id="data" type="date" name="data" required>
          </div>
        </div>

          <label>Algoritmo di Intelligenza Artificiale da usare</label>
          <div class="form-check">
            <input type="radio" id="ga-check" name="algo" value="ga" class="form-check-input" checked>
            <label class="form-check-label" for="ga-check">Algoritmi genetici</label>
          </div>
          <div class="form-check">
            <input type="radio"  id="ml-check" name="algo"  value="ml" class="form-check-input">
            <label class="form-check-label" for="ml-check">Machine Learning</label>
          </div>
        <div class="d-grid gap-2 mt-3">
          <form method="get" action="RichiestaSuggerimentoServlet">
            <button class="btn btn-primary" type="submit">Conferma</button>
          </form>
        </div>
      </form>
    </div>
  <%@include file="footer.jsp"%>
  </body>
</html>