package com.infotel.gg.unittest.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.infotel.gg.dao.jdbc.CityDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.City;
import com.infotel.gg.model.Customer;

import DBUnit.DBUtils;

public class CityTest {
	City c;
	CityDAO cd = new CityDAO();

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
		c = new City(141, "VilleFactice", "44444", true);
		cd.create(c);
		assertNotNull("la ville n'est pas nulle CreateOk", cd.read(c.getId()));
	}
	
	@Test
	public void CreateOk2() throws DAOException, ModelException {
		c = new City(142, "AutreVilleFactice", "55555", false);
		cd.create(c);
		assertNotNull("la ville n'est pas nulle CreateOk2", cd.read(c.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void CreateKo() throws DAOException, ModelException {
		c = new City(42, "FakeFake", "55555", false);
		cd.create(c);
		assertNull("la ville est nulle CreateOk2", cd.read(c.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void CreateKo2() throws DAOException, ModelException {
		c = new City(242, null, "55555", false);
		cd.create(c);
		assertNull("la ville est nulle CreateOk2", cd.read(c.getId()));
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
		assertNull("la ville n'est plus présente en base de donnees", cd.read(c.getId()));
	}
	
	@Test
	public void deleteOk2() throws DAOException, ModelException {
		
		c= new City(179, "FakeCityCity", "55663", false);
		cd.deleteById(c.getId());
		assertNull("la ville n'est plus présente en base de donnees", cd.read(c.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void deleteKo() throws DAOException, ModelException {
		
		c= new City(200, "City", "55663", false);
		cd.delete(c);
		assertNull("la ville n'est plus présente en base de donnees", cd.read(c.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void deleteKo2() throws DAOException, ModelException {
		cd.deleteById(250);
		assertNull("la ville n'est plus présente en base de donnees", cd.read(c.getId()));
	}
}
