
package com.Javabean;

import java.util.Iterator;
import java.util.List;
import com.Javabean.MarksheetBean;
import com.Javabean.MarksheetModel;

public class TestMarksheetModel {
	
public static void main(String[] args) throws Exception {
		//testadd();
		//testupdate();
		//testdelete();
	   // testget();
	     testGetMeritList();
	   // testsearch();
	
	}

public static void testsearch() throws Exception {
	
	MarksheetBean bean = new MarksheetBean();
	
	MarksheetModel ms= new MarksheetModel();
	
    List<MarksheetBean> list= ms.search(bean);
	 
	Iterator<MarksheetBean> it = list.iterator();
	
	while (it.hasNext()) {
		
		MarksheetBean bean1 = (MarksheetBean) it.next();
		 
		System.out.print("\t " +bean1.getId());
		System.out.print("\t " +bean.getrollno());
		System.out.print("\t " +bean1.getFname());
		System.out.print("\t " +bean1.getLname());
		System.out.print("\t " +bean1.getPhysics());
		System.out.print("\t " +bean1.getChemistry());
		System.out.println(bean1.getMaths());
	
		}
	 

   }

public static void testGetMeritList() throws Exception  {
	
	 MarksheetBean bean = new MarksheetBean();
	
	 MarksheetModel ms =new MarksheetModel();
	 
	 List<MarksheetBean> l1= MarksheetModel.getMeritList();
	 
	 Iterator it = l1.iterator();
	 
	 System.out.println("ID\tROLLNO\tFIRSTNAME\tLASTNAME\tPHYSICS\tCHEMISTRY\tMATHS\tTOTALMARKS\tPERCENTAGE");
	 
	 while(it.hasNext()) {
		 
		 MarksheetBean bean1 = (MarksheetBean)it.next();
		 
		 
		    
		    System.out.print("\t " +bean1.getId());
			System.out.print("\t "+bean1.getrollno());
			System.out.print("\t "+bean1.getFname());
			System.out.print("\t "+bean1.getLname());
			System.out.print("\t "+bean1.getPhysics());
			System.out.print("\t "+bean1.getChemistry());
			System.out.println("\t "+bean1.getMaths());
			System.out.println(" \t"+(bean1.getPhysics()+bean1.getChemistry()+bean1.getMaths()));
			System.out.println(" \t"+(bean1.getPhysics()+bean1.getChemistry()+bean1.getMaths())/3);
		
	 }
		 
		 }
	 
public static void testget() throws Exception {
	
	    MarksheetBean bean =new MarksheetBean();
		
		bean.setrollno(255);
		
		MarksheetModel ms= new MarksheetModel();
		
	    bean =(MarksheetBean) ms.get(bean);
	    
	    System.out.println(bean.getId());
	    System.out.println(bean.getrollno());
	    System.out.println(bean.getFname());
	    System.out.println(bean.getLname());
	    System.out.println(bean.getPhysics());
	    System.out.println(bean.getChemistry());
	    System.out.println(bean.getMaths());
	    
}
	
public static void testdelete() throws Exception {
		
        MarksheetBean bean =new MarksheetBean();
		
		bean.setrollno(261);
		
		MarksheetModel ms= new MarksheetModel();

	    ms.Delete(bean);
	    
	    System.out.println("Deleted");
	   
	}	
	
public static void testupdate() throws Exception {
		
		MarksheetBean bean =new MarksheetBean();
		
		bean.setrollno(246);
		bean.setFname("RAM");
		bean.setLname("VERMA");
		bean.setPhysics(55);
		bean.setChemistry(66);
		bean.setMaths(74);
		bean.setId(1);
		MarksheetModel ms= new MarksheetModel();

	    ms.update(bean);
	    
	    System.out.println("Deleted");
	}	
		
	
public static void testadd() throws Exception {
		
		MarksheetBean bean =new MarksheetBean();
		bean.setId(150);
		bean.setrollno(264);
		bean.setFname("RAM");
		bean.setLname("VERMA");
		bean.setPhysics(55);
		bean.setChemistry(66);
		bean.setMaths(74);
		
		MarksheetModel ms= new MarksheetModel();
	    ms.add(bean);
	    
	    System.out.println("Inserted");
	}

}









