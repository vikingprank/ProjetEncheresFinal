package fr.eni.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Enchere;
import fr.eni.controlers.BusinessException;
import fr.eni.dal.EnchereDAO;


public class EnchereManager {


	public Enchere insertEnchere(int noUtilisateur, int noArticle, LocalDate dateEnchere, int montantEnchere) throws BusinessException {
		
		Enchere enchere = new Enchere(noUtilisateur, noArticle, dateEnchere, montantEnchere);
		BusinessException exception = new BusinessException();
		EnchereDAO enchereDAO = new EnchereDAO();
		int enchereMax = validerEnchere(enchere, exception);
		int noEnchere = 0;
		if(!exception.hasErreurs())
		{
			noEnchere = enchereDAO.insertEnchere(enchere);
		}
		Enchere enchereAvecNoEnchere = new Enchere(noEnchere, noUtilisateur, noArticle, dateEnchere, montantEnchere);
		
		if (exception.hasErreurs()) {
			enchereAvecNoEnchere.setMontantEnchere(enchereMax);
			throw exception;
		}
		
		return enchereAvecNoEnchere;
		
	}
	
	private int validerEnchere(Enchere enchere, BusinessException exception) {
		EnchereDAO enchereDAO = new EnchereDAO();
		if(enchere.getMontantEnchere() < enchereDAO.selectByNoEnchere(enchere.getNoArticle()))
		{
			exception.ajouterErreur(CodesErreurBLL.RULE_MONTANT_ENCHERE);
		}
		return enchereDAO.selectByNoEnchere(enchere.getNoArticle());
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
			
			}	
			listeEnchereMax.add(objectEnchereMax);
			
		}
		return listeEnchereMax;
	}
}
