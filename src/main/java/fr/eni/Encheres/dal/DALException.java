package fr.eni.Encheres.dal;

public class DALException extends Exception {
	private static final long serialVersionUID = 1L;

	/* constructeur (surcharge) permettant d'instancier une exception de type DALException */
	public DALException(String message) {
		super(message);
	}

	/* constructeur (surcharge) permettant d'instancier une exception de type DALException */
	public DALException(String message, Throwable cause) {
		super(message, cause);
	}

	/* methode substituée permettant de retourner la valeur du message de l'exception */
	@Override
	public String getMessage() {
		return "couche DAL - "+super.getMessage();
	}
}
