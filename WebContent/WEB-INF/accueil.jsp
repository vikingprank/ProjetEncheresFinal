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
		<nav>
			<ul>
				<li><a href="accueil">Accueil</a></li>
				<li><a href="inscription">Inscription</a></li>
				<li><a href="connexion">Connexion</a></li>
				<li><a href="modificationProfil">Modification du Profil</a></li>
				<li><a href="suppresionProfil">Suppresion du Profil</a></li>
				<li><a href="gestionEncheres/ajoutArticle">Ajouter un article</a></li>
			</ul>
		</nav>
	</header>
	
	<c:if test="${fn:length(listeCodesErreur) > 0}">
		<c:forEach items="${ listeCodesErreur }" var="messageErreur">
				${LecteurMessage.getMessageErreur(messageErreur)} <br>
		</c:forEach>
	</c:if>
	
	<c:if test= "${ !empty utilisateurConnecte }" >
		<p> ${ utilisateurConnecte.pseudo } connecté a la session </p>
		<form action="deconnexion" method="get">
		<input type="submit" value="deconnexion" />
	</form>
	</c:if>
	
</body>
</html>