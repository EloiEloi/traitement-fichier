package fr.diginamic.traitement_fichier;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.io.FileUtils;

import fr.diginamic.traitement_fichier.connection.ConnectionManager;
import fr.diginamic.traitement_fichier.exception.TechnicalException;
import fr.diginamic.traitement_fichier.model.Categorie;
import fr.diginamic.traitement_fichier.model.Marque;
import fr.diginamic.traitement_fichier.model.Produit;

/**
 * @author Eloi
 * 
 *         Class principale de l'app permettant de lancer l app
 */
public class App {
	/**
	 * 
	 * Méthode principale de l'application
	 * 
	 * @param args
	 *            aucun
	 */
	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		System.out.println("------------ DEBUT du traitement du fichier ------------");

		// timer afin d'afficher chaque seconde le temps écoulé (dans la console)
		TimerTask task = new TimerTask() {
			private int compteur;

			@Override
			public void run() {
				compteur++;
				System.out.println(compteur);
			}
		};

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, 1000);

		ArrayList<Produit> listeProduits = new ArrayList<Produit>();

		// hashSet contenant la liste de toute les categories existantes
		Set<Categorie> listeCategories = new HashSet<>();

		// hashSet contenant la liste de toutes les marques existantes
		Set<Marque> listeMarques = new HashSet<>();

		// récupération du fichier à lire
		File file = new File("D:/diginamic/openFoodFacts.csv");

		try {
			// on enregistre chaque ligne dans une list
			List<String> listeLignes = FileUtils.readLines(file, "utf8");
			// on supprime la 1ere ligne afin de ne pas récupérer la 1ère ligne du fichier qui correspond aux noms des colonnes
			listeLignes.remove(0);

			// boucle pour parcourir la list contenant ligne par ligne le contenu du fichier
			for (String ligne : listeLignes) {

				// on récupere les categories
				Categorie categorie = new Categorie(ligne);
				listeCategories.add(categorie);

				// on récupere les marques
				Marque marque = new Marque(ligne);
				listeMarques.add(marque);

				// on récupere les produits
				Produit produit = new Produit(ligne);
				listeProduits.add(produit);

			}

			// // enregistrement dans la BDD du contenu de la liste de Categories
			// CategorieDao catDao = new CategorieDao();
			// Iterator<Categorie> monIt = listeCategories.iterator();
			// while (monIt.hasNext()) {
			// Categorie maCat = monIt.next();
			// catDao.insert(maCat);
			// // System.out.println(maCat.getNom());
			// }
			//
			// // enregistrement dans la BDD du contenu de la liste de Marques
			// MarqueDao marDao = new MarqueDao();
			// Iterator<Marque> monIt2 = listeMarques.iterator();
			// while (monIt2.hasNext()) {
			// Marque maMar = monIt2.next();
			// marDao.insert(maMar);
			//
			// // System.out.println(maMar.getNom());
			// }
			//

			// recupération du driver sql pour la connection à la bdd
			try {
				Class.forName(ConnectionManager.getDriverName());
			} catch (ClassNotFoundException e) {
				throw new TechnicalException("Le driver JBDC n'a pas été trouvé.", e);
			}

		} catch (IOException e) {
			throw new TechnicalException("Impossible de lire le fichier : " + file, e);
		}

		long end = System.currentTimeMillis();
		long dureeTraitementApp = (end - start) / 1000;
		timer.cancel();
		System.out.println("------------ FIN du traitement du fichier  ------------");
		System.out.println("duree du traitement : " + dureeTraitementApp + " secondes");

	}

}
