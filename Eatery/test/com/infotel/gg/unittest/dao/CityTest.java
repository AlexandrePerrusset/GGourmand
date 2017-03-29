package com.infotel.gg.unittest.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.infotel.gg.dao.CityDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.hibernate.CityDAOHbn;
import com.infotel.gg.model.City;
import com.infotel.gg.model.Country;
import com.infotel.gg.model.Region;

import DBUnit.DBUtils;

public class CityTest {
	City c;
	CityDAO cd = new CityDAOHbn();
	Country country;
	Region reg;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DBUtils.startDB();
	}

	@Before
	public void setUp() throws Exception {
		country = new Country(3,"CountryCreateOk");
		reg = new Region(11,"RegionCreateOk", country);
	}

	@After
	public void tearDown() throws Exception {
		c = null;
		country = null;
		reg = null;
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
//		DBUtils.cleanDB();
	}

	@Test
	public void readOk() {
		assertNotNull("la ville n'est pas nulle readOk",cd.read(1));
	}
	
	@Test
	public void readOk2() {
		assertNotNull("la ville n'est pas nulle readOk2",cd.read(2));
	}
	
	@Test(expected=DAOException.class)
	public void readKo() {
		assertNull("la ville est nulle readKo",cd.read(null));
	}
	
	@Test(expected=DAOException.class)
	public void readKo2() {
		assertNull("la ville est nulle readKo2",cd.read(5699));
	}
}
