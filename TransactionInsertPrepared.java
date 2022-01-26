package testid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionInsertPrepared {
	
public static void main(String[] args) throws Exception {
	
	 Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","root");
	
		conn.setAutoCommit(false);
			
		PreparedStatement ps = conn.prepareStatement(" insert into employe value (?,?,?,?,?)" );
		
		try {
			int id = 33;
			String fname = "Rahul";
			String lname = "Joshi";
			int Salary = 17000;
			int depId = 3;
			
		ps.setInt(1, id);
		ps.setString(2, fname);
		ps.setString(3, lname);
		ps.setInt(4, Salary);
		ps.setInt(5, depId);
		
		int i = ps.executeUpdate();
		
		 conn.commit();
		} catch (SQLException e) {
			conn.rollback();
		}
		System.out.println(" " + "ONE ROW INSERTED"); 
		
		conn.close();
		ps.close();
		
	}

	
}


