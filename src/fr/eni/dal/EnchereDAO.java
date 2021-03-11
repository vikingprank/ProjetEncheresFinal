package fr.eni.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import fr.eni.bo.Enchere;

public class EnchereDAO {

	public Enchere insertEnchere(Enchere enchere) {

		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(
					"INSERT INTO ENCHERES(noUtilisateur, noArticle, dateEnchere, montantEnchere) VALUES (?,?,?,?);");
			pstmt.setInt(1, enchere.getNoUtilisateur());
			pstmt.setInt(2, enchere.getNoArticle());
			pstmt.setDate(3, Date.valueOf((enchere.getDateEnchere())));
			pstmt.setInt(4, enchere.getMontantEnchere());
			pstmt.executeUpdate();
			cnx.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return enchere;

	}

}
