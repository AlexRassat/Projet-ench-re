package fr.eni.Encheres.dal;

import fr.eni.Encheres.dal.sqlServer.UtilisateurDAOJdbcImpl;

public class DAOFactory {
	
	private static DAOFactory instance;
	private static UtilisateurDAO utilisateurDAO;
	
	public static UtilisateurDAO getUtilisateurDAO() {
		if (utilisateurDAO == null) {
			utilisateurDAO = new UtilisateurDAOJdbcImpl();
		}
		return utilisateurDAO;
	}
	
	public static DAOFactory getInstance() {
		if (instance == null) {
			instance = new DAOFactory();
		}
		
		return instance;
	}
}