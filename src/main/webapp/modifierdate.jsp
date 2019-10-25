<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dates pour la destination ${destination.region } :</title>
<script src="js/verification-date.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="index.jsp">Bovoyage</a>
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

<h2>Dates pour la destination ${destination.region } :</h2>
<table>

		<tr><td>Date n°${dateVoyage.id }</td></tr>
		<tr><td>Ancienne date de départ  :${dateVoyage.dateDepart }</td></tr>
		<tr><td>Anicenne date de retour : ${dateVoyage.dateRetour }</td></tr>
		<tr><td>Ancien prix hors taxes : ${dateVoyage.prixHT }</td></tr>
		<tr><td>Ancien nombre de places dispo : ${dateVoyage.nbPlaces }</td></tr>

</table>
<br>
<h2>Modification de la date:</h2>
<form id="form_1" action="ModifierDateServlet2?id=${dateVoyage.id }&id2=${destination.id }" method="GET" accept-charset="UTF-8">

<input name="id2" id="id2" size="20" value=${destination.id } hidden="">
<input name="id" id="id" size="20" value=${dateVoyage.id } hidden="">
<div class="form-group">
<label for="dateDepart">Date de Départ</label><input type="date" name="dateDepart" id="dateDepart" class="form-control">
</div>

<div class="form-group">
<label for="dateRetour">Date de Retour</label><input type="date" name="dateRetour" id="dateRetour" class="form-control">
<span id="error_dateRetour" style="visibility: hidden ; color: red">Veuillez saisir une date Retour supérieure à la date aller</span>
<br>
</div>
<div class="form-group">
<label for="prixHT">Prix HT</label><input type="text" name="prixHT"  min="0" id="prixHT" class="champ_non_vide form-control">
<span id="error_prixHT" style="visibility: hidden ; color: red">Attention votre prix est incorrect !</span>
<br>
</div>

<div class="form-group">
<label for="nbPlaces">Nombre de places</label><input type="number" name="nbPlaces" id="nbPlaces" class="champ_non_vide form-control">
<span id="error_nbPlaces" style="visibility: hidden ; color: red">Attention votre nombre de place est nul !</span>
<br>
</div>
<button type="submit">Modifier les dates</button>

</form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<br>
<a href="index.jsp">Retour à l'index</a><br>

</body>


</html>