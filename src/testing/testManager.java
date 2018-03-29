package testing;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import CMS.BLL.core.Account;
import CMS.BLL.core.Customer;
import CMS.BLL.core.Employee;
import CMS.BLL.core.Manager;
import CMS.UIL.model.CustomerModel;
import CMS.UIL.model.EmployeeModel;

public class testManager {
	Manager manag; 
	@Before public void initialize() {

		manag =new Manager();
		//adding manager
		manag.setAll("Ali", "Sajid", "G-10,Islamabad", "03331234576", "1234567891234", "1995-11-26", 70000, "BS(CS)", "F000001");
	}
	@Test
	public void testEmployee() {
    	Employee emp= new Employee();
    	emp.setAll( "Chandan", "Kumar", "Mithi", "03323881213", 
    			"1234539995148", "1990-11-26", "BS(CS)", "receptionist",80000);
    	assertTrue(manag.addEmployee(emp));
    	
    	emp.setAll(emp.getEID() ,"Teerath", "Kumar", "Mithi", "03323881213", 
    			"1234539995148", "1990-11-26", "BS(CS)", "receptionist",80000);

    	assertTrue(manag.updateEmployee(emp)>=0);
    	EmployeeModel empM = new EmployeeModel(emp.getEID(),"Nilesh", "Kumar", "Mithi", "03323881213", 
    			"1234539995148", "1990-11-26","receptionist" , "BS(CS)","2018-01-01","80000", emp.getFID());
    	assertTrue(manag.updateEmployee(empM)>=0);    	
    	assertTrue(manag.fireEmployee(emp.getEID()));
    	
    	

	}
	@Test
	public void testCustomer() {
		Customer c= new Customer();
		c.setAll("Chandan", "Kumar", "G-10/Islamabad", "03323881213", "4430239991233", "FAST-NU");
		c.setJoiningDate("2018-01-01");
		assertTrue(manag.addCustomer(c));
		c.setAll("Teerath", "Kumar", "G-10/Islamabad", "03323881213", "4430239991233", "FAST-NU");
		assertTrue(manag.updateCutomer(c)>=0);
		
		assertTrue(manag.deleteCustomer(new CustomerModel(c.getCID(),"Chandan", "Kumar", "G-10/Islamabad", "0332-3881213", "44302-3999123-3",c.getJoiningDate() ,"FAST-NU"))>=0);

	}
	@Test
	public void testAccount() {
		Account acc= new Account();
		Random rand = new Random();

		int  n = rand.nextInt(5000) + 1000;
		acc.setAll("Z0"+n, "thar");
		
		assertTrue(manag.addAccount(acc));
		
		acc.setAll("Z0"+n, "No");
		assertTrue(manag.updateAccount(acc));

	}
	

}
