
package com.infotel.gg.unittest.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.infotel.gg.dao.jdbc.RegionDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.City;
import com.infotel.gg.model.Customer;
import com.infotel.gg.model.Region;

import DBUnit.DBUtils;


public class RegionTest {
	
	Region r;
	RegionDAO rd = new RegionDAO();

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
		assertNotNull("la region n'est pas nulle readOk",rd.read(1));
	}
	
	@Test
	public void readOk2() {
		assertNotNull("la region n'est pas nulle readOk2",rd.read(2));
	}
	
	@Test
	public void readKo() {
		assertNull("la region est nulle readKo",rd.read(null));
	}
	
	@Test
	public void readKo2() {
		assertNull("la region est nulle readKo2",rd.read(5699965));
	}
	
	@Test
	public void CreateOk() throws DAOException, ModelException {
		r = new Region(141, "RegionFactice");
		rd.create(r);
		assertNotNull("la region n'est pas nulle CreateOk", rd.read(r.getId()));
	}
	
	@Test
	public void CreateOk2() throws DAOException, ModelException {
		r = new Region(142, "AutreRegionFactice");
		rd.create(r);
		assertNotNull("la region n'est pas nulle CreateOk2", rd.read(r.getId()));
	}
	
	
	
	@Test(expected=DAOException.class)
	public void CreateKo2() throws DAOException, ModelException {
		r = new Region(144, "AgainFactice");
		rd.create(r);
		rd.create(r);
	}
	
	@Test
	public void deleteOk() throws DAOException, ModelException {	
		r = new Region(1, "Ile-de-France");		
		rd.delete(r);		
		assertNull("la region n'est plus présent dans la base", rd.read(r.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void deleteKo() throws DAOException, ModelException {		
		r = new Region(6, "regionfake");		
		rd.delete(r);				
	}
	
	
	@Test
	public void deleteOk2() throws DAOException, ModelException {		
		rd.deleteById(3);	
		assertNull("la region n'est plus présent dans la base", rd.read(3));
	}
	
	
	@Test(expected=DAOException.class)
	public void deleteKo2() throws DAOException, ModelException {
	rd.deleteById(7);		
	}
	
	

}
