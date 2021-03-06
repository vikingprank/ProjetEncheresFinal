package fr.eni.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Utilisateur;
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

	public List<ArticleVendu> afficherTousEtEncheres() {
		ArticleVenduDAO articleVenduDAO = new ArticleVenduDAO();
		return articleVenduDAO.afficherTousEtEncheres();
	}
	
	public List<ArticleVendu> articleTermine(List <ArticleVendu> articleEnCours, int i) {
		 List<ArticleVendu> articleTermine = new ArrayList<ArticleVendu>();
		 List<ArticleVendu> articleActifs = new ArrayList<ArticleVendu>();
		
		 for (ArticleVendu articleVendu : articleEnCours) {
			if(articleVendu.getDateFinEncheres().isBefore(LocalDate.now())) {
				articleTermine.add(articleVendu);
		}
			if(articleVendu.getDateFinEncheres().isAfter(LocalDate.now()) || articleVendu.getDateFinEncheres(). isEqual(LocalDate.now())) {
				articleActifs.add(articleVendu);
		}
	}
		if(i == 0)
		return articleActifs; 
		else
		return articleTermine;
	}
	
	public List<ArticleVendu> articleTermineVendeur(List <ArticleVendu> tousLesArticlesVendus, Utilisateur utilisateur){
		 List<ArticleVendu> articleTermine = new ArrayList<ArticleVendu>();
		for (ArticleVendu articleVendu : tousLesArticlesVendus) {
			if(articleVendu.getNoVendeur() == utilisateur.getNoUtilisateur())
				articleTermine.add(articleVendu);
		}
		
		return articleTermine;
		
	}
}

