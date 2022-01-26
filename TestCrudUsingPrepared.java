package testid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestCrudUsingPrepared {
	
	public static void main(String[] args) throws Exception {
		//displaytable();
		//testadd();
		//testupdate();
		testdelete();
	}
//1>
public static void testdelete() throws Exception {
		
		 Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","root");
			
			int id=7;
			
			PreparedStatement ps = conn.prepareStatement("DELETE  FROM EMPLOYE WHERE ID=?" );
			 
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			
			System.out.println(i + " " + "One row deleted");
			
			ps.close();
			conn.close();
					
			}

//2>
public static void testupdate() throws  Exception {
		
        Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","root");
		int id = 20;
		String fname = "Ritesh";
		String lname = "Sharma";
		int salary = 16000;
		int dept_Id  = 4;
		
        PreparedStatement ps =  (PreparedStatement) conn.prepareStatement("UPDATE EMPLOYE Set FNAME=?,LNAME=?,SALARY=?, dept_Id=? WHERE ID=?");
		
        ps.setString(1, fname);
        ps.setString(2, lname);
        ps.setInt(3, salary);
        ps.setInt(4, dept_Id);
        ps.setInt(5, id);
        
       int  i =  ps.executeUpdate();
        
        System.out.println(i + "updated");
        
        ps.close();
        conn.close();
		
	}

//3>	
public static void testadd() throws Exception {
	
        Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","root");
	
		int id = 20;
		String fname = "Rahul";
		String lname = "Joshi";
		int Salary = 17000;
		int depId = 3;
				
		PreparedStatement ps = conn.prepareStatement(" insert into employe value (?,?,?,?,?)" );
		
		ps.setInt(1, id);
		ps.setString(2, fname);
		ps.setString(3, lname);
		ps.setInt(4, Salary);
		ps.setInt(5, depId);
		
		int i = ps.executeUpdate();
		
		System.out.println(i + "ONE ROE INSERTED"); 
		
		conn.close();
		ps.close();
		
	}
//4>
public static void displaytable() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","root");
		  
      	PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employe");
		
		ResultSet i = ps.executeQuery();
		
		while (i.next()) {
		
		System.out.println(" "+ i.getString(1));
		
		System.out.println(" "+ i.getString(2));
		
		System.out.println(" "+ i.getString(3));
		
		System.out.println(" "+ i.getString(4));
		
		System.out.println(" "+ i.getString(5));
	}
		
        ps.close();
        conn.close();
}
	}
