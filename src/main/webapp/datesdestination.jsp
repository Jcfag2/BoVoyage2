<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dates pour la destination ${destination.region } :</title>
<script src="js/verification-date.js"></script>
</head>
<body>

<h2>Créer de nouvelles dates de voyage pour la destination ${destination.region } :</h2>

<form id="form_1" action="CreerDateServlet?id=${destination.id }" method="GET" accept-charset="UTF-8">

<input name="id2" id="id2" size="20" value=${destination.id } hidden="">

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
<button type="submit">Créer les dates</button>

</form>

<h2>Dates pour la destination ${destination.region } :</h2>
<table>
<c:forEach items="${dateVoyage }" var="dateVoyage">
		<tr><td>Date n°${dateVoyage.id }</td></tr>
		<tr><td>Date de départ:${dateVoyage.dateDepart }</td></tr>
		<tr><td>Date de retour:${dateVoyage.dateRetour }</td></tr>
		<tr><td>Prix hors taxes:${dateVoyage.prixHT }</td></tr>
		<tr><td>Nombre de places dispo:${dateVoyage.nbPlaces }</td></tr>
		<tr><td><a href="SupprimerDateServlet?id=${dateVoyage.id }&id2=${destination.id }">Supprimer cette date</a></td></tr>
		<tr><td><a href="ModifierDateServlet?id=${dateVoyage.id }&id2=${destination.id }">Modifier cette date</a></td></tr>
		<tr> </tr><tr> </tr><tr> </tr><tr> </tr><tr> </tr><tr> </tr>
		</c:forEach>
</table>
<br>
<a href="index.jsp">Retour à l'index</a><br>
</body>
</html>