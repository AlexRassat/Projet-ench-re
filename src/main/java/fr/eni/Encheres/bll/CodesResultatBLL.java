package fr.eni.Encheres.bll;

/** Les codes disponibles sont entre 20000 et 29999 */
public abstract class CodesResultatBLL {
	/** Erreur, la valeur du champ ne respecte pas les spécifications requises. */
	public static final int INPUT_ERROR = 20000;
	/** Erreur, le champ "mot_de_passe" et "confirmation" ne correspondent pas. */
	public static final int PASSWORD_NOT_MATCHING = 20001;
	/** Erreur, utilisateur introuvable (Identifiant ou mot de passe incorrect) */
	public static final int SQL_RESPONSE_NULL = 20002;
}