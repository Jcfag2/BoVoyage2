<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification de la destination selectionnée</title>
</head>
<body>
<form action="ModifierDestinationServlet2" method="GET" accept-charset="UTF-8">
<input name="id" id="id" size="20" value=${destination.id } hidden="">
<label for="region">Région</label><input name="region" id="region" size="20" class="blur" value=${destination.region }>
<br>
<label for="description">Description</label><textarea name="description" class="blur" id="description" cols="50" rows="5" >${destination.description }</textarea>
<br>
<button type="submit">Modifier la destination</button>
</form>
</body>
</html>