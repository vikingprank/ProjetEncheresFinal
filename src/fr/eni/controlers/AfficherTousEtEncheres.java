package fr.eni.controlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
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
 * Servlet implementation class AfficherTousEtEncheres
 */
@WebServlet("/AfficherTousEtEncheres")
public class AfficherTousEtEncheres extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherTousEtEncheres() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("on est dans le dopost afficherTousEtEncheres");
		HttpSession session = request.getSession();
		ArticleVenduManager articleVenduManager = new ArticleVenduManager();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		EnchereManager enchereManager = new EnchereManager();
		List<ArticleVendu> afficherTousEtEncheres = new ArrayList<ArticleVendu>();
		afficherTousEtEncheres = articleVenduManager.afficherTousEtEncheres();
		//afficher que les articles "actifs"
		afficherTousEtEncheres = articleVenduManager.articleTermine(afficherTousEtEncheres, 0);
		List<Utilisateur> listeUtilisateur = utilisateurManager.selectTous();
		List<Enchere> listeEnchereMax = enchereManager.enchereMax(afficherTousEtEncheres);
		
		System.out.println(listeEnchereMax);
		session.setAttribute("listeEnchereMax", listeEnchereMax);
		session.setAttribute("listeUtilisateur", listeUtilisateur);
		session.setAttribute("afficherTousEtEncheres", afficherTousEtEncheres);
		request.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
	}

}
