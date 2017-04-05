/**
 * 
 */
package com.infotel.gg.unittest.dao;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.infotel.gg.dao.BookingDAO;
import com.infotel.gg.dao.BookingReportDAO;
import com.infotel.gg.dao.EateryManagerDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.hibernate.BookingDAOHbn;
import com.infotel.gg.hibernate.BookingReportDAOHbn;
import com.infotel.gg.hibernate.EateryManagerDAOHbn;
import com.infotel.gg.model.Booking;
import com.infotel.gg.model.BookingReport;
import com.infotel.gg.model.EateryManager;

import DBUnit.DBUtils;


@Ignore public class BookingReportTest {
	BookingReport br;
	BookingReportDAO brd = new BookingReportDAOHbn();
	Calendar calendar;
	EateryManager em;
	EateryManagerDAO emd = new EateryManagerDAOHbn();
	Booking b;
	BookingDAO bd = new BookingDAOHbn();

	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DBUtils.startDB();
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//DBUtils.cleanDB();
	}

	
	@Before
	public void setUp() throws Exception {
		calendar = new GregorianCalendar(2013,10,28);
	}

	
	@After
	public void tearDown() throws Exception {
		br=null;
		calendar = null;
		em=null;
		b=null;
	}

	@Test
	public void readOk(){
		assertNotNull("le BookingReport n'est pas nul ReadOk", brd.read(1));
	}
	
	@Test
	public void readOk2(){
		assertNotNull("le BookingReport n'est pas nul ReadOk2", brd.read(2));	
	}
	
	@Test(expected=DAOException.class)
	public void readKo() {
		brd.read(null);
	}
	
	@Test
	public void readKo2(){
		assertNull("le BookingReport est nul ReadKo2", brd.read(657434));
	}
	

	
	@Test
	public void createOk() throws DAOException {
		b = bd.read(1);
		em = emd.read("raphi2@gmail.com");
		br = new BookingReport(45, calendar, true, "comment", 0.5, 0.5, em, b );
		brd.create(br);
		assertNotNull("le BookingReport n'est pas nul CreateOk", brd.read(br.getId()));
	}
	
	@Test
	public void createOk2() throws DAOException {
		b = bd.read(2);
		em = emd.read("raphi@gmail.com");
		br = new BookingReport(47, calendar, true, "comment1", 0.5, 0.5,em,b);
		brd.create(br);
		assertNotNull("le BookingReport n'est pas nul CreateOk", brd.read(br.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void createKo2() throws  DAOException {
		br = new BookingReport(45, calendar, true, null, 0.5, 0.5);
		brd.create(br);
		assertNull("le BookingReport n'est pas nul CreateOk", brd.read(br.getId()));
	}
	

	
	

		

	
	

	
	
	
	
	
	
}	
