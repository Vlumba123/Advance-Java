package testid;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
	
public static void main(String[] args) throws Exception {
		  displaytable();
	     // testadd();
         //testDelete();
      //testUpdate();
	
		}
//1>	
public static void displaytable() throws Exception {
		 
		//LOAD MYSQL DATABASE DRIVER
		        Class.forName("com.mysql.jdbc.Driver");
		
		//CREATE CONNECTIONS USING DATABASE URL AND CREDENTIALS
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","root");
		
		//EXECUTE QUERY
				Statement stmt = conn.createStatement();
				
		//EXECUTE QUERY AND PROCESS RESULT
				ResultSet sr = stmt.executeQuery("Select * from employe ");
				
		// ITERATE ROW BY ROW
				while (sr.next())
				{
					System.out.println("Id is "+ sr.getInt(1));
					
					System.out.println("First Name "+ sr.getString(2));
					
					System.out.println("Last name "+ sr.getString(3));
					
					System.out.println("Salary  "+ sr.getInt(4));
					
					System.out.println("Dept_Id "+ sr.getInt(5));
					
				} 
		//CLOSE RESOURCES
				
				sr.close();
				stmt.close();
				conn.close();
			}
//2>	
public static void testUpdate() throws Exception {
     
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","root");
		
	    Statement stmt = conn.createStatement();
				
			int i = stmt.executeUpdate("update employe set fname = 'vish' where id=8");
			System.out.println(i + "Records Updated");
				
				stmt.close();
				conn.close();
	}

//3>
public static void testDelete() throws Exception {
		 
		
        Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","root");
		
		Statement stmt = conn.createStatement();
				
				String sql2 =( "Delete  from Employe where id=3");
				int i = stmt.executeUpdate(sql2);
				
				System.out.println(i + "  One Record Deleted");
			    
				stmt.close();
				conn.close();
				}

//4>
public static void testadd() throws Exception {
     
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","root");
		
	    Statement stmt = conn.createStatement();
				
				String sql = "Insert Into Employe values(15,'Raj','Gupta',5000,3)";
				int i = stmt.executeUpdate(sql);
				

				System.out.println(i + " Record inserted");
				
				stmt.close();
				conn.close();
	}
}
		


