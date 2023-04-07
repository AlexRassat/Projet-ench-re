package fr.eni.Encheres.dal;

import java.io.IOException;
import java.util.Properties;

public class Settings {

	private static Properties properties;
	
	static {
		try {
			properties = new Properties();
			properties.load(Settings.class.getResourceAsStream("connexion.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String cle) {
		String valeur = properties.getProperty(cle);
		return valeur;
	}
}