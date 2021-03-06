<%@page import="fr.eni.controlers.LecteurMessage"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" href="bootstrap.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body class="container-fluid col-lg-10">
	<header>
		<%@include file="menu.jsp"%>
	</header>

	<c:if test="${fn:length(listeCodesErreur) > 0}">
		<c:forEach items="${ listeCodesErreur }" var="messageErreur">
				${LecteurMessage.getMessageErreur(messageErreur)} <br>
		</c:forEach>
	</c:if>

	
<div class="container-fluid">
	<div class="row col-lg-12" style="background-color: darkgrey">
		<div class="row col-lg-8">
			<div class="col-lg-8">
			<div style="padding : 25px">
				<form action="RechercheArticle" method="POST">
					<label for="nomArticle">Nom de l'article :</label> 
					<input type="text" id="nomArticle" name="nomArticle">
					<select class="custom-select" id="noCategorie" name="noCategorie">
						<option value="0">--Choisisez une cat?gorie--</option>
						<option value="1">Informatique</option>
						<option value="2">Ameublement</option>
						<option value="3">V?tements</option>
						<option value="4">Sports et Loisirs</option>
					</select> <input type="submit" class="btn btn-primary" value="valider" />
				</form>
			</div>
</div>
			<div class="col-lg-4" style="padding : 40px">
				<form action="AfficherTousEtEncheres" method="get">
					<input type="submit" class="btn btn-primary"
						value="afficher tous les articles" />
				</form>
			</div>
		</div>
	</div>
	</div>
	<div class="container-fluid">
			<div class="row col-lg-12" style="background-color: lightgray">
				<c:forEach items="${afficherTousEtEncheres}" var="tousarticle">
					<div class="col-lg-3" style="padding-top : 20px">
						<div class="card">
							<img class="card-img-top" src="./img/image-sm.jpg"
								alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Nom de l'article :
									${tousarticle.nomArticle}</h4>
								<div>
									<p class="card-text">
										Categorie : ${tousarticle.categorie.libelle}<br>
										Description : ${tousarticle.description}<br> Date fin :
										${tousarticle.dateFinEncheres}<br> Vendeur :
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
											<c:forEach items="${tousarticle.enchere}" var="enchere" varStatus="index">
											<c:forEach items="${listeUtilisateur}" var="utilisateur">
											<c:forEach items="${listeEnchereMax}" var="enchereMax">
											
											<c:if test="${enchereMax.noArticle == enchere.noArticle && enchereMax.noEnchereur == utilisateur.noUtilisateur && enchereMax.montantEnchere == enchere.montantEnchere}">
												<tr>
													<td>${utilisateur.pseudo}</td>
													<td>${enchereMax.montantEnchere}</td>
												</tr>
										
											</c:if>
											</c:forEach>
											</c:forEach>
											</c:forEach>
										</tbody>
									</table>
									<form action="encherir" method="get"><button name="noArticleAEncherir" class="btn btn-primary" value="${tousarticle.noArticle}">encherir</button></form>

								</div>
							</div>
						</div>
						<br>
					</div>
				</c:forEach>
			</div>
		</div>
</body>
</html>