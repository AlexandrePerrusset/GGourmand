/**
 * 
 */
package com.infotel.gg.unittest.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.infotel.gg.dao.EateryTagDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.hibernate.EateryTagDAOHbn;
import com.infotel.gg.model.EateryTag;

import DBUnit.DBUtils;


@Ignore public class EateryTagTest {
	EateryTag et;
	EateryTagDAO etd = new EateryTagDAOHbn();

	
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
		et=null;
	}

	@Test
	public void readOk() {
		assertNotNull("PracticalInformation n'est pas nulle readOk",etd.read(1));
	}
	
	@Test
	public void readOk2() {
		assertNotNull("PracticalInformation n'est pas nulle readOk2",etd.read(2));
	}
	
	@Test(expected=DAOException.class)
	public void readKo() {
		etd.read(null);
	}
	
	@Test
	public void readKo2() {
		assertNull("PracticalInformation est nulle readKo2",etd.read(5699965));
	}
	


}
