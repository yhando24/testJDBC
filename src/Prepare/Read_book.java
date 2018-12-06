package Prepare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Livre;

public class Read_book {
	

	public static Livre readBookByid(int id1){
		Livre book = new Livre();
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
			preparedStatement.setInt(1,id1 );
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// On affiche la requête exécutée
			System.out.println(preparedStatement.toString());
			
			
			while (resultSet.next())
			{
				
				 book.setId(resultSet.getInt("id"));
				 book.setTitre(resultSet.getString("titre"));
				 book.setGenre(resultSet.getString("genre"));
				 book.setCategorie(resultSet.getString("categorie"));
				 book.setId_auteur(resultSet.getInt("id"));
				 book.setId_editeur(resultSet.getInt("id"));
				 book.setId_genre(resultSet.getInt("id"));
				 
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
		return book;
	}
	
	
	
	public static ArrayList <Livre>  readBookByGenre(String name){
		ArrayList <Livre> livres = new ArrayList<Livre>();
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		try {
			connection = Connect.getConnection();
			String query = "SELECT * FROM livre WHERE genre = ?";
			prepareStatement = connection.prepareStatement(query);
			
			prepareStatement.setString(1,name );
			
			ResultSet resultSet = prepareStatement.executeQuery();
			
			// On affiche la requête exécutée
			System.out.println(prepareStatement.toString());
			
		
			
			while (resultSet.next()){
				
				 Livre book = new Livre();
				 book.setId(resultSet.getInt("id"));
				 book.setTitre(resultSet.getString("titre"));
				 book.setGenre(resultSet.getString("genre"));
				 book.setCategorie(resultSet.getString("categorie"));
				 book.setId_auteur(resultSet.getInt("id"));
				 book.setId_editeur(resultSet.getInt("id"));
				 book.setId_genre(resultSet.getInt("id"));
				 
				 livres.add(book);
				 
			}
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				// ne rien faire
				e.printStackTrace();
			}
		}
		
		
		return livres;
	}
	
}
