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

	private String energie100g;
	private String graisse100g;
	private String sucres100g;
	private String fibres100g;
	private String proteines100g;
	private String sel100g;
	private String vitA100g;
	private String vitD100g;
	private String vitE100g;
	private String vitK100g;
	private String vitC100g;
	private String vitB1100g;
	private String vitB2100g;
	private String vitPP100g;
	private String vitB6100g;
	private String vitB9100g;
	private String vitB12100g;
	private String calcium100g;
	private String magnesium100g;
	private String iron100g;
	private String fer100g;
	private String betaCarotene100g;

	// presenceHuilePalme : Integer 1=oui, 0=non communiqué, -1=non
	private Integer presenceHuilePalme;

	public Produit(String ligne) {

		String[] attributs = ligne.split("\\|");

		String catTemp = attributs[0];
		String marqueTemp = attributs[1];

		// this.categorie;
		// this.marque ;

		this.nom = attributs[2];
		this.nutrigrade = attributs[2];

		this.energie100g = attributs[5];
		this.graisse100g = attributs[6];
		this.sucres100g = attributs[7];

		this.fibres100g = attributs[8];
		this.proteines100g = attributs[9];
		this.sel100g = attributs[10];

		this.vitA100g = attributs[11];
		this.vitD100g = attributs[12];
		this.vitE100g = attributs[13];

		this.vitK100g = attributs[14];
		this.vitC100g = attributs[15];
		this.vitB1100g = attributs[16];

		this.vitB2100g = attributs[17];
		this.vitPP100g = attributs[18];
		this.vitB6100g = attributs[19];

		this.vitB9100g = attributs[20];
		this.vitB12100g = attributs[21];
		this.calcium100g = attributs[22];

		this.magnesium100g = attributs[23];
		this.iron100g = attributs[24];
		this.fer100g = attributs[25];
		this.betaCarotene100g = attributs[26];

		if (attributs[27] == "1") {
			this.presenceHuilePalme = 1;
		} else if (attributs[27] == "0") {
			this.presenceHuilePalme = -1;
		} else {
			this.presenceHuilePalme = 0;
		}
	}

}
