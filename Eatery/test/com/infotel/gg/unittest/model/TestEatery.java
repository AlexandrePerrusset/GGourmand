package com.infotel.gg.unittest.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infotel.gg.bookingreport.EateryManager;
import com.infotel.gg.city.Address;
import com.infotel.gg.eatery.CookingStyle;
import com.infotel.gg.eatery.Eatery;
import com.infotel.gg.eatery.EateryTag;
import com.infotel.gg.eatery.Menu;
import com.infotel.gg.eatery.PracticalInformation;
import com.infotel.gg.exception.ModelException;

public class TestEatery {
	CookingStyle cooking;
	Eatery e;
	PracticalInformation p;
	Address a;
	Menu m;
	List<EateryTag> listEatTag;
	EateryManager em;
	EateryTag eatTag;
	List<Eatery> listEat;
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		cooking = null;
		e = null;
		eatTag = null;
	}

	// Tests constructeurs CookingStyle
	@Test
	public void constructeurCookingOK() throws ModelException {
		cooking = new CookingStyle(1, "Thomas");
		assertNotNull(cooking);
	}
	
	@Test(expected=ModelException.class)
	public void constructeurCookingKO1() throws ModelException {
		cooking = new CookingStyle(null, "Thomas");
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
		cooking = new CookingStyle(null, null);
	}
	
	// Tests constructeurs Eatery
	@Test
	public void constructeurEateryOK1() throws ModelException {
		e = new Eatery(3, "Alex", "coucou", "chef");
		assertNotNull(e);
	}
	
	@Test(expected=ModelException.class)
	public void constructeurEateryKO1() throws ModelException {
		e = new Eatery(-1, "", "", "", p, cooking, a, m, listEatTag, em);
	}
	
	@Test(expected=ModelException.class)
	public void constructeurEateryKO2() throws ModelException {
		e = new Eatery(1, "", "", "", p, cooking, a, m, listEatTag, em);
	}
	
	@Test(expected=ModelException.class)
	public void constructeurEateryKO3() throws ModelException {
		e = new Eatery(1, "  ", "  ", "  ", p, cooking, a, m, listEatTag, em);
	}
	
	@Test(expected=ModelException.class)
	public void constructeurEateryKO4() throws ModelException {
		e = new Eatery(1, "ff", "ff", "ff", null, null, null, null, null, null);
	}
	
	// Tests constructeurs EateryTag
	@Test
	public void constructeurEateryTagOK1() throws ModelException {
		eatTag = new EateryTag(1, "ihjvxd");
		assertNotNull(eatTag);
	}
	
	// TODO : tests KO1 et KO2 avec null
	
//	@Test(expected=ModelException.class)
//	public void constructeurEateryTagKO1() throws ModelException {
//		eatTag = new EateryTag(null, "sd");
//	}
//	
//	@Test(expected=ModelException.class)
//	public void constructeurEateryTagKO2() throws ModelException {
//		eatTag = new EateryTag(null, null);
//	}
	
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
}
