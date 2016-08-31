import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Prepare
{
	public static void main(String[] args)
	{
		readData(1, 6);
	}
	
	public static void readData(Integer id1, Integer id2)
	{
		try
		{
			Connection conn = Connect.getConnection();
			
			// On crée la requête
			String query = "SELECT * FROM matiere WHERE mat_id = ? OR mat_id = ?";
			
			
			// On crée l'objet avec la requête en paramètre
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			// On remplace le premier paramètre (dans cette requête il n'y a qu'un seul praramètre) par le nom de la classe
			preparedStatement.setInt(1, id1);
			preparedStatement.setInt(2, id2);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// On affiche la requête exécutée
			System.out.println(preparedStatement.toString());
			
			
			while (resultSet.next())
			{
				System.out.print("\t" + resultSet.getInt("mat_id") + "\t\t" + resultSet.getString("mat_nom") + "\r\n");
			}
			
			preparedStatement.close();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
