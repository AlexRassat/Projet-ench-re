package fr.eni.Encheres.dal;

import fr.eni.Encheres.UtilisateurException;
import fr.eni.Encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	/* INSERT's SQL request for user sign in */
	public void inserer(Utilisateur utilisateur) throws DALException;
	/* SELECT's SQL request for user log in */
	public String select(String pseudo, String mot_de_passe) throws DALException;
}
