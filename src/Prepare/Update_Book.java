package Prepare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class Update_Book {
	
	
	public static void updateTitreById(int id, String titre) {
		Connection co = null;
		PreparedStatement preparedStatement= null;
		
		
		try {
			co = Connect.getConnection();
			String query = "UPDATE livre SET titre = ? WHERE id=?";
			preparedStatement = co.prepareStatement(query);
			preparedStatement.setString(1, titre);
			preparedStatement.setInt(2, id);
			
			int result = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				co.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	
		
		
		
	}

}
