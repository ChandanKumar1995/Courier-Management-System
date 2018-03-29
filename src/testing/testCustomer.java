package testing;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import CMS.BLL.core.Customer;

public class testCustomer {

	@Test
	public void testGetFuction() {
		Customer c= new Customer();
		c.setAll("Chandan", "Kumar", "G-10/Islamabad", "03323881213", "4430239991233", "FAST-NU");

		assertEquals("Fname is not equal","Chandan", c.getFName() );
        assertEquals( "Lname is not equal","Kumar", c.getLName());
        assertEquals( "Address is not equal","G-10/Islamabad", c.getAddress());
		assertEquals("Contact number is not equal","03323881213", c.getContactNumber());
        assertEquals("CNIC is not equal","4430239991233", c.getCNIC());
        assertEquals("Organization is not equal","FAST-NU", c.getOrganization());

	}
	
	@Test
	public void test2() {
		
		
		Customer c= new Customer();
		
		// Testing setAll Function of the customer
		c.setAll("C000001","Chandan", "Kumar", "G-10/Islamabad", "03323881213", "4430239991233", "FAST-NU");
		c.setStatus(true);
		
		Calendar calendar = Calendar.getInstance();
		java.util.Date currentDate = calendar.getTime();
		java.sql.Date date = new java.sql.Date(currentDate.getTime());
		String dataOfJoining = date.toString();

		
		assertEquals("CustomerID  is not equal","C000001", c.getCID() );	
		assertEquals("Fname is not equal","Chandan", c.getFName() );
        assertEquals( "Lname is not equal","Kumar", c.getLName());
        assertEquals( "Address is not equal","G-10/Islamabad", c.getAddress());
		assertEquals("Contact number is not equal","03323881213", c.getContactNumber());
        assertEquals("CNIC is not equal","4430239991233", c.getCNIC());
        assertEquals("Organization is not equal","FAST-NU", c.getOrganization());
        assertEquals("Joining Date is not equal",dataOfJoining, c.getJoiningDate());
        assertEquals("Status is not equal",true, c.getStatus());
        

		// Testing initAll Function of the customer
		c.initAll("C000001","Chandan", "Kumar", "G-10/Islamabad", "0332-3881213", "44302-3999123-3", "FAST-NU");
		c.setJoiningDate(dataOfJoining);
		assertEquals("CustomerID  is not equal","C000001", c.getCID() );	
		assertEquals("Fname is not equal","Chandan", c.getFName() );
        assertEquals( "Lname is not equal","Kumar", c.getLName());
        assertEquals( "Address is not equal","G-10/Islamabad", c.getAddress());
		assertEquals("Contact number is not equal","0332-3881213", c.getContactNumber());
        assertEquals("CNIC is not equal","44302-3999123-3", c.getCNIC());
        assertEquals("Organization is not equal","FAST-NU", c.getOrganization());
        assertEquals("Joining Date is not equal",dataOfJoining, c.getJoiningDate());

        System.out.print(c.insertValue());
		// Testing insertValue Function of the customer        
        assertEquals("output is not equal","('C000001', 'Chandan', 'Kumar', 'G-10/Islamabad', '0332-3881213', '44302-3999123-3', '"+dataOfJoining+"', 'FAST-NU',1)", c.insertValue());
        
		// Testing toString Function of the customer

        assertEquals("output is not equal","C000001,Chandan', 'Kumar', 'G-10/Islamabad', '0332-3881213', '44302-3999123-3', 'null,FAST-NU", c.toString());

	}


}
