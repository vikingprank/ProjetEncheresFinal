package fr.eni.controlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/modificationProfil")
public class ModificationProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/modificationProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateurRecupNum = new Utilisateur();
		utilisateurRecupNum = (Utilisateur) request.getSession().getAttribute("utilisateurConnecte");
		int noUtilisateur = utilisateurRecupNum.getNoUtilisateur();
		System.out.println(noUtilisateur);
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
		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		try {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur = utilisateurManager.modificationUtilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, motDePasseBis, 0, 0);
			
			request.getSession().setAttribute("utilisateurConnecte", utilisateur);
			System.out.println(utilisateur);
			request.getServletContext().getRequestDispatcher("/WEB-INF/modificationProfil.jsp").forward(request, response);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
