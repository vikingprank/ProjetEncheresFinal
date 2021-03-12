<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vous avez placé une enchère!</title>
</head>
<body>
<h1>Votre enchère est placée!</h1>
<br>
${sessionScope.enchere}
<br>
<a href="accueil"><input type="button" value="Retourner à l'accueil"></a>

</body>
</html>