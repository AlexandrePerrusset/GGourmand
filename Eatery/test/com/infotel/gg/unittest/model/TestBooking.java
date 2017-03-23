package com.infotel.gg.unittest.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infotel.gg.model.Booking;
import com.infotel.gg.model.Review;

public class TestBooking {
	Booking booking;
	Calendar cal;
	Review rev;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		booking = null;
		cal = null;
		rev = null;
	}

	// Tests constructeur Booking
	@Test
	public void constructeurBookingOK() {
		booking = new Booking(1, cal = Calendar.getInstance(), 2);
		assertNotNull(booking);
		assertEquals(booking.getId(), 1);
		assertEquals(booking.getDateTime(), cal);
		assertEquals(booking.getNbOfCustomer(), 2);
	}
	
	@Test
	public void constructeurReviewOK() {
		rev = new Review(2, 9, "xdgxd");
		assertNotNull(rev);
		assertEquals(rev.getId(), 2);
		assertEquals(rev.getRating(),9);
		assertEquals(rev.getComment(),"xdgxd");
	}
}
