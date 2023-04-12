package fr.eni.Encheres.bll;

public class BLLManager {

	private static BLLManager instance;
	
	private UtilisateurManager utilisateurManager;

	
	public static BLLManager getInstance() {
		if (instance == null) {
			instance = new BLLManager();
		}
		
		return instance;
	}

	public UtilisateurManager getUtilisateurManager() {
		if (utilisateurManager == null) {
			utilisateurManager = new UtilisateurManager();
		}
		return utilisateurManager;
	}


}