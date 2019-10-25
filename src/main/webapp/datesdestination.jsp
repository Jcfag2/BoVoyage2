<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dates pour la destination ${destination.region } :</title>
</head>
<body>

<h2>Créer de nouvelles dates de voyage pour la destination ${destination.region } :</h2>

<form action="CreerDateServlet?id=${destination.id }" method="GET" accept-charset="UTF-8">

<input name="id2" id="id2" size="20" value=${destination.id } hidden="">

Date de départ<input type="date" name="dateDepart" id="dateDepart" size="20">
<br>
Date de retour<input type="date" name="dateRetour" id="dateRetour" size="20">
<br>
Prix HT<input name="prixHT" id="prixHT" size="20" placeholder="prix Hors Taxe">
<br>
Nombre de places Dispo<input name="nbPlaces" id="nbPlaces" size="20" placeholder="Nombre de places Dispo">
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