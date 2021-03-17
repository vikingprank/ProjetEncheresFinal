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

<div class="container-fluid">
			<div class="row col-lg-12" style="background-color: lightgray">
				<c:forEach items="${afficherTousEtEncheresTerminees}" var="tousarticle">
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
										</tbody>
									</table>
											
											
											<c:if test="${sessionScope.utilisateurConnecte.pseudo == tousarticle.utilisateur.pseudo}">
											<p>Rentrez le point de retrait :</p>
											
											<form action="enchereTerminee" method="post">
											
											<label for="rue">Rue :</label>
										   	<input type="text" id="rue" name="rue" value="${utilisateurConnecte.rue}"><br>
										
										    <label for="codePostal">Code Postal :</label>
										    <input type="text" id="codePostal" name="codePostal" value="${utilisateurConnecte.codePostal}"><br>
										
										    <label for="ville">Ville :</label>
										    <input type="text" id="ville" name="ville" value="${utilisateurConnecte.ville}"><br>
										    
										    
										    <button name="noArticleRetrait" class="btn btn-primary" value="${tousarticle.noArticle}">Definir comme point de retrait</button>
										    
											</form>
											
											</c:if>
											<c:if test="${sessionScope.utilisateurConnecte.pseudo == utilisateur.pseudo}"><p>Voici le point de retrait</p></c:if>
									</c:forEach>
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