package fr.eni.bo;

import java.time.LocalDate;

public class Enchere {
	private int noEnchere;
	private int noEnchereur;
	private int noArticle;
	private LocalDate dateEnchere;
	private int montantEnchere;

	public Enchere() {
		// TODO Auto-generated constructor stub
	}

	//constructeur sans noEnchere (pour placer l'enchere)
	public Enchere(int noEnchereur, int noArticle, LocalDate dateEnchere, int montantEnchere) {
		super();
		this.noEnchereur = noEnchereur;
		this.noArticle = noArticle;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}
	
	//constructeur avec tout
	public Enchere(int noEnchere, int noEnchereur, int noArticle, LocalDate dateEnchere, int montantEnchere) {
		super();
		this.noEnchere = noEnchere;
		this.noEnchereur = noEnchereur;
		this.noArticle = noArticle;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}
	
	

	

	public int getNoEnchereur() {
		return noEnchereur;
	}

	public void setNoEnchereur(int noEnchereur) {
		this.noEnchereur = noEnchereur;
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

	

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	
	public int getNoEnchere() {
		return noEnchere;
	}

	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}

	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", noEnchereur=" + noEnchereur + ", noArticle=" + noArticle
				+ ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + "]";
	}

}
