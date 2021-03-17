
<nav aria-label="breadcrumb">
	<ul class="breadcrumb">
		<li class="breadcrumb-item active" aria-current="page"><a href="accueil">Accueil</a></li>
		<li class="breadcrumb-item active" aria-current="page"><a href="inscription">Inscription</a></li>
		<li class="breadcrumb-item active" aria-current="page"><a href="connexion">Connexion</a></li>
		<li class="breadcrumb-item active" aria-current="page"><a href="modificationProfil">Modification du Profil</a></li>
		<li class="breadcrumb-item active" aria-current="page"><a href="suppresionProfil">Suppresion du Profil</a></li>
		<li class="breadcrumb-item active" aria-current="page"><a href="ajoutArticle">Ajouter un article</a></li>
		<li class="breadcrumb-item active" aria-current="page"><a href="affichageArticles">Affichage des articles (pas besoin d'être connecté)</a></li>
	</ul>
</nav>

<c:if test="${ !empty utilisateurConnecte }">
		
	<div class="container-fluid">
		<div class="row col-lg-12">
			<div class="alert alert-warning" role="alert">
				<div class="col" >
				<p>
					<strong>Bonjour ${ utilisateurConnecte.pseudo },</strong> vous êtes
					connecté(e)
				</p>
				</div>
				<div class="col" >
				<form action="deconnexion" method="get">
					<input type="submit" class="btn btn-primary" value="deconnexion" />
				</form>
				</div>
			</div>
		</div>
	</div>
	</c:if>
