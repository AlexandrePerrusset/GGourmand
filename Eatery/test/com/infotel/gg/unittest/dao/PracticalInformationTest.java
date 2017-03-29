
package com.infotel.gg.unittest.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.infotel.gg.dao.PracticalInformationDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.hibernate.PracticalInformationDAOHbn;
import com.infotel.gg.model.PracticalInformation;
import DBUnit.DBUtils;


public class PracticalInformationTest {
	PracticalInformation pi;
	PracticalInformationDAO pid = new PracticalInformationDAOHbn();

	
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
		pi=null;
	}


	@Test
	public void readOk() {
		assertNotNull("PracticalInformation n'est pas nulle readOk",pid.read(1));
	}
	
	@Test
	public void readOk2() {
		assertNotNull("PracticalInformation n'est pas nulle readOk2",pid.read(2));
	}
	
	@Test(expected=DAOException.class)
	public void readKo() {
		pid.read(null);
	}
	
	@Test
	public void readKo2() {
		assertNull("PracticalInformation est nulle readKo2",pid.read(5699965));
	}
	

}
