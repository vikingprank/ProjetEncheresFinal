<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" href="bootstrap.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Modification de votre profil</title>
</head>
<body class="container-fluid col-lg-10">
<header>
		<%@include file="menu.jsp"%>
	</header>
	
	<h1>Modification de votre profil</h1>
	<form action="modificationProfil" method="post">
    <label for="pseudo">Pseudo :</label>
    <input type="text" id="pseudo" name="pseudo" value="${utilisateurConnecte.pseudo}"><br>

    <label for="nom">Nom :</label>
    <input type="text" id="nom" name="nom" value="${utilisateurConnecte.nom}"><br>

    <label for="prenom">Prénom :</label>
    <input type="text" id="prenom" name="prenom" value="${utilisateurConnecte.prenom}"><br>

    <label for="telephone">Téléphone :</label>
    <input type="text" id="telephone" name="telephone" value="${utilisateurConnecte.telephone}"><br>

    <label for="rue">Rue :</label>
    <input type="text" id="rue" name="rue" value="${utilisateurConnecte.rue}"><br>

    <label for="codePostal">Code Postal :</label>
    <input type="text" id="codePostal" name="codePostal" value="${utilisateurConnecte.codePostal}"><br>

    <label for="ville">Ville :</label>
    <input type="text" id="ville" name="ville" value="${utilisateurConnecte.ville}"><br>

    <label for="email">Email :</label>
    <input type="email" id="email" name="email" value="${utilisateurConnecte.email}"><br>

    <label for="motDePasse">Mot de passe :</label>
    <input type="password" id="motDePasse" name="motDePasse" value="${utilisateurConnecte.motDePasse}"><br>

    <label for="motDePasseBis">Confirmation de mot de passe :</label>
    <input type="password" id="motDePasseBis" name="motDePasseBis" value="${utilisateurConnecte.motDePasse}"><br>

    <input type="submit" value="modifier">

    </form>
    <a href="index"><input type="button" value="annuler"></a>
</body>
</html>