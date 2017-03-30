package com.infotel.gg.unittest.dao;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.infotel.gg.dao.CustomerDAO;
import com.infotel.gg.dao.EateryManagerDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.hibernate.CustomerDAOHbn;
import com.infotel.gg.hibernate.EateryManagerDAOHbn;
import com.infotel.gg.model.Customer;
import com.infotel.gg.model.EateryManager;

import DBUnit.DBUtils;

public class UserTest {
	
	Customer c;
	CustomerDAO cd = new CustomerDAOHbn();
	
	EateryManager em;
	EateryManagerDAO emd = new EateryManagerDAOHbn();
	
	

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
		em=null;
	}
	
	@AfterClass
	public static void apresClass(){
		//DBUtils.cleanDB();
	}
	

	@Test
	public void readOk(){
		assertNotNull("le customer n'est pas nul ReadOk", cd.read("alex.perru@gmail.com"));
		assertNotNull("le eateryManager n'est pas nul ReadOk", emd.read("raphi2@gmail.com"));
	}
	
	@Test
	public void readOk2(){
		assertNotNull("le customer n'est pas nul ReadOk2", cd.read("plop@gmail.com"));	
		assertNotNull("le eateryManager n'est pas nul ReadOk2", emd.read("raphi@gmail.com"));
	}
	
	@Test(expected=DAOException.class)
	public void readKo() {
		cd.read(null);
		emd.read(null);
	}
	
	@Test
	public void readKo2(){
		assertNull("le customer est nul ReadKo2", cd.read("654364687434"));
		assertNull("le eateryManager n'est pas nul ReadKo2", emd.read("113544355"));
	}
	
	
	@Test
	public void readExep() throws ModelException {
		assertNull(cd.read(""));
		assertNull(emd.read(""));

	}
	
	
	@Test
	public void createOk() throws DAOException {
		c = new Customer("Alexa737ndra", "Per325russet", "Mme", "24152163", "alex@gmai.com", "sfgsh3783783fgseg");
		cd.create(c);
		assertNotNull("le customer n'est pas nul CreateOk", cd.read(c.getEmail()));
	}
	
	@Test
	public void createOk2() throws DAOException {
		c = new Customer("Alexandre", "Perrusset", "Mr", "24152163", "alex@gmail.com", "sfgshfgseg");
		cd.create(c);
		assertNotNull("le customer n'est pas nul CreateOk", cd.read(c.getEmail()));
	}
	
	@Test(expected=DAOException.class)
	public void createKo2() throws  DAOException {
		c = new Customer("Alexandre", "Perrusset", "Mr", "24152163", null, "sfgshfgseg");
		cd.create(c);
		assertNull("le customer n'est pas nul CreateOk", cd.read(c.getEmail()));
	}
	
	@Test
	public void UpdateOK() throws DAOException {
		c = new Customer("Alexandreupdate", "Perrusset", "Mr", "24152163", "alexupdate1@gmail.com", "sfgshfgseg");
		cd.update(c);
		assertNotNull("le customer n'est pas nul UpdateOk", cd.read(c.getEmail()));
	}
	


	@Test
	public void deleteOk() throws DAOException {	
		c = new Customer("Alexandre", "Perrusset", "Mr", "24152163", "delete", "sfgshfgseg");	
		cd.delete(c);	
		assertNull("le cutsomer n'est plus pr�sent dans la base", cd.read(c.getEmail()));
	}
	
	
	
		
	}
	

		

	
	

	
	
	
	
	
	
	
