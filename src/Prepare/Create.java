package Prepare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {
	
	
	public static void AddAuteur(String nom) {
		Connection co = null;
		Statement statement = null;
		 int result;
		
		try {
			co = Connect.getConnection();
			String Query = "INSERT INTO auteur(nom) VALUES('"+nom+"')";
		
			statement = co.createStatement();
			result = statement.executeUpdate(Query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
	
				statement.close();
				co.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
	}
	
	
	public static void AddGenre(String nom) {
		Connection co = null;
		Statement statement = null;
		 int result;
		
		try {
			co = Connect.getConnection();
			String Query = "INSERT INTO genre(nom_genre) VALUES('"+nom+"')";
		
			statement = co.createStatement();
			result = statement.executeUpdate(Query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
	
				statement.close();
				co.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
	}
}
	
	
	
	

