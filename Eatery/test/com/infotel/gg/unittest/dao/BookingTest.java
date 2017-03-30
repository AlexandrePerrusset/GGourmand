package com.infotel.gg.unittest.dao;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.infotel.gg.dao.BookingDAO;
import com.infotel.gg.dao.CustomerDAO;
import com.infotel.gg.dao.EateryDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.hibernate.BookingDAOHbn;
import com.infotel.gg.hibernate.CustomerDAOHbn;
import com.infotel.gg.hibernate.EateryDAOHbn;
import com.infotel.gg.model.Booking;
import com.infotel.gg.model.Customer;
import com.infotel.gg.model.Eatery;

import DBUnit.DBUtils;

public class BookingTest {
	Booking b;
	BookingDAO bd = new BookingDAOHbn(); 
	EateryDAO ed = new EateryDAOHbn(); 
	CustomerDAO cd = new CustomerDAOHbn(); 
	Eatery e;
	Customer c;
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
		calendar = new GregorianCalendar(2013,10,28);
	}

	@After
	public void tearDown() throws Exception {
		b = null;
		calendar = null;
		e =null;
		c = null;
	}

	@Test
	public void ReadOk(){
		assertNotNull("le booking n'est pas nul ReadOk", bd.read(1));
	}
	
	
	@Test(expected=DAOException.class)
	public void ReadKo(){
		assertNull("le booking est nul ReadKo",  bd.read(null));
	}
	@Test
	public void ReadKo2(){
		assertNull("le booking est nul ReadKo2", bd.read(9999));
	}
	
	@Test
	public void createOk() throws DAOException, ModelException {
		
		e = ed.read(2);
		c = cd.read("alex.perru@gmail.com");
		b= new Booking(2, calendar, 10, e, c);
		bd.create(b);
		assertNotNull("le booking n'est pas nul CreateOk", bd.read(b.getId()));
	}
	
	@Test
	public void createOk2() throws DAOException, ModelException {
		e = ed.read(22);
		c = cd.read("plop@gmail.com");
		b= new Booking(47, calendar, 102, e, c);
		bd.create(b);
		assertNotNull("le booking n'est pas nul CreateOk",  bd.read(b.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void createKo2() throws  DAOException, ModelException {
		b= new Booking(42, calendar, 10);
		bd.create(b);
		assertNull("le booking n'est pas nul CreateOk",  bd.read(b.getId()));
	}
	
	
	@Test
	public void deleteOk() throws DAOException, ModelException {
		e = ed.read(2);
		c = cd.read("alex.perru@gmail.com");
		
		b= new Booking(43, calendar, 10);
		
		bd.delete(b);
		
		assertNull("le booking n'est plus pr�sent dans la base", bd.read(b.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void deleteKo() throws DAOException, ModelException {
		
		b= new Booking(783783, calendar, 10);
		
		bd.delete(b);
		
		
	}
	
	

}
