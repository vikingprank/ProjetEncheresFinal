<%@page import="fr.eni.controlers.LecteurMessage"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" href="bootstrap.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body class="container-fluid col-lg-12">
	<header>
		<%@include file="menu.jsp"%>
	</header>

	<c:if test="${fn:length(listeCodesErreur) > 0}">
		<c:forEach items="${ listeCodesErreur }" var="messageErreur">
				${LecteurMessage.getMessageErreur(messageErreur)} <br>
		</c:forEach>
	</c:if>

	<c:if test="${ !empty utilisateurConnecte }">

		<div class="alert alert-warning" role="alert">
			<p>
				<strong>Bonjour ${ utilisateurConnecte.pseudo },</strong> vous êtes
				connecté(e)
			</p>
		</div>

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
		</select> <input type="submit" class="btn btn-primary" value="valider" />
	</form>

	<form action="AfficherTousEtEncheres" method="get">
		<input type="submit" class="btn btn-primary"
			value="afficher tous les articles" />
	</form>
	<div class="row">
		<div class="row col-lg-8">
			<c:forEach items="${afficherTousEtEncheres}" var="tousarticle">
				<div class="col-lg-4">
					<div class="card">
						<img class="card-img-top" src="./img/products.jpg"
							alt="Card image">
						<div class="card-body">
							<h4 class="card-title">Nom de l'article :
								${tousarticle.nomArticle}</h4>
							<div>
								<p class="card-text">
									Categorie : ${tousarticle.categorie.libelle}<br>
									Description : ${tousarticle.description}<br> Date fin :
									${tousarticle.dateFinEncheres}<br> vendeur :
									${tousarticle.utilisateur.pseudo}
								<p>
								<table class="table">
									<thead class="thead-light">
										<tr>
											<th>Enchereur</th>
											<th>Montant Enchere</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${tousarticle.enchere}" var="enchere">
											<tr>
												<td>${enchere.noEnchereur}</td>
												<td>${enchere.montantEnchere}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<a href="#!" class="btn btn-primary">Encherir</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

</body>
</html>