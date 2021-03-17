<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" href="bootstrap.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Placer votre enchère</title>
</head>
<body class="container-fluid">
<div>
	<header>
		<%@include file="menu.jsp"%>
	</header>
	<h1>Formulaire pour placer une enchère</h1>

	<h2>(vous devez être connecté)</h2>

	<h3>Numero de l'article à encherir: ${noArticleAEncherir}</h3>



	<form action="encherir" method="POST">

		<label for="montantEnchere">Montant de l'Enchere :</label> <input
			type="number" id="montantEnchere" name="montantEnchere"><br>
		<input type="submit" value="Placer l'enchère">

	</form>

	<a href="accueil"><input type="button" value="annuler"></a>
</div>
</body>
</html>