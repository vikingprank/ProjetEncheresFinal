package fr.eni.bo;

public class Retrait {
	private int noArticle;
	private String rue;
	private String codePostal;
	private String ville;
	
	public Retrait() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param noArticle
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Retrait(int noArticle, String rue, String codePostal, String ville) {
		super();
		this.noArticle = noArticle;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public String getRue() {
		return rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Retrait [noArticle=" + noArticle + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville
				+ "]";
	}
	
}
