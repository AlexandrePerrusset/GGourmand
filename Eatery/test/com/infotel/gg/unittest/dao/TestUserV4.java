package com.infotel.gg.unittest.dao;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.infotel.gg.customer.Customer;
import com.infotel.gg.dao.jdbc.CustomerDAO;
import com.infotel.gg.exception.UserException;

import DBUnit.DBUtils;

public class TestUserV4 {
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
		DBUtils.cleanDB();
	}
	

	@Test
	public void ReadOk() {
		assertNotNull("le customer n'est pas nul ReadOk", cd.read("alex.perru@gmail.com"));
	}
	@Test
	public void ReadOk2() {
		assertNotNull("le customer n'est pas nul ReadOk2", cd.read("plop@gmail.com"));
	
	}
	@Test
	public void ReadKo() {
		assertNull("le customer est nul ReadKo",  cd.read(null));
	}
	@Test
	public void ReadKo2() {
		assertNull("le customer est nul ReadKo2", cd.read("654364687434"));
	}
	@Test
	public void ReadExep() {
		assertNull(cd.read(""));

	}
	
	
	@Test
	public void CreateOk() throws UserException {
		c = new Customer("Alexa737ndra", "Per325russet", "Mme", "24152163", "alex@gmai.com", "sfgsh3783783fgseg");
		cd.create(c);
		assertNotNull("le customer n'est pas nul CreateOk", cd.read(c.getEmail()));
	}
	
	@Test
	public void CreateOk2() throws UserException {
		c = new Customer("Alexandre", "Perrusset", "Mr", "24152163", "alex@gmail.com", "sfgshfgseg");
		cd.create(c);
		assertNotNull("le customer n'est pas nul CreateOk", cd.read(c.getEmail()));
	}
	
	@Test(expected=UserException.class)
	public void CreateKo2() throws  UserException {
		c = new Customer("Alexandre", "Perrusset", "Mr", "24152163", null, "sfgshfgseg");
		cd.create(c);
		assertNull("le customer n'est pas nul CreateOk", cd.read(c.getEmail()));
	}
	
	@Test(expected=UserException.class)
	public void CreateKo() throws UserException {
		
		c = new Customer("Alexandre", "Perrusset", "Mr", "24152163", "alex.ru@gmail.com", "sfgshfgseg");
		
		cd.create(c);
		cd.create(c);
	}

	
	
	
	
	
	
}	
