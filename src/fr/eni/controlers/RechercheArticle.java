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
import fr.eni.bo.ArticleVendu;

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
		System.out.println(noCategorie + "   " + nomArticle);
		ArticleVenduManager articleVenduManager = new ArticleVenduManager();
		ArticleVendu articleRecherche = new ArticleVendu(nomArticle, noCategorie);
		List<ArticleVendu> listeArticleRecherche = new ArrayList<ArticleVendu>();
		listeArticleRecherche = articleVenduManager.rechercheArticle(articleRecherche);
		session.setAttribute("listeArticleRecherche", listeArticleRecherche);
		request.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		
		
	}

}
