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

			</ul>
		</nav>
	</header>
	
	<c:if test= "${ !empty utilisateurConnecte }" >
		<p> ${ utilisateurConnecte.pseudo } connecté a la session </p>
	</c:if>
	<form action="/deconnexion"method="post">
		<input type="submit" value="deconnexion" />
	</form>
</body>
</html>