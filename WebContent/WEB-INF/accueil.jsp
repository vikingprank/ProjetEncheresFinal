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
		<p>${ utilisateurConnecte.pseudo }connectéa la session</p>
		<form action="deconnexion" method="get">
			<input type="submit" value="deconnexion" />
		</form>
	</c:if>
	<form action="RechercheArticle" method="POST">
		<label for="nomArticle">Nom de l'article :</label> <input type="text"
			id="nomArticle" name="nomArticle"><br> <select
			id="noCategorie" name="noCategorie">
			<option value="0">--Choisisez une catégorie--</option>
			<option value="1">Informatique</option>
			<option value="2">Ameublement</option>
			<option value="3">Vêtements</option>
			<option value="4">Sports et Loisirs</option>
		</select> <input type="submit" value="valider" />
	</form>
	
	<form action= "AfficherTousEtEncheres" method="get">
	<input type="submit" value="afficher tous les articles" />
	</form>
	<c:if test="${fn:length(afficherTousEtEncheres) > 0}">
		<table border="1">
			<tr>

				<th>nomArticle</th>
				<th>categorie</th>
				<th>description</th>
				<th>dateFinEncheres</th>
				<th>enchere gagnant</th>
				<th>enchereur gagnant</th>
				<th>vendeur</th>

				<c:forEach items="${afficherTousEtEncheres}" var="tousarticle">
					<tr>
						<td>${tousarticle.nomArticle}</td>
						<td>${tousarticle.libelle}</td>
						<td>${tousarticle.description}</td>
						<td>${tousarticle.dateFinEncheres}</td>
						<td>${tousarticle.enchereGagnant}</td>
						<td>${tousarticle.enchereur}</td>
						<td>${tousarticle.vendeur}</td>

					</tr>
				</c:forEach>

			</tr>
		</table>
	</c:if>
	<c:if test="${fn:length(listeArticleRecherche) > 0}">
		<table border="1">
			<tr>

				<th>nomArticle</th>
				<th>dateFinEncheres</th>
				<th>prixInitial</th>
				<th>nomUtilisateur</th>

				<c:forEach items="${listeArticleRecherche}" var="article">
					<tr>
						<td>${article.nomArticle}</td>
						<td>${article.dateFinEncheres}</td>
						<td>${article.prixInitial}</td>
						<td>${article.nomUtilisateur}</td>

					</tr>
				</c:forEach>

			</tr>
		</table>
	</c:if>
</body>
</html>