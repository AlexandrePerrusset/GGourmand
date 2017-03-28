/**
 * 
 */
package com.infotel.gg.unittest.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infotel.gg.model.Address;
import com.infotel.gg.model.City;
import com.infotel.gg.model.Country;
import com.infotel.gg.model.Region;


public class TestCity {
	
	Country country;
	City c;
	Region r;
	Address a;

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
		c=null;
		r=null;
		a=null;
	}

//	//Tests Country
//	@Test
//	public void CountryOK() throws ModelException {
//		country = new Country(1, "France");
//		assertNotNull(country);		
//	}
//	
//	@Test(expected=ModelException.class)
//	public void CountryKO1() throws ModelException {
//		country = new Country(-1, "France");		
//	}
//	
//	@Test(expected=ModelException.class)
//	public void CountryKO2() throws ModelException {
//		country = new Country(1, "");		
//	}
//	
//	@Test(expected=ModelException.class)
//	public void CountryKO3() throws ModelException {
//		country = new Country(1, " ");		
//	}
//	
//	@Test(expected=ModelException.class)
//	public void CountryKO4() throws ModelException {
//		country = new Country(1, null);		
//	}
	
	//Test Country
	@Test
	public void TestCountry(){
		country = new Country(1, "France");
		assertNotNull(country);
		assertEquals(country.getId(), 1);
		assertEquals(country.getName(), "France");
	}
	
	//Test Address
	@Test
	public void TestAddress(){
		a = new Address("rue vasselot", "35700");
		assertNotNull(a);
		assertEquals(a.getStreet(), "rue vasselot");
		assertEquals(a.getPostCode(), "35700");
	}
	
	//Test City
	@Test
	public void TestCity() {
		c = new City(1, "Rennes", "35700", true);
		assertNotNull(c);
		assertEquals(c.getId(), 1);
		assertEquals(c.getName(), "Rennes");
		assertEquals(c.getPostCode(), "35700");
		assertEquals(c.isForemost(), true);
	}
	
	//Test Region
	@Test
	public void TestRegion() {
		r = new Region(1, "Ouest");
		assertNotNull(r);
		assertEquals(r.getId(), 1);
		assertEquals(r.getName(), "Ouest");
	}
	
	
	
	
	

}
