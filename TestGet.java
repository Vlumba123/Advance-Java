package testid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

        public class TestGet {
	
	    public static void main(String[] args) throws Exception {
		    testget();
	}

	    public static void testget() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","root");
		 
		int id= 5;
		
        PreparedStatement ps =  (PreparedStatement) conn.prepareStatement("Select * from employe where id = ?");
		
	    ps.setInt(1, id);
		
	    ResultSet rs = ps.executeQuery();
        
        while (rs.next()) 
        	
     {
        System.out.print(" " + rs.getString(1));
		System.out.print(" " + rs.getString(2));
		System.out.print(" " + rs.getString(3));
		System.out.print(" " + rs.getString(4));
		System.out.print(" " + rs.getString(5));
	  }
		ps.close();
		rs.close();
		conn.close();
	}

}
