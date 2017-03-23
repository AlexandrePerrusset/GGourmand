package com.infotel.gg.unittest.model;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.CookingStyle;
import com.infotel.gg.model.Eatery;
import com.infotel.gg.model.EateryTag;
import com.infotel.gg.model.Menu;
import com.infotel.gg.model.PracticalInformation;

public class TestEatery {
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
	public void constructeurCookingOK() throws ModelException {
		cooking = new CookingStyle(1, "Thomas");
		assertNotNull(cooking);
	}
	
	@Test(expected=ModelException.class)
	public void constructeurCookingKO2() throws ModelException {
		cooking = new CookingStyle(-2, "  ");
	}
	
	@Test(expected=ModelException.class)
	public void constructeurCookingKO3() throws ModelException {
		cooking = new CookingStyle(2, "");
	}
	
	@Test(expected=ModelException.class)
	public void constructeurCookingKO4() throws ModelException {
		cooking = new CookingStyle(2, "  ");
	}
	
	@Test(expected=ModelException.class)
	public void constructeurCookingKO5() throws ModelException {
		cooking = new CookingStyle(2, null);
	}
	
	// Tests constructeurs Eatery
	@Test
	public void constructeurEateryOK1() throws ModelException {
		e = new Eatery(3, "Alex", "coucou", "chef");
		assertNotNull(e);
	}
	
	@Test(expected=ModelException.class)
	public void constructeurEateryKO1() throws ModelException {
		e = new Eatery(-1, "", "", "");
	}
	
	@Test(expected=ModelException.class)
	public void constructeurEateryKO2() throws ModelException {
		e = new Eatery(1, "", "", "");
	}
	
	@Test(expected=ModelException.class)
	public void constructeurEateryKO3() throws ModelException {
		e = new Eatery(1, "  ", "  ", "  ");
	}
	
	@Test(expected=ModelException.class)
	public void constructeurEateryKO4() throws ModelException {
		e = new Eatery(1, null, "ff", "ff");
	}
	
	// Tests constructeurs EateryTag
	@Test
	public void constructeurEateryTagOK1() throws ModelException {
		eatTag = new EateryTag(1, "ihjvxd");
		assertNotNull(eatTag);
	}
	
	@Test(expected=ModelException.class)
	public void constructeurEateryTagKO3() throws ModelException {
		eatTag = new EateryTag(2, "");
	}
	
	@Test(expected=ModelException.class)
	public void constructeurEateryTagKO4() throws ModelException {
		eatTag = new EateryTag(2, "  ");
	}
	
	@Test(expected=ModelException.class)
	public void constructeurEateryTagKO5() throws ModelException {
		eatTag = new EateryTag(2, null);
	}
	
	@Test(expected=ModelException.class)
	public void constructeurEateryTagKO6() throws ModelException {
		eatTag = new EateryTag(-2, "sfs");
	}
	
	// Tests constructeurs Menu
	@Test
	public void constructeurMenuOK1() throws ModelException {
		menu = new Menu(1, "fsfq");
		assertNotNull(menu);
	}
	
	@Test(expected=ModelException.class)
	public void constructeurMenuKO1() throws ModelException {
		menu = new Menu(1, "");
	}
	
	@Test(expected=ModelException.class)
	public void constructeurMenuKO2() throws ModelException {
		menu = new Menu(1, " ");
	}
	
	@Test(expected=ModelException.class)
	public void constructeurMenuKO3() throws ModelException {
		menu = new Menu(1, null);
	}
	
	@Test(expected=ModelException.class)
	public void constructeurMenuKO4() throws ModelException {
		menu = new Menu(-1, "gd");
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
