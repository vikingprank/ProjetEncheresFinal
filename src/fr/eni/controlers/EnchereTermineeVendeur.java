package fr.eni.controlers;

import java.io.IOException;
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
import fr.eni.bll.RetraitManager;
import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Enchere;
import fr.eni.bo.Retrait;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class EnchereTerminee
 */
@WebServlet("/enchereTermineeVendeur")
public class EnchereTermineeVendeur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnchereTermineeVendeur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("on est dans le dopost EnchereTerminee");
		HttpSession session = request.getSession();
		ArticleVenduManager articleVenduManager = new ArticleVenduManager();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		EnchereManager enchereManager = new EnchereManager();
		List<ArticleVendu> afficherTousEtEncheres = new ArrayList<ArticleVendu>();
		List<ArticleVendu> afficherTousEtEncheresTerminees = new ArrayList<ArticleVendu>();
		List<ArticleVendu> articleTermine = new ArrayList<ArticleVendu>();
		afficherTousEtEncheres = articleVenduManager.afficherTousEtEncheres();
		afficherTousEtEncheresTerminees = articleVenduManager.articleTermine(afficherTousEtEncheres, 1);
		List<Utilisateur> listeUtilisateur = utilisateurManager.selectTous();
		List<Enchere> listeEnchereMax = enchereManager.enchereMax(afficherTousEtEncheres);
		//selection les articles vendu par l'utilisateur connect�
		Utilisateur utilisateurConnecte = (Utilisateur) session.getAttribute("utilisateurConnecte");
		articleTermine = articleVenduManager.articleTermineVendeur(afficherTousEtEncheres, utilisateurConnecte);
		List<Enchere> listeEnchereMaxArticleTermine = enchereManager.enchereMax(articleTermine);
		System.out.println("enchere" + listeEnchereMaxArticleTermine);
		System.out.println(articleTermine);
		
		System.out.println(utilisateurConnecte);
		session.setAttribute("listeEnchereMaxArticleTermine", listeEnchereMaxArticleTermine);
		
		session.setAttribute("listeArticleTermine", articleTermine);
		session.setAttribute("listeUtilisateur", listeUtilisateur);
		
		
		//affichage du lieu de retrait pour le gagant de l'enchère
		
		RetraitManager retraitManager = new RetraitManager();
		List<Retrait> listeRetrait = new ArrayList<>();
		listeRetrait = retraitManager.selectTousRetraits();
		System.out.println(listeRetrait);
		session.setAttribute("listeRetrait", listeRetrait);
		
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/enchereTermineeVendeur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//je recupere le numero d'article associé au clic de l'utilisateur:
		int noArticleRetrait = Integer.parseInt(request.getParameter("noArticleRetrait"));
		System.out.println(noArticleRetrait);
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		
		RetraitManager retraitManager = new RetraitManager();
		Retrait retrait = new Retrait();
		retrait = retraitManager.insertRetrait(noArticleRetrait, rue, codePostal, ville);
		
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/enchereTerminee.jsp").forward(request, response);

	}

}
