package fr.eni.Encheres.dal.sqlServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.Encheres.BusinessException;
import fr.eni.Encheres.bo.Utilisateur;
import fr.eni.Encheres.dal.ConnectionProvider;
import fr.eni.Encheres.dal.DALException;
import fr.eni.Encheres.dal.UtilisateurDAO;


public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String SELECT_BY_PSEUDO = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur " +
			" FROM utilisateurs where pseudo = ?";
    private static final String UPDATE = "UPDATE utilisateurs SET pseudo=?,nom=?,prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=?,credit=?,administrateur=? where no_utilisateur=?";
    private static final String SELECT_BY_ID = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur " +
			" FROM utilisateurs where no_utilisateur = ?";
	

	@Override
	public Utilisateur selectByPseudo(String pseudo) throws BusinessException {

		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Utilisateur user = null;
		try {
			cnx = ConnectionProvider.getConnection();
			rqt = cnx.prepareStatement(SELECT_BY_PSEUDO);
			rqt.setString(1, pseudo);

			rs = rqt.executeQuery();
			if (rs.next()){

				user = new Utilisateur(rs.getString("pseudo"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("email"),
						rs.getString("telephone"),
						rs.getString("rue"),
						rs.getString("code_postal"),
						rs.getString("ville"),
						rs.getString("mot_de_passe"),
						rs.getInt("credit"),
						rs.getByte("administrateur"));

			}

		} catch (SQLException e) {
			throw new BusinessException();
		} finally {
			try {
				if (rs != null){
					rs.close();
				}
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
			}

		}
		return user;
	}
		
	@Override
	public void update(Utilisateur user) throws BusinessException, DALException {

		Connection cnx = null;
		PreparedStatement rqt = null;

		try {
			cnx = ConnectionProvider.getConnection();
			rqt = cnx.prepareStatement(UPDATE);
			
			rqt.setString(1, user.getPseudo());
			rqt.setString(2, user.getNom());
			rqt.setString(3, user.getPrenom());
			rqt.setString(4, user.getEmail());
			rqt.setString(5, user.getTelephone());
			rqt.setString(6, user.getRue());
			rqt.setString(7, user.getCodePostal());
			rqt.setString(8, user.getVille());
			rqt.setString(9, user.getMotDePasse());
			rqt.setInt(10, user.getCredit());
			rqt.setByte(11, user.isAdministrateur());
			rqt.setInt(12, user.getNoUtilisateur());
			rqt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("erreur");
		} finally {
			try {
				if (rqt != null){
					rqt.close();
				}
				if(cnx !=null){
					cnx.close();
				}
			} catch (SQLException e) {
			}
		}
	}
	
	@Override
	public Utilisateur selectBynoUtilisateur(int id) throws DALException {

		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Utilisateur user = null;
		try {
			cnx = ConnectionProvider.getConnection();
			rqt = cnx.prepareStatement(SELECT_BY_ID);
			rqt.setInt(1, id);

			rs = rqt.executeQuery();
			if (rs.next()){

				user = new Utilisateur(
						rs.getString("pseudo"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("email"),
						rs.getString("telephone"),
						rs.getString("rue"),
						rs.getString("code_postal"),
						rs.getString("ville"),
						rs.getString("mot_de_passe"),
						rs.getInt("credit"),
						rs.getByte("administrateur"));		
			}
			user.setNoUtilisateur(rs.getInt("no_utilisateur"));

		} catch (SQLException e) {

		} finally {
			try {
				if (rs != null){
					rs.close();
				}
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
			}

		}
		return user;
	}
	
	
}
