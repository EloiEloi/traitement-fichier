/**
 * 
 */
package fr.diginamic.traitement_fichier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.diginamic.traitement_fichier.connection.ConnectionManager;
import fr.diginamic.traitement_fichier.exception.TechnicalException;
import fr.diginamic.traitement_fichier.model.Marque;

/**
 * @author Eloi
 *
 */
public class MarqueDao {

	public void insert(Marque marque) {

		Connection conn = ConnectionManager.getInstance();
		PreparedStatement monStatement = null;

		try {

			monStatement = conn.prepareStatement("INSERT INTO marques (NOM) VALUES (?)");
			monStatement.setString(1, marque.getNom());
			conn.commit();

		} catch (SQLException e) {
			throw new TechnicalException("Impossible d'ajouter la marque", e);
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
