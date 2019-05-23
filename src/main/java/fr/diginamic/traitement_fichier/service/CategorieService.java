/**
 * 
 */
package fr.diginamic.traitement_fichier.service;

import fr.diginamic.traitement_fichier.dao.CategorieDao;
import fr.diginamic.traitement_fichier.model.Categorie;

/**
 * @author Eloi
 *
 */
public class CategorieService {

	/**
	 * Méthode qui insere un produit dans la BDD
	 * 
	 * @param produit
	 */
	public void insert(Categorie categorie) {

		CategorieDao catDao = new CategorieDao();
		catDao.insert(categorie);

	}

}
