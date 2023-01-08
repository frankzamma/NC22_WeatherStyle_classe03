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
      <form>
        <div class="row mt-3 mb-3">
          <div class="col-12 col-md-4">
            <label for="meteo"> Scelga il meteo </label>
            <select id="meteo" name="meteo" class="form-select">
              <option value="soleggiato">Soleggiato</option>
              <option value="pioggia">Piovoso</option>
              <option value="nuvoloso">Nuvoloso</option>
            </select>
          </div>
          <div class="col-12 col-md-4 mt-3 mt-md-0" >
            <label for="temperatura-percepita">Scelga la temperatura percepita</label>
            <select name="temperatura-percepita" id="temperatura-percepita" class="form-select">
              <option value="temperaturaPercepita"></option>
              <% for(int i = -15; i<=40; i++){ %>
                    <option value="temperaturaPerceepita"><%=i%></option>
              <% } %>
            </select>
          </div>

          <div class="col-12 col-md-4 mt-3 mt-md-0" >
            <label for="data">Scelga la data della previsione</label>
            <input class="form-control" id="data" type="date" name="data">
          </div>
        </div>

          <label>Scelga l'algoritmo di Intelligenza Artificiale da usare</label>
          <div class="form-check">
            <input type="radio" id="ga-check" name="algo" value="ga" class="form-check-input">
            <label class="form-check-label" for="ga-check">Algoritmi genetici</label>
          </div>
          <div class="form-check">
            <input type="radio"  id="ml-check" name="algo"  value="ml" class="form-check-input">
            <label class="form-check-label" for="ml-check">Machine Learning</label>
          </div>
        <div class="d-grid gap-2 mt-3">
          <button class="btn btn-primary" type="submit">Conferma</button>
        </div>
      </form>
    </div>
  </body>
</html>