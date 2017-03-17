/**
 * 
 */
package com.infotel.gg.City;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infotel.gg.city.Address;
import com.infotel.gg.city.Country;
import com.infotel.gg.exception.ModelException;


public class TestCity {
	
	Country country;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		country =null;
	}

	//Tests Country
	@Test
	public void CountryOK() throws ModelException {
		country = new Country(1, "France");
		assertNotNull(country);		
	}
	
	@Test(expected=ModelException.class)
	public void CountryKO1() throws ModelException {
		country = new Country(-1, "France");		
	}
	
	@Test(expected=ModelException.class)
	public void CountryKO2() throws ModelException {
		country = new Country(1, "");		
	}
	
	@Test(expected=ModelException.class)
	public void CountryKO3() throws ModelException {
		country = new Country(1, " ");		
	}
	
	@Test(expected=ModelException.class)
	public void CountryKO4() throws ModelException {
		country = new Country(1, null);		
	}
	
	//Test Address
	@Test
	public void TestAddress() throws ModelException {
		Address a = new Address("rue vasselot", "35700");
		assertNotNull(a);
		assertEquals(a.getStreet(), "rue vasselot");
		assertEquals(a.getPostCode(), "35700");
	}
	
	
	
	

}
