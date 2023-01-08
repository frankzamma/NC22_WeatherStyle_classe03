<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Driver WeatherStyle</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container text-center">
  <div class="row">
    <div class="col">
      <img src="logo.png" class="rounded mx-auto d-block" width="100" height="100">
    </div>
  </div>
  <div class="row">
    <div class="col">
      <h1>WeatherStyle</h1>
    </div>
  </div>
</div>

<%@include file="navbar.jsp"%>

<br>
<div class="container">
  <form>
    <div class="row">
      <div class="col">
        <label> Inserire meteo </label>
        <select class="form-select">
          <option value="soleggiato">Soleggiato</option>
          <option value="pioggia">Piovoso</option>
          <option value="nuvoloso">Nuvoloso</option>
        </select>
      </div>
      <div class="col">
        <label>Inserire temperatura percepita</label>
        <input type="text" class="form-control" placeholder="Temperatura">
      </div>
    </div>
    <br>

    <label>Scegliere l'algoritmo di Intelligenza Artificiale da usare</label>
    <div class="custom-control custom-radio custom-control-inline">
      <input type="radio" id="customRadioInline1" name="customRadioInline1" class="custom-control-input">
      <label class="custom-control-label" for="customRadioInline1">Algoritmi genetici</label>
    </div>
    <div class="custom-control custom-radio custom-control-inline">
      <input type="radio" id="customRadioInline2" name="customRadioInline1" class="custom-control-input">
      <label class="custom-control-label" for="customRadioInline2">Machine Learning</label>
    </div><br>
    <button class="btn btn-primary" type="submit">Conferma</button>
  </form>
</div>
</body>
</html>