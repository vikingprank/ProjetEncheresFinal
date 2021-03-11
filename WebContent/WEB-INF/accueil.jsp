<%@page import="fr.eni.controlers.LecteurMessage"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>
	<header>
		<%@include file="menu.jsp"%>
	</header>

	<c:if test="${fn:length(listeCodesErreur) > 0}">
		<c:forEach items="${ listeCodesErreur }" var="messageErreur">
				${LecteurMessage.getMessageErreur(messageErreur)} <br>
		</c:forEach>
	</c:if>

	<c:if test="${ !empty utilisateurConnecte }">
		<p>${ utilisateurConnecte.pseudo }connecté a la session</p>
		<form action="deconnexion" method="get">
			<input type="submit" value="deconnexion" />
		</form>
	</c:if>
	<form action="RechercheArticle" method="POST">
		<label for="nomArticle">Nom de l'article :</label> <input type="text"
			id="nomArticle" name="nomArticle"><br> <select
			id="noCategorie" name="noCategorie">
			<option value="">--Choisisez une catégorie--</option>
			<option value="1">Informatique</option>
			<option value="2">Ameublement</option>
			<option value="3">Vêtements</option>
			<option value="4">Sports et Loisirs</option>
		</select>
		<input type="submit" value="valider" />
	</form>
</body>
</html>