package com.infotel.gg.unittest.dao;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.infotel.gg.dao.CustomerDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.Customer;

import DBUnit.DBUtils;

public class UserTest {
	Customer c;
	CustomerDAO cd = new CustomerDAO();
	

	@BeforeClass
	public static void avantClass(){
		DBUtils.startDB();
		
		
	}
	
	@Before
	public void avant() throws Exception {

	}

	@After
	public void apres() throws Exception {
		c = null;
	}
	
	@AfterClass
	public static void apresClass(){
		//DBUtils.cleanDB();
	}
	

	@Test
	public void readOk() throws ModelException {
		assertNotNull("le customer n'est pas nul ReadOk", cd.read("alex.perru@gmail.com"));
	}
	@Test
	public void readOk2() throws ModelException {
		assertNotNull("le customer n'est pas nul ReadOk2", cd.read("plop@gmail.com"));
	
	}
	@Test
	public void readKo() throws ModelException {
		assertNull("le customer est nul ReadKo",  cd.read(null));
	}
	@Test
	public void readKo2() throws ModelException {
		assertNull("le customer est nul ReadKo2", cd.read("654364687434"));
	}
	@Test
	public void readExep() throws ModelException {
		assertNull(cd.read(""));

	}
	
	
	@Test
	public void createOk() throws DAOException, ModelException {
		c = new Customer("Alexa737ndra", "Per325russet", "Mme", "24152163", "alex@gmai.com", "sfgsh3783783fgseg");
		cd.create(c);
		assertNotNull("le customer n'est pas nul CreateOk", cd.read(c.getEmail()));
	}
	
	@Test
	public void createOk2() throws DAOException, ModelException {
		c = new Customer("Alexandre", "Perrusset", "Mr", "24152163", "alex@gmail.com", "sfgshfgseg");
		cd.create(c);
		assertNotNull("le customer n'est pas nul CreateOk", cd.read(c.getEmail()));
	}
	
	@Test(expected=DAOException.class)
	public void createKo2() throws  DAOException, ModelException {
		c = new Customer("Alexandre", "Perrusset", "Mr", "24152163", null, "sfgshfgseg");
		cd.create(c);
		assertNull("le customer n'est pas nul CreateOk", cd.read(c.getEmail()));
	}
	
	@Test(expected=DAOException.class)
	public void createKo() throws DAOException {
		
		c = new Customer("Alexandre", "Perrusset", "Mr", "24152163", "alex.ru@gmail.com", "sfgshfgseg");
		
		cd.create(c);
		cd.create(c);
	}

	@Test
	public void deleteOk() throws DAOException, ModelException {
		
		c = new Customer("Alexandre", "Perrusset", "Mr", "24152163", "delete", "sfgshfgseg");
		
		cd.delete(c);
		
		assertNull("le cutsomer n'est plus pr�sent dans la base", cd.read(c.getEmail()));
	}
	
	@Test(expected=DAOException.class)
	public void deleteKo() throws DAOException, ModelException {
		
		c = new Customer("Alexandre", "Perrusset", "Mr", "24152163", "delezgzegzeete", "sfgshfgseg");
		
		cd.delete(c);
		
		
	}
	@Test
	public void deleteOk2() throws DAOException, ModelException {
		

		
		cd.deleteById("delete2");
		
		assertNull("le cutsomer n'est plus pr�sent dans la base", cd.read("delete2"));
	}
	
	@Test(expected=DAOException.class)
	public void deleteKo2() throws DAOException, ModelException {
		
	
		
		cd.deleteById("rzgergrezgre");
		
		
	}
	
	

	
	
	
	
	
	
}	
