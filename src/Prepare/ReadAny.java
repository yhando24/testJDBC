package Prepare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadAny {

	
	public static <T> ArrayList<T> read() {
		
	
		
		
		Connection co = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir le SELECT");
		String select = sc.nextLine();
		System.out.println("Veuillez saisir le FROM parmi les tables suivantes : ");
		String from = sc.nextLine();
		
		ArrayList<T> myList = new ArrayList<T>();
			try {
				co = Connect.getConnection();
			
				String query = "SELECT ? FROM ?";
				prepareStatement = co.prepareStatement(query);
				ResultSetMetaData resultMetaData = resultSet.getMetaData();
				
				prepareStatement.setString(1,select );
				prepareStatement.setString(2,from );
				resultSet = prepareStatement.executeQuery();
				
				// On affiche la requête exécutée
				System.out.println(prepareStatement.toString());
				int colonne = 1;
				int index = 0;
				String [] tab = new String [15];
				while (resultSet.next()){
					tab[index] = (String) resultSet.getObject(colonne);
					index++;
					colonne++;
				}
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
		return myList;
		
		
		
		
		
	}
}
