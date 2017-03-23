package com.infotel.gg.unittest.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.infotel.gg.booking.Booking;
import com.infotel.gg.dao.jdbc.BookingDAO;
import com.infotel.gg.exception.ModelException;

import DBUnit.DBUtils;

public class BookingTest {
	Booking b;
	BookingDAO bd = new BookingDAO(); 

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
		b = null;
	}

//	@Test
//	public void ReadOk() throws ModelException {
//		assertNotNull("le booking n'est pas nul ReadOk", bd.read(1));
//	}
//	
	
	@Test
	public void ReadKo() throws ModelException {
		assertNull("le booking est nul ReadKo",  bd.read(null));
	}
	@Test
	public void ReadKo2() throws ModelException {
		assertNull("le booking est nul ReadKo2", bd.read(9999));
	}
	

}
