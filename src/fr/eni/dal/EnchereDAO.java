package fr.eni.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import fr.eni.bo.Enchere;
import fr.eni.bo.Utilisateur;

public class EnchereDAO {
	public static final String SELECT_BY_NO_ENCHERE = "SELECT MAX(montantEnchere) as montantEnchereMax  FROM ENCHERES WHERE noArticle=?";
	public int insertEnchere(Enchere enchere) {

		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(
					"INSERT INTO ENCHERES(noEnchereur, noArticle, dateEnchere, montantEnchere) VALUES (?,?,?,?);", PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, enchere.getNoEnchereur());
			pstmt.setInt(2, enchere.getNoArticle());
			pstmt.setDate(3, Date.valueOf((enchere.getDateEnchere())));
			pstmt.setInt(4, enchere.getMontantEnchere());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				enchere.setNoEnchere(rs.getInt(1));
				return rs.getInt(1);
			}
			
			cnx.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}
	
	public int selectByNoEnchere(int NoArticle) {
		Enchere enchere = new Enchere();
		int montantEnchereMax = 0;
			try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_NO_ENCHERE);
			pstmt.setInt(1, NoArticle);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				enchere.setMontantEnchere(rs.getInt("montantEnchereMax"));
			montantEnchereMax = enchere.getMontantEnchere();
			cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return montantEnchereMax;
	}

}
