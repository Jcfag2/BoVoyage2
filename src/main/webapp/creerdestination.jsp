<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Créer une nouvelle Destination</title>
<script src="js/verification-destination.js"></script>
</head>
<body>
<h2>Entrez les informations concernant la destination à créer</h2>
<form id="form_1" action="CreerDestinationServlet" method="GET" accept-charset="UTF-8">
<label for="region">Région</label><input name="region" id="region" size="20" class="champ_non_vide" placeholder="Entrez un nom de région">
<br>
<span id="error_region" style="visibility: hidden">Veuillez saisir une region</span>
<br>
<label for="description">Description</label><textarea name="description" class="champ_non_vide" id="description" cols="50" rows="5" placeholder="Entrez une description" ></textarea>
<br>
<span id="error_description" style="visibility: hidden">Veuillez saisir une description</span>
<br>
<button type="submit">Créer la destination</button>
</form>
</body>
</html>