package fr.eni.Encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.Encheres.UtilisateurException;
import fr.eni.Encheres.bll.UtilisateurManager;
import fr.eni.Encheres.dal.DALException;
import fr.eni.Encheres.dal.UtilisateurDAO;

@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InscriptionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/InscriptionUtilisateur.jsp");
		if (rd != null) {
			rd.forward(request, response);			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//Traitement pour ajouter un Utilisateur
		try {
			ajouterUtilisateur(request,response);
			// =-=-=-=-= QUAND INSCRIT, REDIRIGER SUR LA PAGE D'ACCUEIL ! =-=-=-=-=
		} catch (DALException e) {
			System.out.println("Erreur lors de l'inscription utilisateur");
			doGet(request, response);
		}
	}
	
	private void ajouterUtilisateur (HttpServletRequest request, HttpServletResponse response) throws DALException {
		String pseudo = request.getParameter("pseudo_utilisateur").toString();
		String nom = request.getParameter("nom_utilisateur").toString();
		String prenom = request.getParameter("prenom_utilisateur").toString();
		String email = request.getParameter("email_utilisateur").toString();
		String telephone = request.getParameter("telephone_utilisateur").toString();
		String rue = request.getParameter("rue_utilisateur").toString();
		String code_postal = request.getParameter("code_postal_utilisateur").toString();
		String ville = request.getParameter("ville_utilisateur").toString();
		String mot_de_passe = request.getParameter("mot_de_passe_utilisateur").toString();
		String confirmation = request.getParameter("confirmation_utilisateur").toString();
		System.out.println("Values : " + pseudo + " / " + nom + " / " + prenom + " / " + email + " / " + telephone + " / " + rue + " / " + code_postal + " / " + ville + " / " + mot_de_passe + " / " + confirmation);
		
		if (
				pseudo == null ||
				nom == null ||
				prenom == null ||
				email == null ||
				telephone == null ||
				rue == null ||
				code_postal == null ||
				ville == null || 
				mot_de_passe == null
			) {
			System.out.println("Tout les champs ne sont pas renseigné !");
		} else if ( !mot_de_passe.contentEquals(confirmation) ) {
			System.out.println("Les mots de passe ne correspondent pas !");
		} else {
			UtilisateurManager utilisateurManager = new UtilisateurManager();
			try {
				// Auto set "credit" and "administrateur" values to 100 and 0 (non admin)
				utilisateurManager.ajouterUtilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, 100, (byte) 0);
			} catch (UtilisateurException e) {
				e.printStackTrace();
				request.setAttribute("listeCodesErreur : ", e.getListeCodesErreur());
			}
		}
	}
}