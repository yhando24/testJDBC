package Prepare;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
	
	public static void deleteGenre(int id) {
		Connection co = null;
		Statement statement = null;
		 int result;
		
		try {
			co = Connect.getConnection();
			String Query = "DELETE FROM genre where id ="+id;
		
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
