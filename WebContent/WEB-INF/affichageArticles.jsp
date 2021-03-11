<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Affichage des Articles</title>
</head>
<body>

<header>
		<%@include file="menu.jsp"%>
</header>

<h1>Affichage des Articles : </h1>
<table border="1">
<tr>

<th>noArticle</th>
<th>nomArticle</th>
<th>description</th>
<th>dateDebutEncheres</th>
<th>dateFinEncheres</th>
<th>prixInitial</th>
<th>noUtilisateur</th>
<th>noCategorie</th>
<th>nomUtilisateur</th>
<th>action</th>

<c:forEach items="${sessionScope.listeArticles}" var="article">

	<tr>
	<td>${article.noArticle}</td>
	<td>${article.nomArticle}</td>
	<td>${article.description}</td>
	<td>${article.dateDebutEncheres}</td>
	<td>${article.dateFinEncheres}</td>
	<td>${article.prixInitial}</td>
	<td>${article.noUtilisateur}</td>
	<td>${article.noCategorie}</td>
	<td>${article.nomUtilisateur}</td>
	<td><form action="encherir" method="get"><button name="noArticleAEncherir" value="${article.noArticle}">encherir</button>
	</form></td>
	</tr>
	
</c:forEach>

</tr>
</table>
</body>
</html>