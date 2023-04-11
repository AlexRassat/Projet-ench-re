package fr.eni.Encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.Encheres.UtilisateurException;
import fr.eni.Encheres.bll.UtilisateurManager;
import fr.eni.Encheres.bo.Utilisateur;
import fr.eni.Encheres.dal.DALException;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConnexionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ConnexionUtilisateur.jsp");
		if (rd != null) {
			rd.forward(request, response);			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//Traitement pour connecter un Utilisateur
		try {
			connecterUtilisateur(request, response);
			// =-=-=-=-= QUAND CONNECTÉ, REDIRIGER SUR LA PAGE D'ACCUEIL ! =-=-=-=-=
		} catch (DALException e) {
			System.out.println("Erreur lors de la connextion de l'utilisateur");
			doGet(request, response);
		}
	}
	
	private void connecterUtilisateur (HttpServletRequest request, HttpServletResponse response) throws DALException, IOException {
		String pseudo = request.getParameter("pseudo_utilisateur").toString();
		String mot_de_passe = request.getParameter("mot_de_passe_utilisateur").toString();
		
		if (pseudo.contentEquals("") || mot_de_passe.contentEquals("")) {
			System.out.println("Tout les champs ne sont pas renseigné !");
		} else  {
			UtilisateurManager utilisateurManager = new UtilisateurManager();
			try {
				String username = utilisateurManager.connecterUtilisateur(pseudo, mot_de_passe);
				if (username != null) {
					Cookie connexionCookie = new Cookie("username", username);
					response.addCookie(connexionCookie);
				} else {
					System.out.println("Identifiant ou mot de passe incorrect !");
					response.sendRedirect(request.getContextPath()+"/ConnexionServlet");
				}
 			} catch (UtilisateurException e) {
				request.setAttribute("listeCodesErreur : ", e.getListeCodesErreur());
			}
		}
	}
}
