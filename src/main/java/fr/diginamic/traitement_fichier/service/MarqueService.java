/**
 * 
 */
package fr.diginamic.traitement_fichier.service;

import fr.diginamic.traitement_fichier.dao.MarqueDao;
import fr.diginamic.traitement_fichier.model.Marque;

/**
 * @author Eloi
 *
 */
public class MarqueService {

	public void insert(Marque marque) {
		MarqueDao marDao = new MarqueDao();
		marDao.insert(marque);
	}

}
