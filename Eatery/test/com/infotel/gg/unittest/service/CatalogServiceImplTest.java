package com.infotel.gg.unittest.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infotel.gg.DTO.CookingStyleDTO;
import com.infotel.gg.DTO.EateryDTO;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.model.Eatery;
import com.infotel.gg.model.ImageData;
import com.infotel.gg.service.CatalogService;
import com.infotel.gg.service.CatalogServiceImpl;

import DBUnit.DBUtils;

public class CatalogServiceImplTest {
	@Autowired
	CatalogService cs;
	List<CookingStyleDTO> cookstyledtos;
	
	@Autowired
	Eatery eatery;
	
	@Autowired
	ImageData image;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DBUtils.startDB();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-test.xml");
		CatalogService catalog = ctx.getBean(CatalogService.class);
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
	public void getAllCookingStylesOk() {
		cookstyledtos = new ArrayList<CookingStyleDTO>();
		cookstyledtos = cs.getAllCookingStyles();
		
		for (CookingStyleDTO cook : cookstyledtos) {
			assertNotNull(cook);
		}
	}
	
	@Test
	public void findOneEateryOk() {
		EateryDTO edto = cs.findOneEatery(2);
		assertNotNull(edto);
		assertEquals(edto.getName(), "Pietro");
	}
	
	@Test
	public void findOneRealEateryOk() {
		eatery = cs.findOneRealEatery(2);
		assertNotNull(eatery);
		assertEquals(eatery.getName(), "Pietro");
	}
	
	@Test
	public void findImageDataByIdOk() throws GGourmandException {
		image = cs.findImageDataById(2);
		assertNotNull(image.getId());
		assertNotNull(image.getContent());
		assertNotNull(image.getTarget());	
		assertNotNull(image.getTargetId());
		assertNotNull(image.getSize());
	}

}
