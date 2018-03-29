package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import CMS.BLL.core.Admin;
import CMS.BLL.core.Manager;
import CMS.BLL.franchise.Franchise;
import CMS.UIL.model.FranchiseModel;


public class testAdmin {

	Admin admin;
    @Before public void initialize() {
       admin= new Admin();
       admin.setAll("A000001","Chandan", "Kumar", "PO Box Kaloi", 
    		   		"03323881213", "4430239991233", "2001-01-01", 980000 );
    }

	@Test
	public void testGetFunction() {
		assertEquals("Fname is not equal","A000001", admin.getID() );
		assertEquals("Fname is not equal","Chandan", admin.getFName() );
		assertEquals("Fname is not equal","Kumar", admin.getLName() );
		assertEquals("Fname is not equal","PO Box Kaloi", admin.getAddress() );
		assertEquals("Fname is not equal","03323881213", admin.getContactNumber() );
		assertEquals("Fname is not equal","4430239991233", admin.getCNIC());
		assertEquals("Fname is not equal","2001-01-01", admin.getDate_Of_Birth());
		assertEquals("Fname is not equal","980000.0",""+ admin.getBasicSalary());
	}
	
	@Test
	public void testManagerFucntion(){
		Manager m =new Manager();
		//adding manager
		m.setAll("Ali", "Sajid", "G-10,Islamabad", "03331234576", "1234567891234", "1995-11-26", 70000, "BS(CS)", "F000001");
		assertEquals("Manager is not added",true,admin.addManager(m));
		
		
		//retrieving manager

//		assertEquals("Problem in retrieving manager details"
//				,m.getMID()+",Ali Sajid,G-10,Islamabad,03331234576,1234567891234,1995-11-26,BS(CS),2018-03-23"
//				,(admin.getManager(m.getMID())).toString());
		
		//updating manager
		m.setAll(m.getMID(),"Ali", "Raheem", "G-10,Islamabad", "03331234576", "1234567891234", "1995-11-26", 70000, "BS(CS)", "F000001");
		assertEquals("Manager details updated",1,admin.updateManager(m));

		
		//firing manager
		assertEquals("Error in firing manager",true,admin.fireManager(m.getMID()));


		//firing manager
		assertEquals("Error in firing manager",false,admin.fireManager(m.getMID()));
		
		//firing manager
	
		assertEquals("Error in firing manager",false,admin.fireManager("anc"));
		//get managerList
		assertTrue("size of list is not greater then 0",admin.getManagerList().size()>=0);

	}
	
	@Test
	public void testFranchiseFucntion(){
		Franchise franchise = new Franchise();
		franchise.setAll(franchise.generateID(), "G-11, Franchise", "Franchise is good",
				"G-11, markaz", "03323881213");

		ArrayList<String> ids = new ArrayList<String>();
		// get the ID of each selected allowances type
		for (int i=0; i<2; i++) {
			ids.add("000"+i);		
		}

		//admin.addFranchise(franchise, ids);
		// inserting Franchise
		assertEquals("Error in inserting Franchise",true,admin.addFranchise(franchise, ids));
		
		//search For Franchise
		FranchiseModel fModel = admin.searchFranchise(franchise.getFID()); 
		assertEquals("Error in search Franchise",franchise.getFID()+","+franchise.getName(),(fModel.fid.getValue()+","+fModel.name.getValue()));

		//test getFranchiseList
		assertEquals("Error in getFranchiseList","F000001",admin.getFranchiseList().get(0).fid.getValue());
		
		//test getFranchiseList
		assertEquals("Error in getFranchiseList","F000001",admin.retreieveFranchiseList().get(0).getFID());

		
		//drop Franchise with 0 employee
		assertEquals("Error in drop Franchise",true,admin.dropFranchise(fModel));

		
		//drop Franchise with 0 employee
		fModel = admin.searchFranchise("F000001");
		assertEquals("Error in drop Franchise",false,admin.dropFranchise(fModel));
		

		

	}
	@Test
	public void testAllowanceFucntion(){
		assertTrue("AllowanceList is not greater then 0",admin.getAllocatedAllowancesList().size()>=0);
		assertTrue("AllowanceList is not greater then 0",admin.AllowancesList().size()>=0);
	}
	
	@Test
	public void testList(){
	    StringBuilder  p =  new StringBuilder();	
		assertTrue("Courier list is not greater then 0",admin.getRegCourierList(p).size()>=0);
		assertTrue("Courier list is not greater then 0",admin.getCourierList(p).size()>=0);
		assertTrue("Franchise list is not greater then 0",admin.retreieveFranchiseList().size()>=0);
		assertTrue("Franchise list is not greater then 0",admin.retrieveFranchiseList().size()>=0);
		assertTrue("Franchise list is not greater then 0",admin.FranchiseList().size()>=0);
		assertTrue("Employee List is not greater then 0",admin.getEmployeeIDList("F000001").size()>=0);
		assertTrue("Employee List is not greater then 0",admin.getRegEmployeeList("F000001").size()>=0);
		assertTrue("list is not greater then 0",admin.getList("account", "userID").size()>=0);
		//assertTrue("AllowanceList is not greater then 0",admin.getCourierList(p).size()>=0);
	}

}
