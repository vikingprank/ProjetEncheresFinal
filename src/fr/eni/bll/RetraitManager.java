package fr.eni.bll;

import java.util.List;

import fr.eni.bo.Retrait;
import fr.eni.dal.RetraitDAO;

public class RetraitManager {

	public Retrait insertRetrait(int noArticleRetrait, String rue, String codePostal, String ville) {

		Retrait retrait = new Retrait (noArticleRetrait, rue, codePostal, ville);
		
		RetraitDAO retraitDAO = new RetraitDAO();
		retraitDAO.insert(retrait);
		return null;
	}

	public List<Retrait> selectTousRetraits() {
		RetraitDAO retraitDAO = new RetraitDAO(); 
		return retraitDAO.selectTous();
	}

	

}
