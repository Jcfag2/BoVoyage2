<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>
<h2>Bienvenue sur BoVoyage</h2>
<form action="DestinationServlet" method="GET" accept-charset="UTF-8">
<button type="submit">Afficher toutes les destinations</button>
</form>

<form action="creerdestination.jsp" method="GET" accept-charset="UTF-8">
<button type="submit">Créer une destination</button>
</form>

</body>
</html>