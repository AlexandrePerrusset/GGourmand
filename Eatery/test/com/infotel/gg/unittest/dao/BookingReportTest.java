/**
 * 
 */
package com.infotel.gg.unittest.dao;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.infotel.gg.dao.BookingReportDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.hibernate.BookingReportDAOHbn;
import com.infotel.gg.model.BookingReport;
import DBUnit.DBUtils;


public class BookingReportTest {
	BookingReport br;
	BookingReportDAO brd = new BookingReportDAOHbn();
	Calendar calendar;

	
	
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
	}

	
	@After
	public void tearDown() throws Exception {
		br=null;
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
		br = new BookingReport(45, calendar, true, "comment", 0.5, 0.5);
		brd.create(br);
		assertNotNull("le BookingReport n'est pas nul CreateOk", brd.read(br.getId()));
	}
	
	@Test
	public void createOk2() throws DAOException {
		br = new BookingReport(47, calendar, true, "comment1", 0.5, 0.5);
		brd.create(br);
		assertNotNull("le BookingReport n'est pas nul CreateOk", brd.read(br.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void createKo2() throws  DAOException {
		br = new BookingReport(45, calendar, true, null, 0.5, 0.5);
		brd.create(br);
		assertNull("le BookingReport n'est pas nul CreateOk", brd.read(br.getId()));
	}
	

	@Test
	public void deleteOk() throws DAOException {	
		br = new BookingReport(48, calendar, true, "comment3", 0.7, 0.7);
		brd.delete(br);	
		assertNull("le BookingReport n'est plus pr�sent dans la base", brd.read(br.getId()));
	}
	
	
	@Test(expected=DAOException.class)
	public void deleteKo() throws DAOException {
		br = new BookingReport(49, calendar, true, "comment3", 0.7, 0.7);
		brd.delete(br);
		
		
	}
	

		

	
	

	
	
	
	
	
	
}	
