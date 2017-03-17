/**
 * 
 */
package com.infotel.gg.unittest.model;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infotel.gg.bookingreport.BookingReport;
import com.infotel.gg.bookingreport.EateryManager;


public class TestBookingReport {
	
	BookingReport br;
	EateryManager em;

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
		br=null;
		em=null;
	}

	//Test BookingReport
		@Test
		public void TestBookingReport() {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.HOUR_OF_DAY, 0);
			br = new BookingReport(1, cal, true, "comment", 5.0, 5.0);
			assertNotNull(br);
			assertEquals(br.getId(), 1);
			assertEquals(br.getCalendar(), cal);
			assertEquals(br.isFulfilled(), true);
			assertEquals(br.getComment(), "comment");
			assertEquals(br.getDueAmount(), 5.0, 1e-15);
			assertEquals(br.getTakingAmount(), 5.0, 1e-15);		
		}
		
	//Test EateryManager
		@Test
		public void TestEateryManager() {
		em = new EateryManager("Martin", "Sarah", "sarah", "sarah");
			assertNotNull(em);
			assertEquals(em.getFirstName(), "Martin");	
			assertEquals(em.getLastName(), "Sarah");
			assertEquals(em.getUsername(), "sarah");	
			assertEquals(em.getPassword(), "sarah");	

		}	

}
