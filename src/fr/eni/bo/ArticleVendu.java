package fr.eni.bo;

import java.time.LocalDate;

public class ArticleVendu {
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int prixInitial;
	private int prixVente;
	private int noUtilisateur;
	private int noCategorie;
	private String nomUtilisateur;
	private Categorie categorie;
	private Enchere enchere;
	private Utilisateur utilisateur;
	private int enchereGagnant;
	private String libelle;
	private String vendeur;
	private String enchereur;
	
	


	
	/**
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param prixInitial
	 * @param prixVente
	 * @param noUtilisateur
	 * @param noCategorie
	 */
	
	public ArticleVendu() {
		// TODO Auto-generated constructor stub
	}
	//constructeur avec noArticle mais sans nomUtilisateur
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int prixInitial, int prixVente, int noUtilisateur, int noCategorie) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	}
	//constructeur avec tout sauf prix de vente
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int prixInitial, int noUtilisateur, int noCategorie, String nomUtilisateur) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
		this.nomUtilisateur = nomUtilisateur;
	}
	/**
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param prixInitial
	 * @param noUtilisateur
	 * @param noCategorie
	 */
	//constructeur sans noArticle
	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			int prixInitial, int noUtilisateur, int noCategorie, String nomUtilisateur) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
		this.nomUtilisateur = nomUtilisateur;
	}

	public ArticleVendu(String nomArticle, int noCategorie) {
		super();
		this.nomArticle = nomArticle;
		this.noCategorie = noCategorie;
	}
	
	//construction pour affichage de tous les articles
	public ArticleVendu(String nomArticle, String libelle, String description, LocalDate localDate, int enchereGagnant,  String enchereur, String vendeur) {
		super();
		this.enchereGagnant = enchereGagnant;
		this.libelle = libelle;
		this.nomArticle =  nomArticle;
		this.dateFinEncheres = localDate;
		this.vendeur = vendeur;
		this.description = description;
		this.enchereur = enchereur;
	}

	
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	

	public int getNoArticle() {
		return noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public int getPrixInitial() {
		return prixInitial;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	
	
	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", prixInitial="
				+ prixInitial + ", prixVente=" + prixVente + ", noUtilisateur=" + noUtilisateur + ", noCategorie="
				+ noCategorie + ", nomUtilisateur=" + nomUtilisateur + ", categorie=" + categorie + ", enchere="
				+ enchere + ", utilisateur=" + utilisateur + ", enchereGagnant=" + enchereGagnant + ", libelle="
				+ libelle + ", vendeur=" + vendeur + ", enchereur=" + enchereur + "]";
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public int getEnchereGagnant() {
		return enchereGagnant;
	}
	public void setEnchereGagnant(int enchereGagnant) {
		this.enchereGagnant = enchereGagnant;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getVendeur() {
		return vendeur;
	}
	public void setVendeur(String vendeur) {
		this.vendeur = vendeur;
	}
	public String getEnchereur() {
		return enchereur;
	}
	public void setEnchereur(String enchereur) {
		this.enchereur = enchereur;
	}
	
}
