/**
 * 
 */
package fr.diginamic.traitement_fichier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.diginamic.traitement_fichier.connection.ConnectionManager;
import fr.diginamic.traitement_fichier.exception.TechnicalException;
import fr.diginamic.traitement_fichier.model.Categorie;

/**
 * @author Eloi
 *
 */
public class CategorieDao {

	public void insert(Categorie categorie) {

		Connection conn = ConnectionManager.getInstance();
		PreparedStatement monStatement = null;

		try {

			monStatement = conn.prepareStatement("INSERT INTO categories (NOM) VALUES (?)");
			monStatement.setString(1, categorie.getNom());
			conn.commit();

		} catch (SQLException e) {
			throw new TechnicalException("Impossible d'ajouter la categorie", e);
		} finally {

			try {
				if (monStatement != null) {
					monStatement.close();
				}
				if (conn != null || conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new TechnicalException("Impossible de fermer les connections à la BDD", e);
			}
		}
	}

}
