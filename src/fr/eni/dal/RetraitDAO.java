package fr.eni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.bo.Retrait;

public class RetraitDAO {
	public void insert(Retrait retrait) {

		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(
					"INSERT INTO RETRAITS(noArticle, rue, codePostal, ville ) VALUES (?,?,?,?);");
			pstmt.setInt(1, retrait.getNoArticle());
			pstmt.setString(2, retrait.getRue());
			pstmt.setString(3, retrait.getCodePostal());
			pstmt.setString(4, retrait.getVille());
			pstmt.executeUpdate();
			
			cnx.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
