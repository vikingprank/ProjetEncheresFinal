<%@page import="fr.eni.controlers.LecteurMessage"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<link type="text/css" href="bootstrap.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Inscription</title>
</head>
<body class="container-fluid col-lg-10">
	<header>
		<%@include file="menu.jsp"%>
	</header>
	
	<c:if test="${fn:length(listeCodesErreur) > 0}">
			<p style="color:red;">Erreur, l'inscription a echou? :</p>
			<c:forEach items="${ listeCodesErreur }" var="messageErreur">
				${LecteurMessage.getMessageErreur(messageErreur)} <br>
				
				
			</c:forEach>
	</c:if>
	
	<c:if test="${!empty utilisateur}">
	Inscription realis?e avec succes !
	</c:if>
	
	<form action="inscription" method="post">
    <label for="pseudo">Pseudo :</label>
    <input type="text" id="pseudo" name="pseudo"><br>

    <label for="nom">Nom :</label>
    <input type="text" id="nom" name="nom"><br>

    <label for="prenom">Pr?nom :</label>
    <input type="text" id="prenom" name="prenom"><br>

    <label for="telephone">T?l?phone :</label>
    <input type="text" id="telephone" name="telephone"><br>

    <label for="rue">Rue :</label>
    <input type="text" id="rue" name="rue"><br>

    <label for="codePostal">Code Postal :</label>
    <input type="text" id="codePostal" name="codePostal"><br>

    <label for="ville">Ville :</label>
    <input type="text" id="ville" name="ville"><br>

    <label for="email">Email :</label>
    <input type="email" id="email" name="email"><br>

    <label for="motDePasse">Mot de passe :</label>
    <input type="password" id="motDePasse" name="motDePasse"><br>

    <label for="motDePasseBis">Confirmation de mot de passe :</label>
    <input type="password" id="motDePasseBis" name="motDePasseBis"><br>

    <input type="submit" value="s'inscrire">

    </form>
    <a href="accueil"><input type="button" value="annuler"></a>
    
</body>
</html>