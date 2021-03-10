package fr.eni.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.bo.Utilisateur;
import fr.eni.controlers.BusinessException;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.UtilisateurDAO;

public class UtilisateurManager {

	public Utilisateur modificationUtilisateur(int noUtilisateur, String pseudo, String nom, String prenom,
			String email, String telephone, String rue, String codePostal, String ville, String motDePasse,
			String motDePasseBis, int credit, int administrateur) throws BusinessException {
		BusinessException exception = new BusinessException();
		Utilisateur utilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal,
				ville, motDePasse, credit, administrateur);

		validerPseudo(pseudo, exception);
		validermotDePasse(motDePasse, motDePasseBis, exception);
		if (!exception.hasErreurs()) {
			utilisateur = DAOFactory.getUtilisateurDAO().modificationUtilisateur(utilisateur);
		}

		if (exception.hasErreurs()) {
			throw exception;
		}
		return utilisateur;

	}

	public Utilisateur connexion(String login, String motDePasse) throws BusinessException {
		BusinessException exception = new BusinessException();
		Utilisateur utilisateur = DAOFactory.getUtilisateurDAO().selectByPseudoOrEmail(login);
		validerLogin(login, utilisateur.getPseudo(), utilisateur.getEmail(), exception);
		validermotDePasseConnexion(motDePasse, utilisateur.getMotDePasse(), exception);
		if (!exception.hasErreurs()) {
			return utilisateur;
		}
		if (exception.hasErreurs()) {
			throw exception;
		}

		return utilisateur = null;
	}

	public Utilisateur ajouter(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, String motDePasseBis, int credit, int administrateur)
			throws BusinessException {
		BusinessException exception = new BusinessException();
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
				motDePasse, credit, administrateur);
		validerPseudo(pseudo, exception);
		validermotDePasse(motDePasse, motDePasseBis, exception);
		if (!exception.hasErreurs()) {
			DAOFactory.getUtilisateurDAO().insert(utilisateur);
		}

		if (exception.hasErreurs()) {
			throw exception;
		}
		return utilisateur;
	}

	private void validerPseudo(String pseudo, BusinessException exception) {

		// Regex to check valid username.
		String regex = "^[A-Za-z]\\w{5,29}$";
		// Compile the ReGex
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(pseudo);

		if (!m.matches()) {
			exception.ajouterErreur(CodesErreurBLL.RULE_USERNAME_ERREUR);
		}

	}

	private void validermotDePasse(String motDePasse, String motDePasseBis, BusinessException exception) {
		if (motDePasse.isEmpty()) 
			exception.ajouterErreur(CodesErreurBLL.RULE_PASSWORD_AND_CONFIRMATION_ERREUR);
		if (!(motDePasse.equals(motDePasseBis))) {
			exception.ajouterErreur(CodesErreurBLL.RULE_PASSWORD_AND_CONFIRMATION_ERREUR);
		}
	}

	private void validermotDePasseConnexion(String motDePasse, String motDePasseBis, BusinessException exception) {
		if (!(motDePasse.equals(motDePasseBis))) {
			exception.ajouterErreur(CodesErreurBLL.RULE_AUTHENTIFICATION);
		}
	}

	private void validerLogin(String login, String pseudo, String email, BusinessException exception) {
		if (login.isEmpty()) {
			exception.ajouterErreur(CodesErreurBLL.RULE_AUTHENTIFICATION);
		}
		if (!(login.equals(pseudo) || login.equals(email))) {
			exception.ajouterErreur(CodesErreurBLL.RULE_AUTHENTIFICATION);
		}
	}

	public void suppresionUtilisateur(int noUtilisateur) {
				
		DAOFactory.getUtilisateurDAO().suppresionUtilisateur(noUtilisateur);
	}
}
