package fr.eni.bo;

import java.time.LocalDate;

public class Enchere {
	private int noEnchere;
	private int noUtilisateur;
	private int noArticle;
	private LocalDate dateEnchere;
	private int montantEnchere;

	public Enchere() {
		// TODO Auto-generated constructor stub
	}

	//constructeur sans noEnchere (pour placer l'enchere)
	public Enchere(int noUtilisateur, int noArticle, LocalDate dateEnchere, int montantEnchere) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.noArticle = noArticle;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}
	
	//constructeur avec tout
	public Enchere(int noEnchere, int noUtilisateur, int noArticle, LocalDate dateEnchere, int montantEnchere) {
		super();
		this.noEnchere = noEnchere;
		this.noUtilisateur = noUtilisateur;
		this.noArticle = noArticle;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}
	
	

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", noUtilisateur=" + noUtilisateur + ", noArticle=" + noArticle
				+ ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + "]";
	}

	public int getNoEnchere() {
		return noEnchere;
	}

	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}

}
