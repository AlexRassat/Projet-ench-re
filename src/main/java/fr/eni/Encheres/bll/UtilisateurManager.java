package fr.eni.Encheres.bll;

import fr.eni.Encheres.dal.DALException;
import fr.eni.Encheres.dal.DAOFactory;
import fr.eni.Encheres.dal.UtilisateurDAO;
import fr.eni.Encheres.UtilisateurException;
import fr.eni.Encheres.bo.Utilisateur;

public class UtilisateurManager {
	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public void ajouterUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String code_postal, String ville, String mot_de_passe, int credit, byte administrateur) throws UtilisateurException, DALException {
		UtilisateurException UtilisateurException = new UtilisateurException();
		this.validerPseudo(pseudo, UtilisateurException);
		this.validerNom(nom, UtilisateurException);
		this.validerPrenom(prenom, UtilisateurException);
		this.validerEmail(email, UtilisateurException);
		this.validerTelephone(telephone, UtilisateurException);
		this.validerRue(rue, UtilisateurException);
		this.validerCodePostal(code_postal, UtilisateurException);
		this.validerVille(ville, UtilisateurException);
		this.validerMotDePasse(mot_de_passe, UtilisateurException);
				
		if(!UtilisateurException.hasErreurs()) {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setPseudo(pseudo);
			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setEmail(email);
			utilisateur.setTelephone(telephone);
			utilisateur.setRue(rue);
			utilisateur.setCodePostal(code_postal);
			utilisateur.setVille(ville);
			utilisateur.setMotDePasse(mot_de_passe);
			utilisateur.setCredit(credit);
			utilisateur.setAdministrateur(administrateur);
			this.utilisateurDAO.inserer(utilisateur);
		} else {
			throw UtilisateurException;
		}
	}
	
	private void validerPseudo(String pseudo, UtilisateurException UtilisateurException) {
		if(pseudo == null || pseudo.trim().length() > 30) {
			UtilisateurException.ajouterErreur(CodesResultatBLL.ERREUR_VALEUR);
		}
	}
	private void validerNom(String nom, UtilisateurException UtilisateurException) {
		if(nom == null || nom.trim().length() > 30) {
			UtilisateurException.ajouterErreur(CodesResultatBLL.ERREUR_VALEUR);
		}
	}
	private void validerPrenom(String prenom, UtilisateurException UtilisateurException) {
		if(prenom == null || prenom.trim().length() > 30) {
			UtilisateurException.ajouterErreur(CodesResultatBLL.ERREUR_VALEUR);
		}
	}
	private void validerEmail(String email, UtilisateurException UtilisateurException) {
		if(email == null || email.trim().length() > 20) {
			UtilisateurException.ajouterErreur(CodesResultatBLL.ERREUR_VALEUR);
		}
	}
	private void validerTelephone(String telephone, UtilisateurException UtilisateurException) {
		if(telephone == null || telephone.trim().length() > 15) {
			UtilisateurException.ajouterErreur(CodesResultatBLL.ERREUR_VALEUR);
		}
	}
	private void validerRue(String rue, UtilisateurException UtilisateurException) {
		if(rue == null || rue.trim().length() > 30) {
			UtilisateurException.ajouterErreur(CodesResultatBLL.ERREUR_VALEUR);
		}
	}
	private void validerCodePostal(String code_postal, UtilisateurException UtilisateurException) {
		if(code_postal == null || code_postal.trim().length() > 10) {
			UtilisateurException.ajouterErreur(CodesResultatBLL.ERREUR_VALEUR);
		}
	}
	private void validerVille(String ville, UtilisateurException UtilisateurException) {
		if(ville == null || ville.trim().length() > 30) {
			UtilisateurException.ajouterErreur(CodesResultatBLL.ERREUR_VALEUR);
		}
	}
	private void validerMotDePasse(String mot_de_passe, UtilisateurException UtilisateurException) {
		if(mot_de_passe == null || mot_de_passe.trim().length() > 30) {
			UtilisateurException.ajouterErreur(CodesResultatBLL.ERREUR_VALEUR);
		}
	}
}
