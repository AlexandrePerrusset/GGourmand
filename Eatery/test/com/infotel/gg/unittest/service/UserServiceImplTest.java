package com.infotel.gg.unittest.service;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infotel.gg.DTO.UserDTO;
import com.infotel.gg.dao.CustomerDAO;
import com.infotel.gg.exception.AuthenticationException;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.hibernate.CustomerDAOHbn;
import com.infotel.gg.model.Customer;
import com.infotel.gg.service.CatalogService;
import com.infotel.gg.service.UserService;
import com.infotel.gg.service.UserServiceImpl;

import DBUnit.DBUtils;

public class UserServiceImplTest {
	UserDTO udto = new UserDTO();
	static UserService us;
	Customer cust = new Customer();

	static CustomerDAO custdao;
	private final static Logger log = LogManager.getLogger(UserServiceImplTest.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DBUtils.startDB();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-test.xml");
		us = ctx.getBean(UserService.class);
		custdao = ctx.getBean(CustomerDAO.class);
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
		udto = null;
	}

	@Test
	public void authenticateOk() throws AuthenticationException{
		udto = us.authenticate("jefr", "fo");
		assertNotNull("UserDTO n'est pas null",udto);
		assertEquals("Identifiant correct", "jefr", udto.getUsername());
		assertEquals("Prenom correct", "Jean", udto.getFirstName());
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
	
}
