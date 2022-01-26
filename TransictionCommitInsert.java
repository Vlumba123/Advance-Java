package testid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransictionCommitInsert {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","root");
		
		con.setAutoCommit(false);
		
		Statement stmt = con.createStatement();
		
		try {
		
		int i = stmt.executeUpdate("INSERT INTO EMPLOYE VALUES (24,'VISH','KUMAR',12000,4)");
		i = stmt.executeUpdate("INSERT INTO EMPLOYE VALUES (28,'DIVYA','AGRAWAL',14000,2)");
	    i = stmt.executeUpdate("INSERT INTO EMPLOYE VALUES (29,'VIVEK','KARMA',18000,5)");
		i = stmt.executeUpdate("INSERT INTO EMPLOYE VALUES (30,'AUNRAG','KHER',17000,3)");
		
		
		
		con.commit(); 
		} catch (SQLException e) {
			con.rollback();
		}
		
		stmt.close();
		con.close();
		
	}

}
