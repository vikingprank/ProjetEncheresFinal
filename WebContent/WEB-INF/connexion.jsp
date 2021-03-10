<%@page import="fr.eni.controlers.LecteurMessage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="accueil">Accueil</a></li>
				<li><a href="connexion">Connexion</a></li>
				<li><a href="inscription">Inscription</a></li>
			</ul>
		</nav>
	</header>
	<h1>Formulaire de Connexion</h1>


	<c:if test="${fn:length(listeCodesErreur) > 0}">
		<p style="color: red;">Erreur, la connexion a echoué :</p>
		<c:forEach items="${ listeCodesErreur }" var="messageErreur">
				${LecteurMessage.getMessageErreur(messageErreur)} <br>
		</c:forEach>
	</c:if>

	<form action="connexion" method="post">
		<label for="pseudo">Pseudo :</label> <input type="text" id="pseudo"
			name="pseudo"><br> <label for="motDePasse">Mot
			de passe :</label> <input type="password" id="motDePasse" name="motDePasse"><br>

		<input type="submit" value="se connecter">
	</form>
	
	
	<form action="deconnexion" method="post">
		<input type="submit" value="deconnexion" />
	</form>
</body>
</html>