package fr.eni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<Retrait> selectTous() {
		try {
			List <Retrait> liste = new ArrayList<>();
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement("SELECT * From RETRAITS;");
			ResultSet rs = null;
			rs = pstmt.executeQuery();
			Retrait retrait = null;
			while (rs.next()) {
				retrait = new Retrait(rs.getInt("noArticle"),
						rs.getString("rue"),
						rs.getString("codePostal"),
						rs.getString("ville")
						);
				liste.add(retrait);
			}
			cnx.close();
			return liste;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
