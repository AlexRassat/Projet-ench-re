package fr.eni.Encheres.dal;

import fr.eni.Encheres.BusinessException;
import fr.eni.Encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	public Utilisateur selectByPseudo(String pseudo) throws BusinessException;
	public void update(Utilisateur user) throws BusinessException, DALException;
	public Utilisateur selectBynoUtilisateur(int noUtilisateur)throws BusinessException, DALException;
}
