<%@page import="fr.eni.controlers.LecteurMessage"%>
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
	<div class="alert alert-danger" role="alert">
	<c:if test="${!empty listeCodesErreur}">
		<c:forEach items="${ listeCodesErreur }" var="messageErreur">
				${LecteurMessage.getMessageErreur(messageErreur)} <br>
		</c:forEach>
	</c:if>
	</div>
	<h4>L'enchère gagnante est de ${montantEnchereMax} </h4>
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