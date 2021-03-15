package fr.eni.bo;

import java.time.LocalDate;
import java.util.List;

public class ArticleVendu {


	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int prixInitial;
	private int prixVente;
	private Categorie categorie;
	private Utilisateur utilisateur;
	private List <Enchere> enchere;


	public ArticleVendu() {
		// TODO Auto-generated constructor stub
	}
	
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int prixInitial, int prixVente, Categorie categorie, Utilisateur utilisateur) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.categorie = categorie;
		//this.enchere = enchere;
		this.utilisateur = utilisateur;
	}
	/**
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param prixInitial
	 * @param prixVente
	 * @param categorie
	 * @param utilisateur
	 * @param enchere
	 */
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int prixInitial, int prixVente, Categorie categorie, Utilisateur utilisateur,
			List<Enchere> enchere) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.categorie = categorie;
		this.utilisateur = utilisateur;
		this.enchere = enchere;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public int getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}


	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

//	public Enchere getEnchere() {
//		return enchere;
//	}
//
//	public void setEnchere(Enchere enchere) {
//		this.enchere = enchere;
//	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Enchere> getEnchere() {
		return enchere;
	}

	public void setEnchere(List<Enchere> enchere) {
		this.enchere = enchere;
	}

	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", prixInitial="
				+ prixInitial + ", prixVente=" + prixVente + ", categorie=" + categorie + ", enchere=" + enchere
				+ ", utilisateur=" + utilisateur + "]";
	}




}