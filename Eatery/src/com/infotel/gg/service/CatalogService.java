package com.infotel.gg.service;

import java.util.List;

import com.infotel.gg.DTO.CookingStyleDTO;
import com.infotel.gg.DTO.EateryDTO;
import com.infotel.gg.model.Eatery;






public interface CatalogService {
	/*** methods for Eateries ***/
	List<CookingStyleDTO> getAllCookingStyles();
	
	EateryDTO findOneEatery(int id);
	
	Eatery findOneRealEatery(int id);
	
}
