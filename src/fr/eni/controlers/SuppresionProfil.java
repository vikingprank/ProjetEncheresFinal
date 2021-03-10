package fr.eni.controlers;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/suppresionProfil")
public class SuppresionProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/suppresionProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateurRecupNum = new Utilisateur();
		utilisateurRecupNum = (Utilisateur) request.getSession().getAttribute("utilisateurConnecte");
		int noUtilisateur = utilisateurRecupNum.getNoUtilisateur();
		
		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		try {
			utilisateurManager.suppresionUtilisateur(noUtilisateur);
			request.getSession().invalidate();
			request.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		} catch (BusinessException e) {

			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
			request.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		}
		
	}

}
