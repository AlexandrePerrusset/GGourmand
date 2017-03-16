package com.infotel.gg.unittest.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infotel.gg.eatery.CookingStyle;
import com.infotel.gg.eatery.Eatery;
import com.infotel.gg.exception.ModelException;

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
	public void constructeurCookingOK() throws ModelException {
		c = new CookingStyle(1, "Thomas");
		assertNotNull(c);
	}
	
	@Test(expected=ModelException.class)
	public void constructeurCookingKO1() throws ModelException {
		c = new CookingStyle(null, "Thomas");
	}
	
	@Test(expected=ModelException.class)
	public void constructeurCookingKO2() throws ModelException {
		c = new CookingStyle(-2, "  ");
	}
	
	@Test(expected=ModelException.class)
	public void constructeurCookingKO3() throws ModelException {
		c = new CookingStyle(null, null);
	}
	
//	// Tests constructeurs Eatery
//	@Test
//	public void constructeurEateryOK() {
//		e = new Eatery(id, name, description, executiveChef, practicalIformation, cookingStyle, address, menu, eateryTags, eateryManager);
//		assertNotNull(e);
//	}
}
