<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Créer une nouvelle Destination</title>
<script src="js/verification-destination.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="index.jsp"><img src="images/logoBoVoyage.png"/></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="DestinationServlet">Destinations</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="creerdestination.jsp">Créer une destination <span class="sr-only">(current)</span></a>
      </li>

    </ul>

  </div>
</nav>


<h2>Entrez les informations concernant la destination à créer</h2>
<form id="form_1" action="CreerDestinationServlet" method="GET" accept-charset="UTF-8">
<div class="form-group">
<label for="region" >Région</label><input name="region" id="region"  class="champ_non_vide form-control" placeholder="Entrez un nom de région">
<span id="error_region" style="visibility: hidden; color: red">Veuillez saisir une region</span>
<br>
</div>
<div class="form-group">
<label for="description">Description</label><textarea name="description" class="champ_non_vide form-control" id="description"  placeholder="Entrez une description" ></textarea>
<span id="error_description" style="visibility: hidden; color: red">Veuillez saisir une description</span>
<br>
</div>
<button type="submit">Créer la destination</button>
</form>
</body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</html>