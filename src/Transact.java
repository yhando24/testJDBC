import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Transact
{
	public static void main(String[] args)
	{
		updateData();
	}
	
	public static void updateData()
	{
		Connection conn = null;
		
		try
		{
			conn = Connect.getConnection();
			conn.setAutoCommit(false);
			
			// Création d'un objet Statement permettant de réaliser des requêtes
			// sur la base de données
			Statement statement = conn.createStatement();

			// On crée la requête
			String query = "UPDATE matiere set mat_nom = 'ALLEMAND' WHERE mat_id = 1";
						
			Integer update = statement.executeUpdate(query);
			System.out.println("Résultat de la requête UPDATE => " + update.intValue());
			
			// On crée la requête
			query = "UPDATE matiere set mat_nom = 'MATHEMATIQUES' WHERE mat_id = 1";
					
			update = statement.executeUpdate(query);
			System.out.println("Résultat de la requête UPDATE => " + update.intValue());
						
			// les requêtes qui n'ont pas été annulées sont validées
			conn.commit();
			
			statement.close();
			conn.close();
		}
		catch (Exception e)
		{
			// les requêtes précédentes sont annulées
			try {
				conn.rollback();
				e.printStackTrace();
				
			} catch (SQLException e1) {
				// DO NOTHING
				e1.printStackTrace();
			}
			
		}
	}
}