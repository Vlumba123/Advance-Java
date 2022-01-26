package testid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TrancationDeletePrepared {
	
	public static void main(String[] args) throws Exception {
		
		
			
			 Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","root");
				
				conn.setAutoCommit(false);
				
				PreparedStatement ps = conn.prepareStatement("DELETE  FROM EMPLOYE WHERE ID=?" );
				try {  
				int id=20;
				
				
				ps.setInt(1, id);
				
				
				int i = ps.executeUpdate();
				conn.commit();
				} catch (SQLException e) {
					conn.rollback();
				}
				
				
				System.out.println(" " + "One row deleted");
				
				ps.close();
				conn.close();
						
				}

		
	}


