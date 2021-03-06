package fr.eni.controlers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.bll.ArticleVenduManager;
import fr.eni.bll.EnchereManager;
import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Enchere;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class RechercheArticle
 */
@WebServlet("/RechercheArticle")
public class RechercheArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/gestionEncheres/accueil.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String nomArticle = null;
		int noCategorie = 0;
		nomArticle = request.getParameter("nomArticle");
		noCategorie = Integer.valueOf(request.getParameter("noCategorie"));
		ArticleVenduManager articleVenduManager = new ArticleVenduManager();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		EnchereManager enchereManager = new EnchereManager();
		ArticleVendu articleRecherche = new ArticleVendu(nomArticle, noCategorie);
		List<ArticleVendu> listeArticleRecherche = articleVenduManager.rechercheArticle(articleRecherche);
		listeArticleRecherche = articleVenduManager.articleTermine(listeArticleRecherche, 0);
		List<Utilisateur> listeUtilisateur = utilisateurManager.selectTous();
		List<Enchere> listeEnchereMax = enchereManager.enchereMax(listeArticleRecherche);
		session.setAttribute("listeEnchereMax", listeEnchereMax);
		session.setAttribute("listeUtilisateur", listeUtilisateur);
		session.setAttribute("afficherTousEtEncheres", listeArticleRecherche);
		request.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		
		
	}

}
