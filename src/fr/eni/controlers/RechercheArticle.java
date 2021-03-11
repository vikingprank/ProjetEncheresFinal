package fr.eni.controlers;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/gestionEncheres/ajoutArticle.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test rechercheArt");
		String nomArticle = null;
		int noCategorie = 0;
		nomArticle = request.getParameter("nomArticle");
		noCategorie = Integer.valueOf(request.getParameter("noCategorie"));
		
		ArticleVendu articleRecherche = new ArticleVendu(nomArticle, noCategorie);
		ArticleVenduManager articleVenduManager = new ArticleVenduManager();
		
	}

}
