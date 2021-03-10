package fr.eni.bll;

import fr.eni.bo.ArticleVendu;
import fr.eni.dal.ArticleVenduDAO;

public class ArticleVenduManager {
	
	public ArticleVendu ajouterArticle(ArticleVendu article){
		
		ArticleVenduDAO articleVenduDAO = new ArticleVenduDAO();
		articleVenduDAO.ajouterArticle(article);
		
		return article;
		
	}
}
