package com.infotel.gg.unittest.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.infotel.gg.dao.EateryDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.hibernate.EateryDAOHbn;
import com.infotel.gg.model.City;
import com.infotel.gg.model.Eatery;

import DBUnit.DBUtils;

@Ignore public class EateryTest {
	Eatery eatery;
	EateryDAO ed = new EateryDAOHbn();

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
		eatery = null;
		ed = null;
	}

	@Test
	public void readOk() {
		assertNotNull("l'eatery n'est pas nul readOk",ed.read(1));
	}
	
	@Test(expected=DAOException.class)
	public void readKo() {
		assertNull("l'eatery est nul readKo",ed.read(null));
	}
	
	@Test
	public void readKo2() {
		assertNull("l'eatery est nul readKo2",ed.read(159753));
	}
}
