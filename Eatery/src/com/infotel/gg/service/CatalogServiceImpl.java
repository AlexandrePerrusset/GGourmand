package com.infotel.gg.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.infotel.gg.DTO.CookingStyleDTO;
import com.infotel.gg.DTO.ReviewDTO;
import com.infotel.gg.dao.BookingDAO;
import com.infotel.gg.dao.CityDAO;
import com.infotel.gg.dao.CookingStyleDAO;
import com.infotel.gg.dao.EateryDAO;
import com.infotel.gg.dao.ImageDataDAO;
import com.infotel.gg.dao.ReviewDAO;
import com.infotel.gg.model.CookingStyle;




public class CatalogServiceImpl implements CatalogService {

	private final static Logger log = LogManager.getLogger(CatalogServiceImpl.class);


	private CookingStyleDAO cookingStyleDAO;
	private EateryDAO eateryDAO;
	private ImageDataDAO imageDataDAO;

	private CityDAO cityDAO;

	private ReviewDAO reviewDAO;

	private BookingDAO bookingDAO;

	@Override
	public List<CookingStyleDTO> getAllCookingStyles() {
		List<CookingStyleDTO> result = new ArrayList<CookingStyleDTO>();
		List<CookingStyle> cookingstyles = cookingStyleDAO.listAll();
		CookingStyleDTO cookingStyleDto = new CookingStyleDTO();
		for(CookingStyle cs : cookingstyles){
			cookingStyleDto.setId(Integer.toString(cs.getId()));
			cookingStyleDto.setName(cs.getName());
			result.add(cookingStyleDto);
		}
		
		return result;
		
		
	}

	

}
