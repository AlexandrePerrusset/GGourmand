
package com.infotel.gg.unittest.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.infotel.gg.dao.CountryDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.hibernate.CountryDAOHbn;
import com.infotel.gg.model.Country;
import DBUnit.DBUtils;



@Ignore public class CountryTest {
	Country c ;
	CountryDAO cd = new CountryDAOHbn();

	
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
		c=null;
	}

	@Test
	public void readOk() {
		assertNotNull("le pays n'est pas nul readOk",cd.read(1));
	}
	
	
	
	@Test
	public void readKo() {
		assertNull("le pays est nul readKo",cd.read(5699965));
	}
	
	
	@Test(expected=DAOException.class)
	public void readKo2() {
		cd.read(null);
	}
	
	
	
	
	@Test
	public void CreateOk() throws DAOException, ModelException {
		c = new Country(2, "PaysFactice");
		cd.create(c);
		assertNotNull("le pays n'est pas nul CreateOk", cd.read(c.getId()));
	}
	

	@Test
	public void CreateOk2() throws DAOException, ModelException {
		c = new Country(51, "fefa");
		cd.create(c);
		assertNotNull("le pays n'est pas nul CreateOk2", cd.read(c.getId()));
	}
	
	
	

	

	
	
	
	
	
	
	
	

}



