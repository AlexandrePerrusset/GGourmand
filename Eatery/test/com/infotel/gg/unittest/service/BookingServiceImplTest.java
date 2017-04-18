package com.infotel.gg.unittest.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.infotel.gg.DTO.BookingDTO;
import com.infotel.gg.DTO.BookingReportDTO;
import com.infotel.gg.dao.BookingDAO;
import com.infotel.gg.dao.BookingReportDAO;
import com.infotel.gg.dao.CustomerDAO;
import com.infotel.gg.dao.EateryDAO;
import com.infotel.gg.dao.EateryManagerDAO;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.model.Booking;
import com.infotel.gg.model.BookingReport;
import com.infotel.gg.model.Customer;
import com.infotel.gg.model.Eatery;
import com.infotel.gg.model.EateryManager;
import com.infotel.gg.service.BookingService;

import DBUnit.DBUtils;

@EnableTransactionManagement
public class BookingServiceImplTest {
	static BookingService bookservice;
	Booking booking;
	Customer customer;
	Eatery eatery;
	static EateryDAO edao;
	static CustomerDAO custdao;
	Calendar calendar;
	static BookingDAO bookdao;
	BookingReport bookreport;
	EateryManager eatman;
	static EateryManagerDAO eatmandao;
	static BookingReportDAO bookingreportdao;
	List<BookingDTO> bookingDTOs;
	List<Booking> bookings;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DBUtils.startDB();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-test.xml");
		bookservice = ctx.getBean(BookingService.class);
		custdao = ctx.getBean(CustomerDAO.class);
		bookdao = ctx.getBean(BookingDAO.class);
		edao = ctx.getBean(EateryDAO.class);
		eatmandao = ctx.getBean(EateryManagerDAO.class);
		bookingreportdao = ctx.getBean(BookingReportDAO.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
//		DBUtils.cleanDB();
	}

	@Before
	public void setUp() throws Exception {
		calendar = new GregorianCalendar(2013,10,28);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void saveBookingOk() throws GGourmandException {
		
		BookingDTO bDTO = new BookingDTO();
		bDTO.setDateTime(calendar);
		bDTO.setCustomerId("jefr");
		bDTO.setEateryId(6);
		bDTO.setNumberOfPeople("3");
		bookservice.saveBooking(bDTO);
		
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
	
	@Test
	public void saveBookingReportOk() throws GGourmandException {
		
		BookingReportDTO brd = new BookingReportDTO();
		brd.setBookingId(42);
		brd.setComment("comment");
		brd.setDate(calendar);
		brd.setDueAmount(0.5);
		brd.setTakingAmount(0.6);
		brd.seteMId("raphi2@gmail.com");
		bookservice.saveBookingReport(brd);
		
		BookingReport newbookreport = new BookingReport();
		newbookreport = bookingreportdao.read(bookreport.getId());
		
		assertNotNull(newbookreport);
		assertEquals(newbookreport.getComment(), bookreport.getComment());
		assertEquals(newbookreport.getDate(), bookreport.getDate());
	}
	
	@Test
	public void findBookingsByCustomerOk() throws GGourmandException {
		bookingDTOs = new ArrayList<BookingDTO>();
		bookingDTOs = bookservice.findBookingsByCustomer("alex.perru@gmail.com");
		
		for (BookingDTO bookingDTO : bookingDTOs) {
			assertNotNull(bookingDTO);
		}
	}
	
	@Test
	public void findBookingsByEateryOk() throws GGourmandException {
		bookingDTOs = new ArrayList<BookingDTO>();
		bookingDTOs = bookservice.findBookingsByEatery(1);

		assertEquals(bookingDTOs.size(), 0);
	}
	
	@Test
	public void findBookingsByEateryOk2() throws GGourmandException {
		bookingDTOs = new ArrayList<BookingDTO>();
		bookingDTOs = bookservice.findBookingsByEatery(11);
	
		
		for (BookingDTO bookingDTO : bookingDTOs) {
			assertNotNull(bookingDTO);
		}
	}
	
	@Test
	public void findBookingsByEateryWithoutReportOk() throws GGourmandException {
		bookingDTOs = new ArrayList<BookingDTO>();
		bookings = bookdao.findByEateryIdWithoutReport(11);
		assertEquals(bookings.size(), 2);
	}

}
