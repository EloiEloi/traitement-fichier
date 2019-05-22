package fr.diginamic.traitement_fichier.utils;

/**
 * @author Eloi
 *
 */
public class DoubleUtils {

	/**
	 * 
	 * méthode qui transforme un String en Double
	 * 
	 * @param chaine
	 *            Le String à convertir en Double
	 * @return
	 * 		retourne un Double (Le string convertit en Double)
	 */
	static Double convert(String chaine) {
		if (chaine == null || chaine.isEmpty()) {
			return 0d;
		}
		return Double.parseDouble(chaine);
	}

}
