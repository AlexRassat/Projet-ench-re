package fr.eni.Encheres.dal;

import fr.eni.Encheres.dal.sqlServer.UtilisateurDAOJdbcImpl;

public abstract class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
}
	