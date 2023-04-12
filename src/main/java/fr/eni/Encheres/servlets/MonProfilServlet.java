package fr.eni.Encheres.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.Encheres.BusinessException;
import fr.eni.Encheres.bll.BLLManager;
import fr.eni.Encheres.bll.UtilisateurManager;
import fr.eni.Encheres.bo.Utilisateur;

/**
 * Servlet implementation class MonProfilServlet
 */
@WebServlet("/MonProfilServlet")
public class MonProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonProfilServlet() {
        super();      
    }
    /**
     * Controle de surface 
     * @param field
     * @return
     */
    public boolean surfaceControl(HashMap<String, String> fields) {
    	// Par d�faut success est True
    	boolean success = true;
    	
    	// On controle chaque champ
    	for (String field : fields.values()) {
    		// Si le champs est vide ou null
    		if (field.isEmpty()) {
    			// Success -> False
    			success = false;
    		} 
    	}
    return success;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        UtilisateurManager profilUser = new UtilisateurManager();
        int id = (int)session.getAttribute("id");
        Utilisateur user=null;
        try {
            user = profilUser.selectById(id);
        } catch (BusinessException e) {
            // TODO Auto-generated catch block
        }
        request.setAttribute("profil", user); 
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/MonProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// Je récupere l'utilisateur connecter
		Utilisateur user = null;
		 int id = (int)session.getAttribute("id");

	        try {
	            user = BLLManager.getInstance().getUtilisateurManager().selectById(id);
	        } catch (BusinessException e) {
	            // TODO Auto-generated catch block
	        }
	        
	        // Je récupere les nouvelles de l'utilisateur
	        user.setPseudo(request.getParameter("pseudo"));
	        user.setNom(request.getParameter("nom"));
	        user.setPrenom(request.getParameter("prenom"));
	        user.setEmail(request.getParameter("email"));
	        user.setTelephone(request.getParameter("téléphone"));
	        user.setRue(request.getParameter("rue"));
	        user.setCodePostal(request.getParameter("codePostal"));
	        user.setVille(request.getParameter("ville"));
	        user.setMotDePasse(request.getParameter("motDePasse"));
				
	}
}
	
	
	

