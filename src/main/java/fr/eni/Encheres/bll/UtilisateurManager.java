package fr.eni.Encheres.bll;


import fr.eni.Encheres.BusinessException;
import fr.eni.Encheres.bo.Utilisateur;
import fr.eni.Encheres.dal.DALException;
import fr.eni.Encheres.dal.DAOFactory;
import fr.eni.Encheres.dal.UtilisateurDAO;

public class UtilisateurManager {
	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager() {
		this.utilisateurDAO=DAOFactory.getUtilisateurDAO();
	}

	
	public Utilisateur selectByPseudo(String pseudo) throws BusinessException {
		Utilisateur user=null;
	
			try {
				DAOFactory.getInstance();
				user = DAOFactory.getUtilisateurDAO().selectByPseudo(pseudo); 
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
			}
		
		return user;
	}


	public void update(Utilisateur user) throws DALException {
		try {
			this.utilisateurDAO.update(user);
		} catch (BusinessException e) {
		}
		
	}


	public Utilisateur selectById(int noUtilisateur) throws BusinessException {
		Utilisateur user=null;
		
		try {
			DAOFactory.getInstance();
			user = DAOFactory.getUtilisateurDAO().selectBynoUtilisateur(noUtilisateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
		}
	
	return user;
	}

}
