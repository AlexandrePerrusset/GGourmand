package com.infotel.gg.unittest.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infotel.gg.eatery.CookingStyle;

public class TestEatery {
	CookingStyle c;
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}

	@Test
	public void constructeurOK() {
		c = new CookingStyle(1, "Thomas");
		assertNotNull(c);
	}
	
	@Test
	public void constructeurKO1() {
		c = new CookingStyle(null, "Thomas");
		assertNull(c);
	}
	
	@Test
	public void constructeurKO2() {
		c = new CookingStyle(2, null);
		assertNull(c);
	}
}
