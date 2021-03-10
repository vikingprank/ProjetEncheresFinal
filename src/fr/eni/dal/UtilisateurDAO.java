package fr.eni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bll.CodesErreurBLL;
import fr.eni.bo.Utilisateur;
import fr.eni.controlers.BusinessException;

public class UtilisateurDAO {
	
	
	private static final String INSERT = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	private static final String SELECT_BY_PSEUDO_AND_EMAIL = "SELECT * From UTILISATEURS WHERE pseudo=? or email=?";
	
	public Utilisateur insert(Utilisateur utilisateur) throws BusinessException {
		try {
			// 1 - Connection � la BDD
			Connection cnx = ConnectionProvider.getConnection();
			// 2 - Pr�paration de la requete
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
	        pstmt.setString(1, utilisateur.getPseudo());
	        pstmt.setString(2, utilisateur.getNom());
	        pstmt.setString(3, utilisateur.getPrenom());
	        pstmt.setString(4, utilisateur.getEmail());
	        pstmt.setString(5, utilisateur.getTelephone());
	        pstmt.setString(6, utilisateur.getRue());
	        pstmt.setString(7, utilisateur.getCodePostal());
	        pstmt.setString(8, utilisateur.getVille());
	        pstmt.setString(9, utilisateur.getMotDePasse());
	        pstmt.setInt(10, 0);
	        pstmt.setInt(11, 0);
		//	pstmt.setString(4, utilisateur.getConfirmation());
			// 3 - Execution
			pstmt.executeUpdate();
			// 4 - Traitement des données
//			ResultSet rs = pstmt.getGeneratedKeys();
//			if(rs.next())
//			{
//				utilisateur.setNoUtilisateur(rs.getInt(1));
//				return rs.getInt(1);
//			}
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if(e.getMessage().contains("UNIQUE_PSEUDO"))
			{
				businessException.ajouterErreur(CodesErreurBLL.PSEUDO_EXISTANT);
			}
			if(e.getMessage().contains("UNIQUE_EMAIL"))
			{
				businessException.ajouterErreur(CodesErreurBLL.EMAIL_EXISTANT);
			}	
			throw businessException;
		}
		return utilisateur;
	}
	
	public Utilisateur selectByPseudoOrEmail(String login) {
		Utilisateur utilisateur = new Utilisateur();
			try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_PSEUDO_AND_EMAIL);
			pstmt.setString(1, login);
			pstmt.setString(2, login);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				utilisateur.setCodePostal(rs.getString("codePostal"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setMotDePasse(rs.getString("motDePasse"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setNoUtilisateur(rs.getInt("noUtilisateur"));
			}
			cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return utilisateur;
	}

	public List<Utilisateur> selectTous() {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement("SELECT * From Utilisateurs;");
			ResultSet rs = null;
			rs = pstmt.executeQuery();
			Utilisateur utilisateur = null;
			List<Utilisateur> liste = new ArrayList<Utilisateur>();
			while (rs.next()) {
				utilisateur = new Utilisateur(rs.getInt("noUtilisateur"), 
						rs.getString("pseudo"), 
						rs.getString("nom"), 
						rs.getString("prenom"), 
						rs.getString("email"), 
						rs.getString("telephone"), 
						rs.getString("rue"), 
						rs.getString("codePostal"), 
						rs.getString("ville"), 
						rs.getString("motDePasse"), 
						rs.getInt("credit"), 
						rs.getInt("administrateur"));
				liste.add(utilisateur);
			}
			cnx.close();
			return liste;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Utilisateur modificationUtilisateur(Utilisateur utilisateur) {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement("UPDATE Utilisateurs SET "
					+ "pseudo=?,"
					+ "nom=?,"
					+ "prenom=?,"
					+ "email=?,"
					+ "telephone=?,"
					+ "rue=?,"
					+ "codePostal=?,"
					+ "ville=?,"
					+ "motDePasse=? "
					+ "WHERE noUtilisateur=?");
			pstmt.setString(1, utilisateur.getPseudo());
	        pstmt.setString(2, utilisateur.getNom());
	        pstmt.setString(3, utilisateur.getPrenom());
	        pstmt.setString(4, utilisateur.getEmail());
	        pstmt.setString(5, utilisateur.getTelephone());
	        pstmt.setString(6, utilisateur.getRue());
	        pstmt.setString(7, utilisateur.getCodePostal());
	        pstmt.setString(8, utilisateur.getVille());
	        pstmt.setString(9, utilisateur.getMotDePasse());
	        pstmt.setInt(10, utilisateur.getNoUtilisateur());
	        
	        pstmt.executeUpdate();
			cnx.close();
			return utilisateur;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utilisateur;
	}

	public void suppresionUtilisateur(int noUtilisateur) throws BusinessException {
		Connection cnx;
		try {
			cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement("DELETE Utilisateurs WHERE noUtilisateur=?");
			pstmt.setInt(1, noUtilisateur);
			pstmt.executeUpdate();
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if(e.getMessage().contains("encheres_utilisateur_fk"))
			{
				businessException.ajouterErreur(CodesErreurBLL.ARTICLES_EN_VENTE);
			}
			throw businessException;
		}
		
		
	}
}

