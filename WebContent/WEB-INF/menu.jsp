
<nav aria-label="breadcrumb">
	<ul class="breadcrumb">
		<li class="breadcrumb-item active" aria-current="page"><a href="accueil">Accueil</a></li>
		<li class="breadcrumb-item active" aria-current="page"><a href="inscription">Inscription</a></li>
		<li class="breadcrumb-item active" aria-current="page"><a href="connexion">Connexion</a></li>
		<li class="breadcrumb-item active" aria-current="page"><a href="modificationProfil">Modification du Profil</a></li>
		<li class="breadcrumb-item active" aria-current="page"><a href="suppresionProfil">Suppresion du Profil</a></li>
		<li class="breadcrumb-item active" aria-current="page"><a href="ajoutArticle">Ajouter un article</a></li>
	</ul>
</nav>

<c:if test="${ !empty sessionScope.utilisateurConnecte }">
		
	<div class="container-fluid">
		<div class="row col-lg-12">
			<div class="alert alert-success" role="alert">
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
<c:if test="${ empty sessionScope.utilisateurConnecte }">
		
	<div class="container-fluid">
		<div class="row col-lg-12">
			<div class="alert alert-danger" role="alert">
				<div class="col" >
				<p>
					<strong>Bonjour,</strong> vous n'êtes pas
					connecté(e)
				</p>
				</div>
			</div>
		</div>
	</div>
</c:if>