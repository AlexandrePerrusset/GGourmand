package com.infotel.gg.unittest.model;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.CookingStyle;
import com.infotel.gg.model.Eatery;
import com.infotel.gg.model.EateryTag;
import com.infotel.gg.model.Menu;
import com.infotel.gg.model.PracticalInformation;

@Ignore public class TestEatery {
	CookingStyle cooking;
	Eatery e;
	EateryTag eatTag;
	Menu menu;
	PracticalInformation practInf;
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		cooking = null;
		e = null;
		eatTag = null;
		menu = null;
		practInf = null;
	}

	// Tests constructeurs CookingStyle
	@Test
	public void constructeurCookingOK() {
		cooking = new CookingStyle(1, "Bidon");
		assertNotNull(cooking);
		assertEquals(cooking.getId(), 1);
		assertEquals(cooking.getName(), "Bidon");
	}
	
	// Tests constructeurs Eatery
	@Test
	public void constructeurEateryOK() {
		e = new Eatery(3, "Alex", "coucou", "chef");
		assertNotNull(e);
		assertEquals(e.getId(), 3);
		assertEquals(e.getName(), "Alex");
		assertEquals(e.getDescription(), "coucou");
		assertEquals(e.getExecutiveChef(), "chef");
	}
	
	// Tests constructeurs EateryTag
	@Test
	public void constructeurEateryTagOK1() {
		eatTag = new EateryTag(1, "ihjvxd");
		assertNotNull(eatTag);
		assertEquals(eatTag.getId(), 1);
		assertEquals(eatTag.getName(), "ihjvxd");
	}
	
	// Tests constructeurs Menu
	@Test
	public void constructeurMenuOK1() {
		menu = new Menu(1, "fsfq");
		assertNotNull(menu);
		assertEquals(menu.getId(), 1);
		assertEquals(menu.getContent(), "fsfq");
	}
	
	// Tests constructeur PracticalInformation
	@Test
	public void constructeurPracticalInformationOK() {
		practInf = new PracticalInformation(1, "deux", "trois", "quatre", "cinq", "six", "sept");
		assertNotNull(practInf);
		assertEquals(practInf.getId(), 1);
		assertEquals(practInf.getHoursOfOperation1(), "deux");
		assertEquals(practInf.getHoursOfOperation2(), "trois");
		assertEquals(practInf.getPrice(), "quatre");
		assertEquals(practInf.getPaymentOptions(), "cinq");
		assertEquals(practInf.getGettingThere(),"six");
		assertEquals(practInf.getParking(), "sept");
	}
}
