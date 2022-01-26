package testid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionUpdatePrepared {
	
	public static void main(String[] args) throws Exception {
		
			
	        Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","root");
		
			conn.setAutoCommit(false);
			
	        PreparedStatement ps =  (PreparedStatement) conn.prepareStatement("UPDATE EMPLOYE Set FNAME=?,LNAME=?,SALARY=?, dept_Id=? WHERE ID=?");
			try {
	        int id = 32;
			String fname = "YASH";
			String lname = "Verma";
			int salary = 12000;
			int dept_Id  = 5;
	        
	        
	        ps.setString(1, fname);
	        ps.setString(2, lname);
	        ps.setInt(3, salary);
	        ps.setInt(4, dept_Id);
	        ps.setInt(5, id);
	        
	       int  i =  ps.executeUpdate();
	       
	       conn.commit();
			} catch (SQLException e) {
			conn.rollback();
			}
	        System.out.println(" " + "updated");
	        
	        ps.close();
	        conn.close();
			
		}
	
	}


