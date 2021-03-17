<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" href="bootstrap.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Suppresion du Profil</title>
</head>
<body class="container-fluid col-lg-10">
<header>
		<%@include file="menu.jsp"%>
	</header>


	<h1>Suppresion du Profil</h1>
	<h2>êtes vous sur de vouloir supprimer votre profil?</h2>
	
	<form action="suppresionProfil" method="post">
		
		<input type="submit" value="Valider la suppresion du compte"> 
		
		<a href="accueil"><input type="button" value="annuler"></a>

	</form>
</body>
</html>