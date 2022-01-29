package com.Javabean;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModel {

	public static void add(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/rays?useSSL=false", "root", "root");

		con.setAutoCommit(false);

		PreparedStatement ps = con.prepareStatement("INSERT INTO MARKSHEET VALUES(?,?,?,?,?,?,?)");

		ps.setInt(1, bean.getId());
		ps.setInt(2, bean.getrollno());
		ps.setString(3, bean.getFname());
		ps.setString(4, bean.getLname());
		ps.setInt(5, bean.getPhysics());
		ps.setInt(6, bean.getChemistry());
		ps.setInt(7, bean.getMaths());

		ps.executeUpdate();
		con.commit();

		con.close();
		ps.close();
	}

	public void update(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/rays?useSSL=false", "root", "root");

		con.setAutoCommit(false);

		PreparedStatement ps = con.prepareStatement(
			 	"UPDATE MARKSHEET SET RollNumber=?, FirstName=?, LastName=?, PHYSICS=?, CHEMISTRY=?, MATHEMATICS=? WHERE ID=?");

		ps.setInt(1, bean.getrollno());
		ps.setString(2, bean.getFname());
		ps.setString(3, bean.getLname());
		ps.setInt(4, bean.getPhysics());
		ps.setInt(5, bean.getChemistry());
		ps.setInt(6, bean.getMaths());
		ps.setInt(7, bean.getId());

		ps.executeUpdate();
		con.commit();

		ps.close();
		con.close();
	}

	public void Delete(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/rays?useSSL=false", "root", "root");

		con.setAutoCommit(false);

		PreparedStatement ps = con.prepareStatement("DELETE FROM MARKSHEET WHERE RollNumber =?");

		ps.setInt(1, bean.getrollno());

		ps.executeUpdate();
		con.commit();

		ps.close();
		con.close();
	}

	public MarksheetBean get(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/rays?useSSL=false", "root", "root");


		PreparedStatement ps = con.prepareStatement("SELECT * FROM MARKSHEET WHERE RollNumber=?");

		ps.setInt(1, bean.getrollno());

		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
          
			bean = new MarksheetBean();
			
			bean.setId(rs.getInt(1));
			bean.setrollno(rs.getInt(2));
			bean.setFname(rs.getString(3));
			bean.setLname(rs.getString(4));
			bean.setPhysics(rs.getInt(5));
			bean.setChemistry(rs.getInt(6));
			bean.setMaths(rs.getInt(7));
		}	
		
             return bean;
	
	}
	
	public List<MarksheetBean> search(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/rays?useSSL=false", "root", "root");

	    PreparedStatement ps = con.prepareStatement("SELECT * FROM MARKSHEET");

		ResultSet rs = ps.executeQuery();
		
		ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();

		 while (rs.next()) {
    

				bean = new MarksheetBean();
				
				bean.setId(rs.getInt(1));
				bean.setrollno(rs.getInt(2));
				bean.setFname(rs.getString(3));
				bean.setLname(rs.getString(4));
				bean.setPhysics(rs.getInt(5));
				bean.setChemistry(rs.getInt(6));
				bean.setMaths(rs.getInt(7));
				
				list.add(bean);
			}	
			
	             return list;
		
		}
			


	public static List<MarksheetBean> getMeritList() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/rays?useSSL=false", "root", "root");

		PreparedStatement ps = con.prepareStatement(
				"SELECT *, (physics+chemistry+mathematics) As totalmarks,((physics+chemistry+mathematics)/3) AS percentage FROM marksheet WHERE (physics>40 and chemistry>40 and mathematics>40 ) ORDER BY percentage DESC LIMIT 10");

		ResultSet rs = ps.executeQuery();
		MarksheetBean bean = null;

		ArrayList<MarksheetBean> list1 = new ArrayList<MarksheetBean>();

		
		while (rs.next()) {
			
	   bean = new MarksheetBean();
			
		bean.setId(rs.getInt(1));
		bean.setrollno(rs.getInt(2));
		bean.setFname(rs.getString(3));
		bean.setLname(rs.getString(4));
		bean.setPhysics(rs.getInt(5));
		bean.setChemistry(rs.getInt(6));
		bean.setMaths(rs.getInt(7));
		
		list1.add(bean);
		}
		ps.close();
		con.close();
		return list1;

	}

}
