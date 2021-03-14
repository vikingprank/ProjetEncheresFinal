package fr.eni.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.ArticleVendu;
import fr.eni.dal.ArticleVenduDAO;

public class ArticleVenduManager {
	
	public ArticleVendu ajouterArticle(ArticleVendu article){
		
		ArticleVenduDAO articleVenduDAO = new ArticleVenduDAO();
		articleVenduDAO.ajouterArticle(article);
		
		return article;
		
	}

	
	public List<ArticleVendu> rechercheArticle(ArticleVendu articleRecherche) {
		ArticleVenduDAO articleVenduDAO = new ArticleVenduDAO();
		List<ArticleVendu> listeArticleRecherche = new ArrayList<ArticleVendu>();
		
		if(articleRecherche.getNoCategorie() != 0 && !(articleRecherche.getNomArticle().isEmpty()))
		{
			listeArticleRecherche = articleVenduDAO.selectArticle(articleRecherche, 0);
		}
		if(articleRecherche.getNoCategorie() != 0 && articleRecherche.getNomArticle().isEmpty())
		{
			listeArticleRecherche = articleVenduDAO.selectArticle(articleRecherche, 1);
		}
		if(articleRecherche.getNoCategorie() == 0 && !(articleRecherche.getNomArticle().isEmpty()))
		{
			listeArticleRecherche = articleVenduDAO.selectArticle(articleRecherche, 2);
		}
		return listeArticleRecherche;
	}


	public List<ArticleVendu> afficherTous() {
		ArticleVenduDAO articleVenduDAO = new ArticleVenduDAO();
		List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();

		listeArticles = articleVenduDAO.afficherTous();
		
		return listeArticles;

	}
	public List<ArticleVendu> afficherTousEtEncheres() {
		ArticleVenduDAO articleVenduDAO = new ArticleVenduDAO();
		List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();

		listeArticles = articleVenduDAO.afficherTousEtEncheres();
		
		return listeArticles;

	}
}
