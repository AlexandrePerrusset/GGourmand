package com.infotel.gg.unittest.dao;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.infotel.gg.dao.jdbc.BookingDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.Booking;
import com.infotel.gg.model.Customer;
import com.infotel.gg.model.Eatery;

import DBUnit.DBUtils;

public class BookingTest {
	Booking b;
	BookingDAO bd = new BookingDAO(); 
	Eatery e;
	Customer c;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DBUtils.startDB();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		DBUtils.cleanDB();
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		b = null;
	}

	@Test
	public void ReadOk(){
		assertNotNull("le booking n'est pas nul ReadOk", bd.read(1));
	}
	
	
	@Test
	public void ReadKo(){
		assertNull("le booking est nul ReadKo",  bd.read(null));
	}
	@Test
	public void ReadKo2(){
		assertNull("le booking est nul ReadKo2", bd.read(9999));
	}
	
//	@Test
//	public void createOk() throws DAOException, ModelException {
//		e = new Eatery(1, "Brasserie du Louvre", "blablabla", "Denis Bellon");
//		c = new Customer("Alexa737ndra", "Per325russet", "Mme", "24152163", "alex.perru@gmail.com", "sfgsh3783783fgseg");
//		bd.create(new Booking(2, new Calendar()., e, c));
//		assertNotNull("le customer n'est pas nul CreateOk", cd.read(c.getEmail()));
//	}
//	
//	@Test
//	public void createOk2() throws DAOException, ModelException {
//		c = new Customer("Alexandre", "Perrusset", "Mr", "24152163", "alex@gmail.com", "sfgshfgseg");
//		cd.create(c);
//		assertNotNull("le customer n'est pas nul CreateOk", cd.read(c.getEmail()));
//	}
//	
//	@Test(expected=DAOException.class)
//	public void createKo2() throws  DAOException, ModelException {
//		c = new Customer("Alexandre", "Perrusset", "Mr", "24152163", null, "sfgshfgseg");
//		cd.create(c);
//		assertNull("le customer n'est pas nul CreateOk", cd.read(c.getEmail()));
//	}
//	
//	@Test(expected=DAOException.class)
//	public void createKo() throws DAOException {
//		
//		c = new Customer("Alexandre", "Perrusset", "Mr", "24152163", "alex.ru@gmail.com", "sfgshfgseg");
//		
//		cd.create(c);
//		cd.create(c);
//	}
//	

}
