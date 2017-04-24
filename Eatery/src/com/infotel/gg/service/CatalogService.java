package com.infotel.gg.service;

import java.util.List;

import com.infotel.gg.DTO.CityDTO;
import com.infotel.gg.DTO.CookingStyleDTO;
import com.infotel.gg.DTO.EateryDTO;
import com.infotel.gg.DTO.ImageDataDTO;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.model.Eatery;
import com.infotel.gg.model.ImageData;
import com.infotel.gg.DTO.SearchCriteriaDTO;
import com.infotel.gg.DTO.ReviewDTO;


public interface CatalogService {
	/*** methods for Eateries ***/
	List<CookingStyleDTO> getAllCookingStyles();
	
	EateryDTO findOneEatery(int id);
	
	Eatery findOneRealEatery(int id);
	
	ImageDataDTO findImageDataById(int id) throws GGourmandException;
	
	List<Integer> findBigImageForEatery(int eateryId);
	
	List<Integer> findSmallImageForEatery(int eateryId);
	
	void review(ReviewDTO rdto) throws GGourmandException;
	
	public List<ReviewDTO> findReviewsByCustomer(String username) throws GGourmandException;
	

	List<EateryDTO> findEateryByCriteria(SearchCriteriaDTO criteria);


	List<CityDTO> getAllCitiesLike(String beginNameCity);

	List<CityDTO> getAllCitiesForemost();

	List<CityDTO> getAllCities();

	ImageDataDTO findImageDataDefault() throws GGourmandException;

	List<EateryDTO> getAllEateries();

	String getCookingNameById(int id);

	List<EateryDTO> findEateryByCity(SearchCriteriaDTO criteria);

	ImageDataDTO findImageDataByIdRest(int id) throws GGourmandException;

	
}
