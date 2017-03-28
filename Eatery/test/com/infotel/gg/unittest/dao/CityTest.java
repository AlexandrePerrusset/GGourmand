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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DBUtils.startDB();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		c = null;
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
	
	@Test
	public void readKo() {
		assertNull("la ville est nulle readKo",cd.read(null));
	}
	
	@Test
	public void readKo2() {
		assertNull("la ville est nulle readKo2",cd.read(5699965));
	}
	
	@Test
	public void CreateOk() throws DAOException, ModelException {
		Country country = new Country(3,"CountryCreateOk");
		Region reg = new Region(11,"RegionCreateOk");
		
		c = new City(141, "VilleFactice", "44444", true, reg, country);
		cd.create(c);
		assertNotNull("la ville n'est pas nulle CreateOk", cd.read(c.getId()));
	}
	
	@Test
	public void CreateOk2() throws DAOException, ModelException {
		Country country = new Country(2,"CountryCreateOk2");
		Region reg = new Region(10,"RegionCreateOk2");
		
		c = new City(100, "CityCreateOk2", "66666", true, reg, country);
		cd.create(c);
		assertNotNull("la ville n'est pas nulle CreateOk2", cd.read(c.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void CreateKo() throws DAOException, ModelException {
		c = new City(42, "FakeFake", "55555", false);
		cd.create(c);
		assertNull("la ville est nulle CreateKo", cd.read(c.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void CreateKo2() throws DAOException, ModelException {
		c = new City(242, null, "55555", false);
		cd.create(c);
		assertNull("la ville est nulle CreateKo2", cd.read(c.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void CreateKo3() throws DAOException, ModelException {
		c = new City(43, "AgainFactice", "66666", true);
		cd.create(c);
		cd.create(c);
	}
	
	@Test
	public void deleteOk() throws DAOException, ModelException {
		
		c= new City(178, "FakeCity", "55663", false);
		cd.delete(c);
		assertNull("la ville n'est plus présente en base de donnees deleteOk", cd.read(c.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void deleteKo() throws DAOException, ModelException {
		
		c= new City(200, "City", "55663", false);
		cd.delete(c);
		assertNull("la ville n'est plus présente en base de donnees deleteKo", cd.read(c.getId()));
	}
}
