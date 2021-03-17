package fr.eni.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Enchere;
import fr.eni.dal.EnchereDAO;


public class EnchereManager {

	public Enchere insertEnchere(int noUtilisateur, int noArticle, LocalDate dateEnchere, int montantEnchere) {
		
		Enchere enchere = new Enchere(noUtilisateur, noArticle, dateEnchere, montantEnchere);
		
		EnchereDAO enchereDAO = new EnchereDAO();
		int noEnchere = enchereDAO.insertEnchere(enchere);
		
		Enchere enchereAvecNoEnchere = new Enchere(noEnchere, noUtilisateur, noArticle, dateEnchere, montantEnchere);
		
		return enchereAvecNoEnchere;
	}
	
	public List<Enchere> enchereMax(List<ArticleVendu> afficherTousEtEncheres) {
		Enchere objectEnchereMax = new Enchere();
		List <Enchere> listeEnchereMax = new ArrayList<Enchere>();
		for (ArticleVendu article : afficherTousEtEncheres) {
			System.out.println(article);
			List <Enchere> listEnchere = article.getEnchere();
			System.out.println(article.getEnchere());
			
			int enchereMax = 0;
			
			for (int i = 0; i < listEnchere.size(); i++) {
				if(listEnchere.get(i).getMontantEnchere() > enchereMax) 
				{
					 objectEnchereMax = listEnchere.get(i);
					 enchereMax = listEnchere.get(i).getMontantEnchere();
				}
				System.out.println(objectEnchereMax);
			}	
			listeEnchereMax.add(objectEnchereMax);
			System.out.println(listeEnchereMax);
		}
		return listeEnchereMax;
	}
}
