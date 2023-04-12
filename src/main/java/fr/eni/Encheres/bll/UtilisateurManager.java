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
	
	public void ajouterUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String code_postal, String ville, String mot_de_passe, String confirmation, int credit, byte administrateur) throws UtilisateurException, DALException {
		UtilisateurException UtilisateurException = new UtilisateurException();
		this.validerPseudo(pseudo, UtilisateurException);
		this.validerNom(nom, UtilisateurException);
		this.validerPrenom(prenom, UtilisateurException);
		this.validerEmail(email, UtilisateurException);
		this.validerTelephone(telephone, UtilisateurException);
		this.validerRue(rue, UtilisateurException);
		this.validerCodePostal(code_postal, UtilisateurException);
		this.validerVille(ville, UtilisateurException);
		this.validerMotDePasseInscription(mot_de_passe, confirmation, UtilisateurException);
				
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
			System.out.println("Erreur BLL lors de l'inscription d'un utilisateur");
			throw UtilisateurException;
		}
	}
	
	public String connecterUtilisateur(String pseudo, String mot_de_passe) throws UtilisateurException, DALException {
		UtilisateurException UtilisateurException = new UtilisateurException();
		this.validerPseudo(pseudo, UtilisateurException);
		this.validerMotDePasseConnexion(mot_de_passe, UtilisateurException);
				
		if(!UtilisateurException.hasErreurs()) {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setPseudo(pseudo);
			utilisateur.setMotDePasse(mot_de_passe);
			return this.utilisateurDAO.select(pseudo, mot_de_passe);
		} else {
			System.out.println("Erreur BLL lors de la connexion d'un utilisateur");
			throw UtilisateurException;
		}
	}
	
	private void validerPseudo(String pseudo, UtilisateurException UtilisateurException) {
		if(pseudo.isBlank() || pseudo.trim().length() > 30) {
			UtilisateurException.ajouterErreur(CodesResultatBLL.INPUT_ERROR);
		}
	}
	private void validerNom(String nom, UtilisateurException UtilisateurException) {
		if(nom.isBlank() || nom.trim().length() > 30) {
			UtilisateurException.ajouterErreur(CodesResultatBLL.INPUT_ERROR);
		}
	}
	private void validerPrenom(String prenom, UtilisateurException UtilisateurException) {
		if(prenom.isBlank() || prenom.trim().length() > 30) {
			UtilisateurException.ajouterErreur(CodesResultatBLL.INPUT_ERROR);
		}
	}
	private void validerEmail(String email, UtilisateurException UtilisateurException) {
		if(email.isBlank() || email.trim().length() > 50) {
			UtilisateurException.ajouterErreur(CodesResultatBLL.INPUT_ERROR);
		}
	}
	private void validerTelephone(String telephone, UtilisateurException UtilisateurException) {
		String value = telephone.replaceAll("[^0-9]", "");
		System.out.println(value);
		/* Or the value it at 0 because not known, or the value need to contain 10 number (classic phone number size) */
		if(value.trim().length() != 0 && value.trim().length() != 10) {
			System.out.println("tel error");
			System.out.println(value.trim().length() != 10);
			System.out.println(value.trim().length() != 0);
			UtilisateurException.ajouterErreur(CodesResultatBLL.INPUT_ERROR);
		}
	}
	private void validerRue(String rue, UtilisateurException UtilisateurException) {
		if(rue.isBlank() || rue.trim().length() > 30) {
			UtilisateurException.ajouterErreur(CodesResultatBLL.INPUT_ERROR);
		}
	}
	private void validerCodePostal(String code_postal, UtilisateurException UtilisateurException) {
		String value = code_postal.replaceAll("[^0-9]", "");
		System.out.println(value);
		if(value.isBlank() || code_postal.trim().length() != 5) {
			System.out.println("cp error");
			UtilisateurException.ajouterErreur(CodesResultatBLL.INPUT_ERROR);
		}
	}
	private void validerVille(String ville, UtilisateurException UtilisateurException) {
		if(ville.isBlank() || ville.trim().length() > 40) {
			UtilisateurException.ajouterErreur(CodesResultatBLL.INPUT_ERROR);
		}
	}
	private void validerMotDePasseInscription(String mot_de_passe, String confirmation, UtilisateurException UtilisateurException) {
		if(mot_de_passe.isBlank() || mot_de_passe.trim().length() > 100) {
			UtilisateurException.ajouterErreur(CodesResultatBLL.INPUT_ERROR);
		} else if (!mot_de_passe.contentEquals(confirmation)) {
			UtilisateurException.ajouterErreur(CodesResultatBLL.PASSWORD_NOT_MATCHING);
		}
	}
	private void validerMotDePasseConnexion(String mot_de_passe, UtilisateurException UtilisateurException) {
		if(mot_de_passe.isBlank() || mot_de_passe.trim().length() > 100) {
			UtilisateurException.ajouterErreur(CodesResultatBLL.INPUT_ERROR);
		}
	}
}
