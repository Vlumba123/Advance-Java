package testid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDelete {
	
	public static void main(String[] args) throws Exception {
		 
Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","root");
		
		con.setAutoCommit(false);
		
		Statement stmt = con.createStatement();
		
		try {
		
		int i = stmt.executeUpdate("DELETE FROM EMPLOYE WHERE ID=20;");
		i = stmt.executeUpdate("DELETE FROM EMPLOYE WHERE ID=24;");
	    i = stmt.executeUpdate("DELETE FROM EMPLOYE WHERE ID=19;");
		i = stmt.executeUpdate("DELETE FROM EMP[LOYE WHERE ID=20;");
		
		
		
		con.commit(); 
		} catch (SQLException e) {
			con.rollback();
		}
		
		stmt.close();
		con.close();
		
	}


}
		
	
	


