
package com.infotel.gg.unittest.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.infotel.gg.dao.jdbc.ReviewDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.PracticalInformation;
import com.infotel.gg.model.Review;

import DBUnit.DBUtils;


public class ReviewTest {
	Review r;
	ReviewDAO rd = new ReviewDAO();

	
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
		r=null;
	}

	@Test
	public void readOk() {
		assertNotNull("Review n'est pas nulle readOk",rd.read(9));
	}
	
	@Test
	public void readOk2() {
		assertNotNull("Review n'est pas nulle readOk2",rd.read(2));
	}
	
	@Test
	public void readKo() {
		assertNull("Review est nulle readKo",rd.read(null));
	}
	
	@Test
	public void readKo2() {
		assertNull("Review est nulle readKo2",rd.read(5699965));
	}
	
	@Test
	public void CreateOk() throws DAOException, ModelException {
		r = new Review(1, 10 ,"comment");
		rd.create(r);
		assertNotNull("Review n'est pas nulle CreateOk", rd.read(r.getId()));
	}
	
	@Test
	public void CreateOk2() throws DAOException, ModelException {
		r = new Review(2, 12, "comment2");
		rd.create(r);
		assertNotNull("Review n'est pas nulle CreateOk2", rd.read(r.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void createKo() throws  DAOException, ModelException {
		r = new Review(1, 13, null);
		rd.create(r);
		assertNull("Review n'est pas nul CreateOk", rd.read(r.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void CreateKo2() throws DAOException, ModelException {
		r = new Review(3, 12, "comment3");
		rd.create(r);
		rd.create(r);
	}
	
	@Test
	public void deleteOk() throws DAOException, ModelException {	
		r = new Review(4, 15,"comment4");		
		rd.delete(r);		
		assertNull("Review n'est plus présent dans la base", rd.read(r.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void deleteKo() throws DAOException, ModelException {		
		r = new Review(5, 16,"comment5");		
		rd.delete(r);				
	}
	
	
	@Test
	public void deleteOk2() throws DAOException, ModelException {		
		rd.deleteById(6);	
		assertNull("Review n'est plus présent dans la base", rd.read(6));
	}
	
	
	@Test(expected=DAOException.class)
	public void deleteKo2() throws DAOException, ModelException {
	rd.deleteById(50);		
	}

}



