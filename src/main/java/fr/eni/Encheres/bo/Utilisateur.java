package fr.eni.Encheres.bo;



public class Utilisateur{

	// Variables
	private int noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private int credit;
	private Byte administrateur;
	
	// Getters and Setters
	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public Byte isAdministrateur() {
		return administrateur;
	}
	public void setAdministrateur(Byte administrateur2) {
		this.administrateur = administrateur2;
	}
	
	
	// Constructor
	public Utilisateur() {
	}
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, int credit, Byte administrateur) {
		setPseudo(pseudo);
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
		setTelephone(telephone);
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
		setMotDePasse(motDePasse);
		setCredit(credit);
		setAdministrateur(administrateur);
	}
	
	// Other methods
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("noUtilisateur (id) = " + getNoUtilisateur() + "\n");
		sb.append("pseudo = " + getPseudo() + "\n");
		sb.append("nom = " + getNom() + "\n");
		sb.append("prenom = " + getPrenom() + "\n");
		sb.append("email = " + getEmail() + "\n");
		sb.append("telephone = " + getTelephone() + "\n");
		sb.append("rue = " + getRue() + "\n");
		sb.append("codePostal = " + getCodePostal() + "\n");
		sb.append("ville = " + getVille() + "\n");
		sb.append("motDePasse = " + getMotDePasse() + "\n");
		sb.append("credit = " + getCredit() + "\n");
		sb.append("administrateur = " + isAdministrateur() + "\n");
		return sb.toString();
	}
}
