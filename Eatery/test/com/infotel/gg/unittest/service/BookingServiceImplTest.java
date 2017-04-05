package com.infotel.gg.unittest.service;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.hibernate.query.Query;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infotel.gg.dao.BookingDAO;
import com.infotel.gg.dao.CustomerDAO;
import com.infotel.gg.dao.EateryDAO;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.hibernate.BookingDAOHbn;
import com.infotel.gg.hibernate.DAOHbn;
import com.infotel.gg.model.Booking;
import com.infotel.gg.model.Customer;
import com.infotel.gg.model.Eatery;
import com.infotel.gg.service.BookingService;

import DBUnit.DBUtils;

public class BookingServiceImplTest {
	static BookingService bookservice;
	Booking booking;
	Customer customer;
	Eatery eatery;
	static EateryDAO edao;
	static CustomerDAO custdao;
	Calendar calendar;
	static BookingDAO bookdao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DBUtils.startDB();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-test.xml");
		bookservice = ctx.getBean(BookingService.class);
		custdao = ctx.getBean(CustomerDAO.class);
		bookdao = ctx.getBean(BookingDAO.class);
		edao = ctx.getBean(EateryDAO.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
//		DBUtils.cleanDB();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void saveBookingOk() throws GGourmandException {
		customer = custdao.read("jefr");
		eatery = edao.read(6);
		calendar = new GregorianCalendar(2013,10,28);
		booking = new Booking(2, calendar, 3, eatery, customer);
		bookservice.saveBooking(booking);
		
		Booking newBooking = new Booking();
		newBooking = bookdao.read(booking.getId());
		
		assertNotNull(newBooking);
		assertEquals(newBooking.getNbOfCustomer(), booking.getNbOfCustomer());
		assertEquals(newBooking.getEatery().getName(), eatery.getName());
		assertEquals(newBooking.getCustomer().getLastName(), customer.getLastName());
		assertEquals(newBooking.getCustomer().getPhone(), customer.getPhone());
	}
	
	@Test
	public void findBookingByIdOk() throws GGourmandException {
		booking = bookservice.findBookingById(42);
		assertNotNull(booking);
		assertEquals(booking.getNbOfCustomer(), 10);
	}

}
