/**
 * 
 */
package fr.diginamic.traitement_fichier.model;

import java.util.List;

/**
 * @author Eloi
 *
 */
public class Produit {

	private Integer categorie;
	private Integer marque;
	private String nom;
	private String nutrigrade;
	private List<Ingredient> listeIngredients;
	private List<Allergene> listeAllergenes;

	/** presenceHuilePalme : Integer 1=oui, 0=non communiqué, -1=non */
	private Integer presenceHuilePalme;

	public Produit(String ligne) {

		String[] attributs = ligne.split("\\|");

		String catTemp = attributs[0];
		String marqueTemp = attributs[1];

		// this.categorie;
		// this.marque ;

		this.nom = attributs[2];
		this.nutrigrade = attributs[2];

		if (attributs[27] == "1") {
			this.presenceHuilePalme = 1;
		} else if (attributs[27] == "0") {
			this.presenceHuilePalme = -1;
		} else {
			this.presenceHuilePalme = 0;
		}
	}

}
