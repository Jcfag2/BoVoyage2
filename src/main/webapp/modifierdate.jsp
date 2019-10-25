<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dates pour la destination ${destination.region } :</title>
<script src="js/verification-date.js"></script>
</head>
<body>

<h2>Dates pour la destination ${destination.region } :</h2>
<table>

		<tr><td>Date n°${dateVoyage.id }</td></tr>
		<tr><td>Ancienne date de départ:${dateVoyage.dateDepart }</td></tr>
		<tr><td>Anicenne date de retour:${dateVoyage.dateRetour }</td></tr>
		<tr><td>Ancien prix hors taxes:${dateVoyage.prixHT }</td></tr>
		<tr><td>Ancien nombre de places dispo:${dateVoyage.nbPlaces }</td></tr>

</table>
<h2>Modification de la date:</h2>
<form id="form_1" action="ModifierDateServlet2?id=${dateVoyage.id }&id2=${destination.id }" method="GET" accept-charset="UTF-8">

<input name="id2" id="id2" size="20" value=${destination.id } hidden="">
<input name="id" id="id" size="20" value=${dateVoyage.id } hidden="">
Date de départ<input type="date" name="dateDepart" id="dateDepart" size="20">
<br>
Date de retour<input type="date" name="dateRetour" id="dateRetour" size="20">
<br>
<span id="error_dateRetour" style="visibility: hidden">Veuillez saisir une date Retour supérieure à la date aller</span>
<br>
Prix HT<input type="text" name="prixHT"  min="0" id="prixHT" class="champ_non_vide" size="20" placeholder="prix Hors Taxe">
<br>
<span id="error_prixHT" style="visibility: hidden">Attention votre prix est nul !</span>
<br>
Nombre de places Dispo<input type="number" name="nbPlaces" id="nbPlaces" class="champ_non_vide" size="20" >
<br>
<span id="error_nbPlaces" style="visibility: hidden">Attention votre nombre de place est nul !</span>
<br>
<button type="submit">Modifier les dates</button>

</form>

<br>
<a href="index.jsp">Retour à l'index</a><br>

</body>
</html>