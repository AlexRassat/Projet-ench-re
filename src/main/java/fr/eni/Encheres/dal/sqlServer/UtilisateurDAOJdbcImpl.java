package fr.eni.Encheres.dal.sqlServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

import fr.eni.Encheres.bo.Utilisateur;
import fr.eni.Encheres.dal.DALException;
import fr.eni.Encheres.dal.DBConnexion;
import fr.eni.Encheres.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	// Constants
	private static final String INSERER = "INSERT INTO Utilisateurs (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?);";

	/* Methode permettant d'inserer un utilisateur en BDD */
	public void inserer(Utilisateur utilisateur) throws DALException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		
		try {
			cnx = DBConnexion.seConnecter();
		} catch (DALException e) {
			System.out.println("Erreur lors de la tentative d'insertion d'un utilisateur");
		} catch (NamingException e) {
			System.out.println("Erreur concernant les identitfiant de connexion pour la base de donnée");
		}
		
		try {
			pstmt= cnx.prepareStatement(INSERER);
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, utilisateur.getCredit());
			pstmt.setByte(11, utilisateur.getAdministrateur());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erreur lors de la tentative d'insertion d'un utilisateur");
		} finally {
			DBConnexion.seDeconnecter(pstmt, cnx);
		}
		
	}
}
