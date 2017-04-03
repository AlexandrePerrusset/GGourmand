package com.infotel.gg.service;

import java.util.List;

import com.infotel.gg.DTO.CookingStyleDTO;
import com.infotel.gg.DTO.EateryDTO;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.model.Eatery;
import com.infotel.gg.model.ImageData;






public interface CatalogService {
	/*** methods for Eateries ***/
	List<CookingStyleDTO> getAllCookingStyles();
	
	EateryDTO findOneEatery(int id);
	
	Eatery findOneRealEatery(int id);
	
	ImageData findImageDataById(int id) throws GGourmandException;
	
	List<Integer> findBigImageForEatery(int eateryId);
	
	List<Integer> findSmallImageForEatery(int eateryId);
	
}
