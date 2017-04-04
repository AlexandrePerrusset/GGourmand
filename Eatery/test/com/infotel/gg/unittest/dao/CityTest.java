package com.infotel.gg.unittest.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.infotel.gg.dao.CityDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.hibernate.CityDAOHbn;
import com.infotel.gg.model.City;
import com.infotel.gg.model.Country;
import com.infotel.gg.model.Region;

import DBUnit.DBUtils;

public class CityTest {
	City c;
	CityDAO cd = new CityDAOHbn();
	List<City> lc;
	Country country;
	Region reg;

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
		cd = null;
		country = null;
		reg = null;
		lc=null;
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
		assertNull("la ville est nulle readKo2",cd.read(5566));
	}
	
	@Test(expected=DAOException.class)
	public void readKo2() {
		cd.read(null);
	}
	
	@Test
	public void listAll() throws DAOException{
		lc = cd.listAll();
		assertEquals(lc.get(0).getName(),"Bordeaux" );
		assertEquals(lc.get(1).getName(),"Boulogne-Billancourt" );
		assertEquals(lc.get(2).getName(),"Lille" );
		
	}
	
//	@Test
//	public void listAll(String keyword) throws DAOException{
//		lc = cd.listAll("Paris");
//		assertEquals(lc.get(0).getId(),1 );
//		assertEquals(lc.get(0).isForeMost(),1 );		
//	}
}


