
package com.infotel.gg.unittest.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.infotel.gg.dao.jdbc.PracticalInformationDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.PracticalInformation;
import DBUnit.DBUtils;


public class PracticalInformationTest {
	PracticalInformation pi;
	PracticalInformationDAO pid = new PracticalInformationDAO();

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DBUtils.startDB();
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DBUtils.cleanDB();
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
	
	@Test
	public void readKo() {
		assertNull("PracticalInformation est nulle readKo",pid.read(null));
	}
	
	@Test
	public void readKo2() {
		assertNull("PracticalInformation est nulle readKo2",pid.read(5699965));
	}
	
	@Test
	public void CreateOk() throws DAOException, ModelException {
		pi = new PracticalInformation(141, "ho1", "ho2", "price","paymentoption","gettingthere","parking");
		pid.create(pi);
		assertNotNull("PracticalInformation n'est pas nulle CreateOk", pid.read(pi.getId()));
	}
	
	@Test
	public void CreateOk2() throws DAOException, ModelException {
		pi = new PracticalInformation(142, "ho1a", "ho2a", "price1","paymentoption1","gettingthere1","parking1");
		pid.create(pi);
		assertNotNull("PracticalInformationn'est pas nulle CreateOk2", pid.read(pi.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void createKo() throws  DAOException, ModelException {
		pi = new PracticalInformation(1,null, "ho2", "price","paymentoption","gettingthere","parking");
		pid.create(pi);
		assertNull("PracticalInformation n'est pas nul CreateOk", pid.read(pi.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void CreateKo2() throws DAOException, ModelException {
		pi = new PracticalInformation(144, "ho1", "ho2", "price","paymentoption","gettingthere","parking");
		pid.create(pi);
		pid.create(pi);
	}
	
	@Test
	public void deleteOk() throws DAOException, ModelException {	
		pi = new PracticalInformation(10, "ho1", "ho2", "price","paymentoption","gettingthere","parking");		
		pid.delete(pi);		
		assertNull("PracticalInformation n'est plus présent dans la base", pid.read(pi.getId()));
	}
	
	@Test(expected=DAOException.class)
	public void deleteKo() throws DAOException, ModelException {		
		pi = new PracticalInformation(60, "ho1", "ho2", "price","paymentoption","gettingthere","parking");		
		pid.delete(pi);				
	}
	
	
	@Test
	public void deleteOk2() throws DAOException, ModelException {		
		pid.deleteById(33);	
		assertNull("PracticalInformation n'est plus présent dans la base", pid.read(33));
	}
	
	
	@Test(expected=DAOException.class)
	public void deleteKo2() throws DAOException, ModelException {
	pid.deleteById(50);		
	}

}
