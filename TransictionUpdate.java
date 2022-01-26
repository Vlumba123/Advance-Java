package testid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransictionUpdate {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","root");
	
	con.setAutoCommit(false);
	
	Statement stmt = con.createStatement();
	
	try {
	
	int i = stmt.executeUpdate("UPDATE EMPLOYE SET fNAME='Vish' where id=1");
	i = stmt.executeUpdate("UPDATE EMPLOYE SET fNAME='Raj' where id=1");
   
	con.commit(); 
	} catch (SQLException e) {
		con.rollback();
	}
	
	stmt.close();
	con.close();
	
}

}
	
	


