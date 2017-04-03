package com.infotel.gg.unittest.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.infotel.gg.DTO.CookingStyleDTO;
import com.infotel.gg.DTO.EateryDTO;
import com.infotel.gg.model.Eatery;
import com.infotel.gg.service.CatalogService;
import com.infotel.gg.service.CatalogServiceImpl;

import DBUnit.DBUtils;

public class CatalogServiceImplTest {
	CatalogService cs = new CatalogServiceImpl();
	List<CookingStyleDTO> cookstyles;
	Eatery eatery = new Eatery();

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
	public void getAllCookingStylesOk() {
		cookstyles = new ArrayList<CookingStyleDTO>();
		cookstyles = cs.getAllCookingStyles();
		
		for (CookingStyleDTO cook : cookstyles) {
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
	
	
	
	

}
