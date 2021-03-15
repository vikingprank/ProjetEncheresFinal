package fr.eni.controlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bll.ArticleVenduManager;
import fr.eni.bo.ArticleVendu;

/**
 * Servlet implementation class AjoutArticle
 */
@WebServlet("/affichageArticles")
public class AffichageArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffichageArticles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("on est dans le doGet affichageArticles");
		
		ArticleVenduManager article = new ArticleVenduManager();
		List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();
		listeArticles = article.afficherTousEtEncheres();
		//System.out.println(listeArticles);
		request.getSession().setAttribute("listeArticles", listeArticles);
		//le placement du request.getServlet... est important car placé en début du goGet, la table ne s'affiche pas!
		request.getServletContext().getRequestDispatcher("/WEB-INF/affichageArticles.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("on est dans le doPost affichageArticles");
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/encherir.jsp").forward(request, response);
		
	}

}
