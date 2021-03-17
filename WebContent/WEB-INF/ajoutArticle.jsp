<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" href="bootstrap.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Ajouter un article</title>
</head>

<body class="container-fluid col-lg-10">
<header>
		<%@include file="menu.jsp"%>
</header>

<h1>Formulaire de mis en vente d'un article</h1>
<form action="ajoutArticle" method="POST">

<label for="nomArticle">Nom de l'article :</label>
<input type="text" id="nomArticle" name="nomArticle"><br>

<label for="description">Description :</label>
<input type="text" id="description" name="description"><br>

<label for="dateFinEncheres">Date de Fin des Encheres :</label>
<input type="date" id="dateFinEncheres" name="dateFinEncheres"><br>

<label for="prixInitial">Prix Initial :</label>
<input type="number" id="prixInitial" name="prixInitial"><br>

<select id="noCategorie" name="noCategorie">
    <option value="">--Choisisez une catégorie--</option>
    <option value="1">1-Informatique</option>
    <option value="2">2-Ameublement</option>
    <option value="3">3-Vêtements</option>
    <option value="4">4-Sports et Loisirs</option>
</select>




<input type="submit" value="publier l'annonce">

</form>

<a href="../accueil"><input type="button" value="annuler"></a>

</body>
</html>