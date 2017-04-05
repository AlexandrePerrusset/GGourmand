
package com.infotel.gg.unittest.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.infotel.gg.dao.BookingDAO;
import com.infotel.gg.dao.ReviewDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.hibernate.BookingDAOHbn;
import com.infotel.gg.hibernate.ReviewDAOHbn;
import com.infotel.gg.model.Booking;
import com.infotel.gg.model.Review;

import DBUnit.DBUtils;


@Ignore public class ReviewTest {
	Review r;
	ReviewDAO rd = new ReviewDAOHbn();
	Booking book;
	BookingDAO bd = new BookingDAOHbn();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DBUtils.startDB();
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
		r = null;
	}

	@Test
	public void readOk() {
		assertNotNull("Review n'est pas nulle readOk",rd.read(9));
	}
	
	@Test
	public void readOk2() {
		assertNotNull("Review n'est pas nulle readOk2",rd.read(4));
	}
	
	@Test(expected=DAOException.class)
	public void readKo() {
		assertNull("Review est nulle readKo",rd.read(null));
	}
	
	@Test
	public void readKo2() {
		assertNull("Review est nulle readKo2",rd.read(5696));
	}
	
	@Test
	public void CreateOk() throws DAOException, ModelException {
		book = bd.read(42);
		r = new Review(1, 10 ,"comment", book);
		rd.create(r);
		assertNotNull("Review n'est pas nulle CreateOk", rd.read(r.getId()));
	}
	
	@Test
	public void CreateOk2() throws DAOException, ModelException {
		book = bd.read(1);
		r = new Review(2, 12, "comment2", book);
		rd.create(r);
		assertNotNull("Review n'est pas nulle CreateOk2", rd.read(r.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void createKo() throws  DAOException, ModelException {
		r = new Review(1, 13, "comment4");
		rd.create(r);
		assertNull("Review existe deja createKo", rd.read(r.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void CreateKo2() throws DAOException, ModelException {
		r = new Review(3, 12, "comment3");
		rd.create(r);
		rd.create(r);
	}
	
	@Test
	public void deleteOk() throws DAOException, ModelException {	
		r = new Review(6, 15,"comment4");		
		rd.delete(r);		
		assertNull("Review n'est plus present dans la base", rd.read(r.getId()));
	}
	
	@Test
	public void updateOk() throws DAOException, ModelException {
		book = bd.read(1);
		r = new Review(4, 15, "updateOk", book);
		rd.update(r);
		assertNotNull("Review n'est pas nulle updateOk", rd.read(r.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void updateko() throws DAOException, ModelException {
		book = bd.read(1);
		r = new Review(10, 15, "updateKo", book);
		rd.update(r);
		assertNotNull("Review est nulle updateKo", rd.read(r.getId()));
	}
	
	@Test
	public void ListAll() {
		List<Review> reviews = rd.listAll();
		assertEquals(reviews.get(0).getId(), 4);
		assertEquals(reviews.get(1).getId(), 9);
	}
}



