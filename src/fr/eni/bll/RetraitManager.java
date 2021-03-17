package fr.eni.bll;

import fr.eni.bo.Retrait;
import fr.eni.dal.RetraitDAO;

public class RetraitManager {

	public Retrait insertRetrait(int noArticleRetrait, String rue, String codePostal, String ville) {

		Retrait retrait = new Retrait (noArticleRetrait, rue, codePostal, ville);
		
		RetraitDAO retraitDAO = new RetraitDAO();
		retraitDAO.insert(retrait);
		return null;
	}

}
