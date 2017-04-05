
package com.infotel.gg.unittest.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.infotel.gg.dao.RegionDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.hibernate.RegionDAOHbn;
import com.infotel.gg.model.Region;

import DBUnit.DBUtils;


@Ignore public class RegionTest {
	
	Region r;
	RegionDAO rd = new RegionDAOHbn();

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
	
	@Test(expected=DAOException.class)
	public void readKo() {
		rd.read(null);
	}
	
	@Test
	public void readKo2() {
		assertNull("la region est nulle readKo2",rd.read(5699965));
	}

	
	

}
