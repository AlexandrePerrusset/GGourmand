package com.infotel.gg.unittest.service;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.infotel.gg.DTO.UserDTO;
import com.infotel.gg.dao.CustomerDAO;
import com.infotel.gg.exception.AuthenticationException;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.hibernate.CustomerDAOHbn;
import com.infotel.gg.model.Customer;
import com.infotel.gg.service.UserService;
import com.infotel.gg.service.UserServiceImpl;

import DBUnit.DBUtils;

public class UserServiceImplTest {
	UserDTO udto = new UserDTO();
	UserService us = new UserServiceImpl();
	Customer cust;
	CustomerDAO custdao = new CustomerDAOHbn();
	
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
	}

	@Test
	public void authenticateOk() throws AuthenticationException{
		udto = us.authenticate("jefr", "fo");
		assertNotNull("UserDTO n'est pas null",udto);
		assertEquals("Identifiant correct", "jefr", udto.getUsername());
		assertEquals("Mot de passe correct", "fo", udto.getPassword());
	}
	
	@Test(expected=AuthenticationException.class)
	public void authenticateKo() throws AuthenticationException{
		udto = us.authenticate("existePas", "nonPlus");
		assertNull("UserDTO est null",udto);
	}
	
	@Test
	public void registerOk() throws GGourmandException{
		udto.setFirstName("Denis");
		udto.setLastName("Sined");
		udto.setTitle( "Mr");
		udto.setPhone("0223632595");
		udto.setUsername("username");
		udto.setPassword("pass");
		udto.setType("customer");
		
		us.register(udto);
		assertNotNull("le customer n'est pas null registerOk", custdao.read(udto.getUsername()));
	}
	
	// TODO : registerKo
//	@Test(expected=GGourmandException.class)
//	public void registerKo() throws GGourmandException{
//		udto.setFirstName("Thomas");
//		udto.setLastName("Samoht");
//		udto.setTitle( "Mr");
//		udto.setPhone("0222336655");
//		udto.setUsername(null);
//		udto.setPassword("pass2");
//		udto.setType("customer");
//		
//		us.register(udto);
//		assertNull("le customer est null registerKo", custdao.read(udto.getUsername()));
//	}
}
