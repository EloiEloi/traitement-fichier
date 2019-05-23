/**
 * 
 */
package fr.diginamic.traitement_fichier.model;

/**
 * @author Eloi
 *
 */
public class Categorie {

	private Integer id;
	/** nom : String */
	private String nom;

	/**
	 * Constructor
	 * 
	 * @param ligne
	 */
	public Categorie(String ligne) {

		String[] attributs = ligne.split("\\|");

		this.nom = attributs[0];
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Getter
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 *
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
