package fr.eni.controlers;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bll.EnchereManager;
import fr.eni.bo.Enchere;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class Encherir
 */
@WebServlet("/encherir")
public class Encherir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Encherir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("on est dans le doGet encherir");
		
		//je recupere le numero d'article associé au clic de l'utilisateur:
		String noArticleAEncherir = request.getParameter("noArticleAEncherir");
		System.out.println(noArticleAEncherir);
		
		//je stocke en session ce numero pour l'afficher dans la JSP et pour l'utiliser pour créer l'objet enchère:
		request.getSession().setAttribute("noArticleAEncherir", noArticleAEncherir);

		request.getServletContext().getRequestDispatcher("/WEB-INF/encherir.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("on est dans le doPost encherir");
		
		//ici sera le code pour rentrer un objet enchère dans la BDD:
		Utilisateur utilisateur = new Utilisateur();
		utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateurConnecte");
		System.out.println(utilisateur);
		
		int noUtilisateur = utilisateur.getNoUtilisateur();
		System.out.println(noUtilisateur);
		
		int noArticle = Integer.valueOf(request.getSession().getAttribute("noArticleAEncherir").toString());
		System.out.println(noArticle);
		
		LocalDate dateEnchere = LocalDate.now();
		System.out.println(dateEnchere);;
		
		int montantEnchere = Integer.valueOf(request.getParameter("montantEnchere"));
		System.out.println(montantEnchere);
		
		EnchereManager enchereManager = new EnchereManager();
		Enchere enchere = new Enchere();
		
		enchere = enchereManager.insertEnchere(noUtilisateur, noArticle, dateEnchere, montantEnchere);
		System.out.println("L'enchère rentrée en base de données : " + enchere);
		
		//mettre en session l'enchère
		request.getSession().setAttribute("enchere", enchere);
		//redirection à la page des articles
		request.getServletContext().getRequestDispatcher("/WEB-INF/succesEnchere.jsp").forward(request, response);
		
		
	}

}
