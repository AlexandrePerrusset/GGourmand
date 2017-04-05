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

import com.infotel.gg.dao.MenuDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.hibernate.MenuDAOHbn;
import com.infotel.gg.model.Menu;

import DBUnit.DBUtils;


@Ignore public class MenuTest {
	Menu m;
	MenuDAO md = new MenuDAOHbn();

	
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
		m=null;
	}

	@Test
	public void readOk() {
		assertNotNull("PracticalInformation n'est pas nulle readOk",md.read(1));
	}
	
	@Test
	public void readOk2() {
		assertNotNull("PracticalInformation n'est pas nulle readOk2",md.read(2));
	}
	
	@Test(expected=DAOException.class)
	public void readKo() {
		md.read(null);
	}
	
	@Test
	public void readKo2() {
		assertNull("PracticalInformation est nulle readKo2",md.read(5699965));
	}
	


}
