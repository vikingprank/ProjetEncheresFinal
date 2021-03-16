package fr.eni.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Categorie;
import fr.eni.bo.Enchere;
import fr.eni.bo.Utilisateur;

public class ArticleVenduDAO {
	private static final String SELECT_ARTICLE_CATEG_AND_NOM = "SELECT * From ARTICLES_VENDUS WHERE nomArticle=? and noCategorie=?";
	private static final String SELECT_ARTICLE__NOM = "SELECT * From ARTICLES_VENDUS WHERE nomArticle=?";
	private static final String SELECT_ARTICLE_CATEG = "SELECT * From ARTICLES_VENDUS WHERE noCategorie=?";
	private static final String SELECT_TOUS_ARTICLE_ET_ENCHERES = "SELECT *\r\n" + "FROM 	ARTICLES_VENDUS a\r\n"
			+ "LEFT JOIN ENCHERES e ON e.noArticle = a.noArticle \r\n"
			+ "INNER JOIN CATEGORIES c ON a.noCategorie = c.noCategorie\r\n"
			+ "LEFT JOIN UTILISATEURS u ON u.noUtilisateur = a.noUtilisateur\r\n "
			+ "ORDER BY e.noArticle, noEnchere";

	public ArticleVendu ajouterArticle(ArticleVendu article) {

		Connection cnx;
		try {
			cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(
					"INSERT INTO ARTICLES_VENDUS(nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, noUtilisateur, noCategorie, nomUtilisateur) VALUES (?,?,?,?,?,?,?,?)");
			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			pstmt.setDate(3, Date.valueOf(article.getDateDebutEncheres()));
			pstmt.setDate(4, Date.valueOf(article.getDateFinEncheres()));
			pstmt.setInt(5, article.getPrixInitial());
			pstmt.setInt(6, article.getNoUtilisateur());
			pstmt.setInt(7, article.getNoCategorie());
			pstmt.setString(8, article.getNomUtilisateur());

			pstmt.executeUpdate();
			cnx.close();
			return article;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return article;
	}

	public List<ArticleVendu> selectArticle(ArticleVendu articleRecherche, int index) {
		List<ArticleVendu> articleTrouves = new ArrayList<>();
		// System.out.println("article=" + articleRecherche + " index=" + index);
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = null;
			if (index == 0) {
				pstmt = cnx.prepareStatement(SELECT_ARTICLE_CATEG_AND_NOM);
				pstmt.setString(1, articleRecherche.getNomArticle());
				pstmt.setInt(2, articleRecherche.getNoCategorie());
			}
			if (index == 2) {
				pstmt = cnx.prepareStatement(SELECT_ARTICLE__NOM);
				pstmt.setString(1, articleRecherche.getNomArticle());
			}
			if (index == 1) {
				pstmt = cnx.prepareStatement(SELECT_ARTICLE_CATEG);
				pstmt.setInt(1, articleRecherche.getNoCategorie());
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ArticleVendu article = new ArticleVendu();
				article.setNomArticle(rs.getString("nomArticle"));
				article.setPrixVente(rs.getInt("prixVente"));
				article.setDateFinEncheres(rs.getDate("dateFinEncheres").toLocalDate());
				article.setNomUtilisateur(rs.getString("nomUtilisateur"));

				articleTrouves.add(article);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return articleTrouves;
	}

	public List<ArticleVendu> afficherTousEtEncheres() {
		List<ArticleVendu> liste = new ArrayList<ArticleVendu>();
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_TOUS_ARTICLE_ET_ENCHERES, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = null;
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setPseudo(rs.getString("pseudo"));
				
				Categorie categorie = new Categorie(rs.getInt("noCategorie"), 
						rs.getString("libelle"));
				
				ArticleVendu articleVendu = new ArticleVendu(rs.getInt("noArticle"), 
						rs.getString("nomArticle"),
						rs.getString("description"), 
						rs.getDate("dateDebutEncheres").toLocalDate(),
						rs.getDate("dateFinEncheres").toLocalDate(), 
						rs.getInt("prixInitial"), 
						rs.getInt("prixVente"),
						categorie, 
						utilisateur 
						);
				
				if (!liste.contains(articleVendu)){
					liste.add(articleVendu);
				} 

			}
			rs.beforeFirst();
			while (rs.next()) {
				Enchere enchere = new Enchere();
				
				enchere = new Enchere(rs.getInt("noEnchere"), 
						rs.getInt("noUtilisateur"), 
						rs.getInt("noArticle"),
						rs.getDate("dateEnchere").toLocalDate(), 
						rs.getInt("montantEnchere"));
				for (ArticleVendu articleVendu : liste) {
					if (articleVendu.getNoArticle() == enchere.getNoArticle()) {
						articleVendu.getEnchere().add(enchere);
					}
				}
			}
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(liste);
		return liste;
	}
}
