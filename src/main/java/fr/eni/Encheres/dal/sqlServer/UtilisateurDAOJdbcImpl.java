package fr.eni.Encheres.dal.sqlServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;
import java.sql.ResultSet;

import fr.eni.Encheres.UtilisateurException;
import fr.eni.Encheres.bll.CodesResultatBLL;
import fr.eni.Encheres.bo.Utilisateur;
import fr.eni.Encheres.dal.DALException;
import fr.eni.Encheres.dal.DBConnexion;
import fr.eni.Encheres.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	// Constants
	private static final String INSERER = "INSERT INTO Utilisateurs (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	private static final String SELECT = "SELECT pseudo,nom,prenom,email,telephone,rue,code_postal,ville,credit,administrateur FROM Utilisateurs WHERE pseudo = ? AND mot_de_passe = ?;";
	
	/* Methode permettant d'inserer un utilisateur en BDD */
	public void inserer(Utilisateur utilisateur) throws DALException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		
		try {
			cnx = DBConnexion.seConnecter();
		} catch (DALException e) {
			System.out.println("Erreur lors de la tentative de connexion à la BDD");
		} catch (NamingException e) {
			System.out.println("Erreur concernant les identitfiant d'inscription pour la base de donnée");
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
	
	public String select(String pseudo, String mot_de_passe) throws DALException, UtilisateurException {
		UtilisateurException UtilisateurException = new UtilisateurException();
		Utilisateur utilisateur = new Utilisateur();
		Connection cnx = null;
		PreparedStatement pstmt = null;
		
		try {
			cnx = DBConnexion.seConnecter();
		} catch (DALException e) {
			System.out.println("Erreur lors de la tentative de connexion à la BDD");
		} catch (NamingException e) {
			System.out.println("Erreur concernant les identitfiant de connexion pour la base de donnée");
		}
		
		try {
			pstmt= cnx.prepareStatement(SELECT);
			pstmt.setString(1, pseudo);
			pstmt.setString(2, mot_de_passe);
			ResultSet rs = pstmt.executeQuery();
			boolean premiereLigne = true;
			
			while(rs.next()) {
				if(premiereLigne)
				{
					utilisateur.setPseudo(rs.getString("pseudo"));
					utilisateur.setNom(rs.getString("nom"));
					utilisateur.setPrenom(rs.getString("prenom"));
					utilisateur.setEmail(rs.getString("email"));
					utilisateur.setTelephone(rs.getString("telephone"));
					utilisateur.setRue(rs.getString("rue"));
					utilisateur.setCodePostal(rs.getString("code_postal"));
					utilisateur.setVille(rs.getString("ville"));
					utilisateur.setCredit(rs.getInt("credit"));
					utilisateur.setAdministrateur(rs.getByte("administrateur"));
					premiereLigne=false;
				}
			}
		} catch (SQLException e) {
			System.out.println("Erreur lors de la tentative de connexion d'un utilisateur");
		} finally {
			DBConnexion.seDeconnecter(pstmt, cnx);
		}
		
		/* SQL request response can be null, in this case, Exception will be throwed */
		validerResultat(utilisateur.getPseudo(), UtilisateurException);
		
		if (UtilisateurException.hasErreurs()) {
			throw new UtilisateurException();
		}
		
		return utilisateur.getPseudo();
	}
	
	private void validerResultat(String pseudo, UtilisateurException UtilisateurException) {
		if(pseudo == null) {
			UtilisateurException.ajouterErreur(CodesResultatBLL.SQL_RESPONSE_NULL);
		}
	}
}
