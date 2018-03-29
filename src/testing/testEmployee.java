package testing;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;


import CMS.BLL.core.Employee;
import CMS.BLL.core.Loan;
import CMS.BLL.courier.RegisteredCourier;
import CMS.BLL.courier.UnRegisteredCourier;
import CMS.UIL.model.CourierModel;

public class testEmployee {

	Employee emp;
    @Before public void initialize() {
    	emp= new Employee();
    	emp.setAll( "Chandan", "Kumar", "Mithi", "03323881213", 
    			"1234539995148", "1990-11-26", "BS(CS)", "receptionist",80000);
    	
    	emp.setAll(emp.getEID(), emp.getFName(), 
    			emp.getLName(), emp.getAddress(), emp.getContactNumber(), 
    			emp.getCNIC(), emp.getDate_Of_Birth(), 
    			emp.getQualification(), emp.getDesignation(), emp.getBasicSalary());
    	emp.setStatus(true);
    	emp.setFID("F000001");
    }

	@Test
	public void testGetter() {
		assertEquals(emp.getFName(),"Chandan");
		assertEquals(emp.getLName(),"Kumar");
		assertEquals(emp.getAddress(),"Mithi");
		assertEquals(emp.getContactNumber(),"03323881213");
		assertEquals(emp.getCNIC(),"1234539995148");
		assertEquals(emp.getDate_Of_Birth(),"1990-11-26");
		assertEquals(emp.getQualification(),"BS(CS)");
		assertEquals(emp.getDesignation(),"receptionist");
		assertEquals(emp.getStatus(),true);
		assertEquals(emp.getBasicSalary()+"",""+80000.0);
		assertEquals(emp.getFID(),"F000001");		
		Calendar calendar = Calendar.getInstance();
		java.util.Date currentDate = calendar.getTime();
		java.sql.Date date = new java.sql.Date(currentDate.getTime());
		emp.setJoiningDate(date);
		assertEquals(emp.getJoiningDate(),date);
	}
	@Test
	public void testToString() {
//		System.out.println(emp.insertValue());
//		assertEquals(emp.insertValue()
//				,"('"+emp.getEID()+"', 'Chandan', 'Kumar', 'Mithi', '03323881213', '1234539995148', '1990-11-26', 'receptionist', 'BS(CS)', '2018-03-23', 80000.0,'F000001',1)");

		assertEquals(emp.toString()
				,""+emp.getEID()+",Chandan', 'Kumar', 'Mithi', '03323881213', '1234539995148', '1990-11-26,receptionist,BS(CS),2018-03-23,80000.0,F000001");

	}
	@Test
	public void testRegCustCourier() {
		RegisteredCourier reg_courier =new RegisteredCourier();
		reg_courier.setAll("Chandan", "Mithi", "03323881213", 500, "Gift", 5, 
				"pending", "E000003", "C000002");
		
		reg_courier.setAll(reg_courier.getCID(), reg_courier.getRName(),reg_courier.getRAddress(),
				reg_courier.getRContactNumber(),  reg_courier.getType(), reg_courier.getWeight(),reg_courier.getPrice(),
				reg_courier.getRegisterBy(), reg_courier.getCustomerID());

		reg_courier.toString();
		reg_courier.getPrice();
		reg_courier.getRegDateTime();
		reg_courier.setAll(reg_courier.getCID(), reg_courier.getRName(),reg_courier.getRAddress(),
				reg_courier.getRContactNumber(),"2018-03-23", reg_courier.getPrice(), reg_courier.getType(), reg_courier.getWeight(),
				reg_courier.getStatus(),reg_courier.getRegisterBy(), reg_courier.getCustomerID());
		
		System.out.println(reg_courier.getRegDate());
		
		
		assertEquals(emp.addCourier(reg_courier),true);

		reg_courier.setAll(reg_courier.getCID(), reg_courier.getRName(),reg_courier.getRAddress(),
				reg_courier.getRContactNumber(),"2018-03-23", 1000.0, reg_courier.getType(), reg_courier.getWeight(),
				reg_courier.getStatus(),reg_courier.getRegisterBy(), reg_courier.getCustomerID());

		assertTrue(emp.updateCourier(reg_courier)>=1);
		
		assertEquals(emp.getRegCourier(reg_courier.getCID()).getCID(),reg_courier.getCID());
		
		CourierModel reg_courier_model = new CourierModel(reg_courier.getCID(), reg_courier.getRName(),reg_courier.getRAddress(),
				reg_courier.getRContactNumber(),"2018-03-23", "1000.0","t", "String w", "String s", "String register",
				"String sn", "String sa", "String scontact", "String scnic");
		emp.CancelCourier(reg_courier_model);
		

		
	}
	@Test
	public void testUnRegCustCourier() {
		
		UnRegisteredCourier unreg_courier =new UnRegisteredCourier();

		
		unreg_courier.setAll("Chandan", "Mithi", "03323881213",new Date() ,500.0, "Gift", 5.0, 
				"pending", "E000003","Nilesh", "Kumar","Isb","", "");
		
		
		
		assertEquals(emp.addCourier(unreg_courier),true);
		unreg_courier.setRegDate();
		
		
		unreg_courier.setAll(unreg_courier.getCID(),"Chandan","Mithi", "03323881213",unreg_courier.getRegDate() ,500.0, "Gift", 5.0, 
				"pending", "E000003","Nilesh", "Kumar","Isb","", "");
		
		unreg_courier.setAll(unreg_courier.getCID(),"Teerath", "Mithi", "03323881213","Nilesh", "Kumar","Isb","", ""
				,500.0, "Gift", 5.0, "E000003");

		assertTrue(emp.updateCourier(unreg_courier)>=1);

		assertEquals(emp.getUnRegCourier(unreg_courier.getCID()).getCID(),unreg_courier.getCID());

		
	}
	@Test
	public void testReturnList() {
	    StringBuilder  p =  new StringBuilder();	
		assertTrue(emp.getPendingCourier().size()>=0);
		assertTrue(emp.getCourierList(p,"F000001").size()>=0);
		assertTrue(emp.getList("account", "userID").size()>=0);

		
	}
	
	@Test
	public void testLoan() {
		Loan loan=new Loan();
		loan.getNewID();
		loan.setAll(loan.getLID(), 20000.0, "For treatment.");
		loan.setDescription("For school Fees");
		loan.setAmount(10000.0);
		assertEquals(loan.getDescription(),"For school Fees");
		assertEquals(loan.getAmount()+"",""+10000.0);
		assertEquals(emp.requestLoan(loan),true);
	}
	

}
