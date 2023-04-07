package fr.eni.Encheres.dal;

import fr.eni.Encheres.UtilisateurException;
import fr.eni.Encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	/* INSERT's SQL request */
	public void inserer(Utilisateur utilisateur) throws DALException;
}
