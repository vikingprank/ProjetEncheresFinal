package fr.eni.bll;

import java.time.LocalDate;

import fr.eni.bo.Enchere;
import fr.eni.dal.EnchereDAO;


public class EnchereManager {

	public Enchere insertEnchere(int noUtilisateur, int noArticle, LocalDate dateEnchere, int montantEnchere) {
		
		Enchere enchere = new Enchere(noUtilisateur, noArticle, dateEnchere, montantEnchere);
		
		EnchereDAO enchereDAO = new EnchereDAO();
		enchere = enchereDAO.insertEnchere(enchere);
		
		return enchere;
	}

}
