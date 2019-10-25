<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification de la destination selectionnée</title>
<script src="js/verification-destination.js"></script>
</head>
<body>
<form id="form_1" action="ModifierDestinationServlet2" method="GET" accept-charset="UTF-8">
<input name="id" id="id" size="20" value=${destination.id } hidden="">
<label for="region">Région</label><input name="region" id="region" size="20" class="champ_non_vide" value=${destination.region }>
<br>
<span id="error_region" style="visibility: hidden">Veuillez saisir une region</span>
<br>
<label for="description">Description</label><textarea name="description" class="champ_non_vide" id="description" cols="50" rows="5" >${destination.description }</textarea>
<br>
<span id="error_description" style="visibility: hidden">Veuillez saisir une description</span>
<br>
<button type="submit">Modifier la destination</button>
</form>
</body>
</html>