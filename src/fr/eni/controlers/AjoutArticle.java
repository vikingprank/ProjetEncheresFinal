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
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class AjoutArticle
 */
@WebServlet("/gestionEncheres/ajoutArticle")
public class AjoutArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getServletContext().getRequestDispatcher("/WEB-INF/gestionEncheres/ajoutArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test doPost ajoutArticle");
		String nomArticle = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		LocalDate dateDebutEncheres = LocalDate.parse(request.getParameter("dateDebutEncheres"));
		LocalDate dateFinEncheres = LocalDate.parse(request.getParameter("dateFinEncheres"));
		int prixInitial = Integer.valueOf(request.getParameter("prixInitial"));
		int noCategorie = Integer.valueOf(request.getParameter("noCategorie"));
		
		Utilisateur utilisateurRecupNum = new Utilisateur();
		utilisateurRecupNum = (Utilisateur) request.getSession().getAttribute("utilisateurConnecte");
		int noUtilisateur = utilisateurRecupNum.getNoUtilisateur();
		String nomUtilisateur = utilisateurRecupNum.getPseudo();
		
		ArticleVendu article = new ArticleVendu(nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, noUtilisateur, noCategorie, nomUtilisateur);
		ArticleVenduManager articleVenduManager = new ArticleVenduManager();
		System.out.println(article);
		articleVenduManager.ajouterArticle(article);
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

}
