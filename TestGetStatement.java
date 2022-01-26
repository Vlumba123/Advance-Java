package testid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestGetStatement {
	
	public static void main(String[] args) throws Exception {
		testget();
		
	}

	public static void testget() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","root");
		
		int id= 4;
		
		Statement stmt = conn.createStatement();
		
		String sql= (" Select * from employe where id= "+id+" ");
		
		ResultSet sr = stmt.executeQuery(sql);
		
		while (sr.next()) {
		
		System.out.println(" "+ sr.getString(1));
		System.out.println(" "+ sr.getString(2));
		System.out.println(" "+ sr.getString(3));
		System.out.println(" "+ sr.getString(4));
		System.out.println(" "+ sr.getString(5));
		
		}
		sr.close();
		conn.close();
	}

}
