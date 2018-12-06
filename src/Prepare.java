import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prepare
{
	public static void main(String[] args)
	{
		readData(1);
	}
	
	public static void readData(Integer id1)
	{
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		try
		{
			conn = Connect.getConnection();
			
			// On crée la requête
			String query = "SELECT * FROM livre WHERE id = ?";
			
			
			// On crée l'objet avec la requête en paramètre
			preparedStatement = conn.prepareStatement(query);
			
			// On remplace le premier paramètre (dans cette requête il n'y a qu'un seul praramètre) par le nom de la classe
			preparedStatement.setInt(1, id1);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// On affiche la requête exécutée
			System.out.println(preparedStatement.toString());
			
			
			while (resultSet.next())
			{
				
				System.out.print("\t" + resultSet.getInt("id") + "\t\t" + resultSet.getString("mat_nom") + "\r\n");
			}
			
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				// ne rien faire
				e.printStackTrace();
			}
		}
	}
}
