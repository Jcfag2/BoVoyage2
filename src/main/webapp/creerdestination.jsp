<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Créer une nouvelle Destination</title>
</head>
<body>
<h2>Entrez les informations concernant la destination à créer</h2>
<form action="CreerDestinationServlet" method="GET" accept-charset="UTF-8">
<label for="region">Région</label><input name="region" id="region" size="20" class="blur" placeholder="Entrez un nom de région">
<br>
<label for="description">Description</label><textarea name="description" class="blur" id="description" cols="50" rows="5" placeholder="Entrez une description" ></textarea>
<br>
<button type="submit">Créer la destination</button>
</form>
</body>
</html>