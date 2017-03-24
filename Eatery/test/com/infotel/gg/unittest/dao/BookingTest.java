package com.infotel.gg.unittest.dao;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
	Calendar calendar;

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
		calendar = new GregorianCalendar(2013,10,28);
	}

	@After
	public void tearDown() throws Exception {
		b = null;
		calendar = null;
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
	
	@Test
	public void createOk() throws DAOException, ModelException {
//		e = new Eatery(1, "Brasserie du Louvre", "blablabla", "Denis Bellon");
//		c = new Customer("Alexa737ndra", "Per325russet", "Mme", "24152163", "alex.perru@gmail.com", "sfgsh3783783fgseg");
		
		b= new Booking(2, calendar, 10);
		bd.create(b);
		assertNotNull("le customer n'est pas nul CreateOk", bd.read(b.getId()));
	}
	
	@Test
	public void createOk2() throws DAOException, ModelException {
		b= new Booking(47, calendar, 102);
		bd.create(b);
		assertNotNull("le customer n'est pas nul CreateOk",  bd.read(b.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void createKo2() throws  DAOException, ModelException {
		b= new Booking(42, calendar, 10);
		bd.create(b);
		assertNull("le customer n'est pas nul CreateOk",  bd.read(b.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void createKo() throws DAOException {
		
		b= new Booking(1, calendar, 10);
		
		bd.create(b);
		bd.create(b);
	}
	
	@Test
	public void deleteOk() throws DAOException, ModelException {
		
		b= new Booking(43, calendar, 10);
		
		bd.delete(b);
		
		assertNull("le cutsomer n'est plus présent dans la base", bd.read(b.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void deleteKo() throws DAOException, ModelException {
		
		b= new Booking(783783, calendar, 10);
		
		bd.delete(b);
		
		
	}
	@Test
	public void deleteOk2() throws DAOException, ModelException {
		

		
		bd.deleteById(1);
		
		assertNull("le cutsomer n'est plus présent dans la base", bd.read(1));
	}
	
	@Test(expected=DAOException.class)
	public void deleteKo2() throws DAOException, ModelException {
		
	
		
		bd.deleteById(54873);
		
		
	}
	

}
