package com.infotel.gg.unittest.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infotel.gg.eatery.CookingStyle;
import com.infotel.gg.eatery.Eatery;

public class TestEatery {
	CookingStyle c;
	Eatery e;
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}

	// Tests constructeurs CookingStyle
	@Test
	public void constructeurCookingOK() {
		c = new CookingStyle(1, "Thomas");
		assertNotNull(c);
	}
	
	@Test
	public void constructeurCookingKO1() {
		c = new CookingStyle(null, "Thomas");
		assertNull(c);
	}
	
	@Test
	public void constructeurCookingKO2() {
		c = new CookingStyle(2, null);
		assertNull(c);
	}
	
	// Tests constructeurs Eatery
	@Test
	public void constructeurEateryOK() {
//		e = new Eatery(id, name, description, executiveChef, practicalIformation, cookingStyle, address, menu, eateryTags, eateryManager);
		assertNotNull(e);
	}
}
