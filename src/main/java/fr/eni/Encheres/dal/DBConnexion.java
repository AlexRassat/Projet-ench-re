package fr.eni.Encheres.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnexion {
	public static Connection seConnecter() throws DALException, NamingException {
		Connection cnx = null;
		
		try {
			Context context = new InitialContext();
			//Recherche de la DataSource (context du META-INF)
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
			//Demande une connexion. La methode getConnection met la demande en attente tant qu'il n'y a pas de connexions disponibles dans le pool.
			cnx = dataSource.getConnection();
		} catch (SQLException e) {
			throw new DALException("problème sur la chaine de connexion", e);
		}
		
		return cnx;
	}
	
	public static void seDeconnecter(Connection cnx) throws DALException {
		try {
			if (cnx != null) {
				cnx.close();
			}
		} catch (SQLException e) {
			throw new DALException("problème lors de la fermeture de connexion", e);
		}
	}

	/* Methode permettant de fermer les flux ouverts sur la base de données */
	public static void seDeconnecter(Statement stmt, Connection cnx) throws DALException {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			throw new DALException("problème lors de la fermeture de statement", e);
		}
		seDeconnecter(cnx);
	}

	/* Methode permettant de fermer les flux ouverts sur la base de données */
	public static void seDeconnecter(PreparedStatement pstmt, Connection cnx) throws DALException {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			throw new DALException("problème lors de la fermeture de preparedStatement", e);
		}
		seDeconnecter(cnx);
	}

	/* Methode permettant de fermer les flux ouverts sur la base de données */
	public static void seDeconnecter(CallableStatement callStmt, Connection cnx) throws DALException {
		try {
			if (callStmt != null) {
				callStmt.close();
			}
		} catch (SQLException e) {
			throw new DALException("problème lors de la fermeture de callableStatement", e);
		}
		seDeconnecter(cnx);
	}
}
