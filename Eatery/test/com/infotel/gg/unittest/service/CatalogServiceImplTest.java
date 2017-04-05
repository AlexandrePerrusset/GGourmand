package com.infotel.gg.unittest.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infotel.gg.DTO.CityDTO;
import com.infotel.gg.DTO.CookingStyleDTO;
import com.infotel.gg.DTO.EateryDTO;
import com.infotel.gg.DTO.ReviewDTO;
import com.infotel.gg.dao.ReviewDAO;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.hibernate.ReviewDAOHbn;
import com.infotel.gg.model.Eatery;
import com.infotel.gg.model.ImageData;
import com.infotel.gg.service.CatalogService;

import DBUnit.DBUtils;

public class CatalogServiceImplTest {
	List<CookingStyleDTO> cookstyledtos;
	static CatalogService catservice;
	Eatery eatery;
	ImageData image;
	List<Integer> bigimages;
	List<Integer> smallimages;
	ReviewDTO reviewdto = new ReviewDTO();

	List<CityDTO>citiesdto;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DBUtils.startDB();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-test.xml");
		catservice = ctx.getBean(CatalogService.class);
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
		cookstyledtos = catservice.getAllCookingStyles();
		
		for (CookingStyleDTO cook : cookstyledtos) {
			assertNotNull(cook);
		}
	}
	
	@Test
	public void findOneEateryOk() {
		EateryDTO edto = catservice.findOneEatery(2);
		assertNotNull(edto);
		assertEquals(edto.getName(), "Pietro");
		assertEquals(edto.getPostCode(), "75008");
		assertEquals(edto.getStreet(), "28, rue Jean Mermoz");
	}
	
	@Test
	public void findOneRealEateryOk() {
		eatery = catservice.findOneRealEatery(2);
		assertNotNull(eatery);
		assertEquals(eatery.getName(), "Pietro");
		assertEquals(eatery.getAddress().getPostCode(), "75008");
		assertEquals(eatery.getAddress().getCity().getId(), 1);
		assertEquals(eatery.getAddress().getStreet(), "28, rue Jean Mermoz");
	}
	
	@Test
	public void findImageDataByIdOk() throws GGourmandException {
		image = catservice.findImageDataById(2);
		assertNotNull(image.getId());
		assertNotNull(image.getContent());
		assertNotNull(image.getTarget());	
		assertNotNull(image.getTargetId());
	}
	
	@Test
	public void findBigImageForEateryOk() {
		bigimages = new ArrayList<Integer>();
		bigimages = catservice.findBigImageForEatery(1);
		
		for (Integer i : bigimages) {
			assertNotNull(i);
		}
	}
	
	@Test
	public void findSmallImageForEateryOk() {
		smallimages = new ArrayList<Integer>();
		smallimages = catservice.findSmallImageForEatery(1);
		
		for (Integer i : smallimages) {
			assertNotNull(i);
		}
	}
	
	// TODO : continuer reviewOk()
	@Test
	public void reviewOk() throws GGourmandException {
		reviewdto.setBookingID(1);
		reviewdto.setComment("comment1");
		reviewdto.setRating(17);
		catservice.review(reviewdto);
		assertNotNull(reviewdto);
	}
	
	@Test
	public void getAllCitiesOk(){
		citiesdto = new ArrayList<CityDTO>();
		citiesdto = catservice.getAllCities();
		for (CityDTO cit : citiesdto) {
			assertNotNull(cit);
		}
	}


	
	@Test
	public void getAllCitiesForemostOk(){
		citiesdto = new ArrayList<CityDTO>();
		citiesdto = catservice.getAllCitiesLike("Lyo");
		assertNotNull("City found", citiesdto.get(0));
		assertNotNull("Id found", citiesdto.get(0).getId());
		assertNotNull("Name found", citiesdto.get(0).getName());
		assertNotNull("Foremost found", citiesdto.get(0).getForemost());	
		assertNotNull("Pays found", citiesdto.get(0).getCountry_name());
		assertNotNull("Region found", citiesdto.get(0).getRegion_name());
		System.out.println(citiesdto);
	}
	
	@Test
	public void testGetAllCitiesLike() {
		citiesdto = new ArrayList<CityDTO>();
		citiesdto = catservice.getAllCitiesLike("Lyo");
		assertNotNull("City found", citiesdto.get(0));
		assertNotNull("Id found", citiesdto.get(0).getId());
		assertNotNull("Name found", citiesdto.get(0).getName());
		assertNotNull("Foremost found", citiesdto.get(0).getForemost());	
		assertNotNull("Pays found", citiesdto.get(0).getCountry_name());
		assertNotNull("Region found", citiesdto.get(0).getRegion_name());
		System.out.println(citiesdto);
	}
}
