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

public class ArticleVenduDAO {
	private static final String SELECT_ARTICLE_CATEG_AND_NOM = "SELECT * From ARTICLES_VENDUS WHERE nomArticle=? and noCategorie=?";
	public ArticleVendu ajouterArticle(ArticleVendu article) {

		Connection cnx;
		try {
			cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement("INSERT INTO ARTICLES_VENDUS(nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, noUtilisateur, noCategorie, nomUtilisateur) VALUES (?,?,?,?,?,?,?,?)");
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

	public ArticleVendu selectArticle(ArticleVendu articleRecherche) {
		List<ArticleVendu> articleTrouves = new ArrayList<>();
		try {
		Connection cnx = ConnectionProvider.getConnection();
		PreparedStatement pstmt = cnx.prepareStatement(SELECT_ARTICLE_CATEG_AND_NOM);
		pstmt.setString(1, articleRecherche.getNomArticle());
		pstmt.setInt(2, articleRecherche.getNoCategorie());
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			ArticleVendu article = new ArticleVendu();
			article.setNomArticle(rs.getString("nomArticle"));
			article.setPrixVente(rs.getInt("prixVente"));
			article.setDateFinEncheres((LocalDate) rs.getObject("dateFinEncheres"));
			article.setNoUtilisateur(rs.getInt("noUtilisateur"));
				
			
			articleTrouves.add(article);
		}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
}
