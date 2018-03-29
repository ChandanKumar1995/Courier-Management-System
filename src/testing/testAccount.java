package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import CMS.BLL.core.Account;

public class testAccount {
	Account acc;
    @Before public void initialize() {
       acc= new Account();
	   acc.setAll("A000001", "thar");
    }
	@Test
	public void test1() {


		assertEquals("CustomerID  is not equal","A000001", acc.getUserID());
		assertEquals("CustomerID  is not equal","thar", acc.getPassword());	
	}
	
	@Test
	public void test2() {
		

		assertEquals("Account  is not verified", "Chandan,Kumar,PO Box Kaloi,03323881213,3520288854061,2001-01-01",""+acc.validateAccount("A000001", "thar"));
		assertEquals("Account  is not verified", "E000001,Akash', 'Kumar', 'Diplo', '03323881213', '3520288854061', '1990-11-26,receptionist,BS(CS),2010-11-26,15000.0,F000001",""+acc.validateAccount("E000001", "E000001"));
		assertEquals("Account  is not verified", "Chandan,Kumar,Tharparkar,03323881213,3520288854061,1995-11-26,M000001,BBA,2016-11-26,85000.0,F000001",""+acc.validateAccount("M000001", "M000001"));


		assertEquals("Account  is verified but no person record is found", null,acc.validateAccount("A000044", "A000044"));
		assertEquals("Account  is verified but no person record is found", null,acc.validateAccount("E011111", "E011111"));
		//assertEquals("Account  is verified but no person record is found", null,acc.validateAccount("M000006", "M000006"));
		assertEquals("Account  is verified but no person record is found", null,acc.validateAccount("S000006", "S000006"));
		
		assertEquals("Sql Syntax Error", 1064,acc.validateAccount("'S000006'", "S000006"));

		assertEquals("Account  is not verified", null,acc.validateAccount("Z000001", "tha"));



	}
	@Test
	public void test3(){

		assertEquals("Error in output", "A000001,thar", acc.toString());
		assertEquals("Error in output", "('A000001','thar')", acc.insertValues());		
	}

}
