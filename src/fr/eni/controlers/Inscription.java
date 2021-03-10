package fr.eni.controlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.Utilisateur;
//import fr.eni.ecole.login.bo.Utilisateur;
//import fr.eni.ecole.login.dal.UtilisateurDAO;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		

		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		String motDePasseBis = request.getParameter("motDePasseBis");
		// int credit = Integer.parseInt(request.getParameter("credit"));
		int noUtilisateur = 0;
		int credit = 0;
		int administrateur = 0;
		// int administrateur =
		// Integer.parseInt(request.getParameter("administrateur"));
		
		// stocker l'utilisateur dans la session
//		session.setAttribute("pseudo", pseudo);
//		session.setAttribute("nom", nom);
//		session.setAttribute("prenom", prenom);
//		session.setAttribute("email", email);
//		session.setAttribute("telephone", telephone);
//		session.setAttribute("rue", rue);
//		session.setAttribute("codePostal", codePostal);
//		session.setAttribute("ville", ville);
//		session.setAttribute("motDePasse", motDePasse);
//		session.setAttribute("motDePasseBis", motDePasseBis);
//		session.setAttribute("noUtilisateur", String.valueOf(noUtilisateur));
		System.out.println(pseudo);
		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		//System.out.println(utilisateurManager);
		Utilisateur utilisateur = new Utilisateur();
		try {
			
			utilisateur = utilisateurManager.ajouter(pseudo, nom, prenom, email, telephone, rue, codePostal,
					ville, motDePasse, motDePasseBis, credit, administrateur);
			request.setAttribute("utilisateur", utilisateur);
		} catch (BusinessException e) {
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
		}
		request.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
		// IL FAUT CREER LA CLASSE UtilisateurManager

		// redirection vers la page de connexion
		// request.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request,
		// response);
	}
}
