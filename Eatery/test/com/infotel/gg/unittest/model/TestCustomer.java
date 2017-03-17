/**
 * 
 */
package com.infotel.gg.unittest.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infotel.gg.bookingreport.EateryManager;
import com.infotel.gg.customer.Customer;

/**
 * @author formation
 *
 */
public class TestCustomer {

		Customer cus;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		cus=null;
	}

	//Test Customer
			@Test
			public void TestCustomer() {
			cus = new Customer("Martin", "Sarah", "Mrs", "123456789", "sarah", "sarah");
				assertNotNull(cus);
				assertEquals(cus.getFirstName(), "Martin");	
				assertEquals(cus.getLastName(), "Sarah");
				assertEquals(cus.getTitle(), "Mrs");
				assertEquals(cus.getPhone(), "123456789");	
				assertEquals(cus.getUsername(), "sarah");
				assertEquals(cus.getPassword(), "sarah");
			}	

}
