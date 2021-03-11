<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Placer votre enchère</title>
</head>

<body>

<h1>Formulaire pour placer une enchère</h1>
<form action="encherir" method="POST">
${encherir}<br>
<label for="montantEnchere">Montant de l'Enchere :</label>
<input type="number" id="montantEnchere" name="montantEnchere"><br>
<input type="submit" value="Placer l'enchère">

</form>

<a href="accueil"><input type="button" value="annuler"></a>
</body>
</html>