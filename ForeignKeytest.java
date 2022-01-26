package testid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ForeignKeytest {
	
	public static void main(String[] args) throws Exception {
		displaytable();
	}

	public static void displaytable() throws Exception {
		 Class.forName("com.mysql.jdbc.Driver");
			
			//CREATE CONNECTIONS USING DATABASE URL AND CREDENTIALS
			        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","root");
			
			//EXECUTE QUERY
					Statement stmt = conn.createStatement();
					
			//EXECUTE QUERY AND PROCESS RESULT
					ResultSet sr = stmt.executeQuery("Select * from employe left join department on employe.id=department.id union select * from employe right join department on employe.id=department.id");
					
			// ITERATE ROW BY ROW
					while (sr.next())
					{
						System.out.println("Id is "+ sr.getInt(1));
						
						System.out.println("First Name "+ sr.getString(2));
						
						System.out.println("Last name "+ sr.getString(3));
						
						System.out.println("Salary  "+ sr.getInt(4));
						
						System.out.println("Dept_Id "+ sr.getInt(5));
						
						System.out.println("Department "+ sr.getInt(6));
						
						System.out.println("Departname "+ sr.getString(7));
							
					} 
			//CLOSE RESOURCES
					
					sr.close();
					stmt.close();
					conn.close();
				}
		
}
	


