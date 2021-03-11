package fr.eni.bll;

import fr.eni.bo.ArticleVendu;
import fr.eni.dal.ArticleVenduDAO;

public class ArticleVenduManager {
	
	public ArticleVendu ajouterArticle(ArticleVendu article){
		
		ArticleVenduDAO articleVenduDAO = new ArticleVenduDAO();
		articleVenduDAO.ajouterArticle(article);
		
		return article;
		
	}
	
	public ArticleVendu rechercheArticle(ArticleVendu articleRecherche) {
		ArticleVenduDAO articleVenduDAO = new ArticleVenduDAO();
		if(articleRecherche.getNoCategorie() != 0 && articleRecherche.getNomArticle() != null)
		{
			articleRecherche = articleVenduDAO.selectArticle(articleRecherche);
		}
		return articleRecherche;
	}
}
