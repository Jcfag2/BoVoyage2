<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste de toutes les destinations</title>
</head>
<body>
<table>
	<c:forEach items="${destinations }" var="destination">
	<tr><td>${destination.region }</td>
		<td>${destination.description }</td>
		<td><a href="SupprimerDestinationServlet?id=${destination.id }">Supprimer la destination</a></td>
		<td><a href="ModifierDestinationServlet?id=${destination.id }">Modifier la destination</a></td>
		<td><a href="AfficherDatesServlet?id=${destination.id }">Afficher les dates</a></td>
		<td><a href="AjouterImagesServlet?id=${destination.id }">Ajouter une image</a></td>
	</tr>
	</c:forEach>
</table>
<a href="index.jsp">Retour</a>
</body>
</html>