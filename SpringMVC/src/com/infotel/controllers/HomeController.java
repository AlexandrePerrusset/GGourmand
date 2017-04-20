package com.infotel.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infotel.gg.DTO.CityDTO;
import com.infotel.gg.DTO.CookingStyleDTO;
import com.infotel.gg.DTO.EateryDTO;
import com.infotel.gg.DTO.ImageDataDTO;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.service.CatalogService;

@Controller 
@EnableTransactionManagement
public class HomeController {
	@Autowired
	CatalogService service;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<CookingStyleDTO> cookingDto = service.getAllCookingStyles();
		List<CityDTO> citiesDto = service.getAllCitiesForemost();
		List<ImageDataDTO> imgList = new ArrayList<>();
		
		for (CityDTO cityDTO : citiesDto) {
			try {				
				if(cityDTO.getImageId() != null)
					imgList.add(service.findImageDataById(cityDTO.getImageId()));
				else
					imgList.add(service.findImageDataDefault());
			} catch (GGourmandException e) {	
			}
		}
		model.addAttribute("cookingDto", cookingDto);
		model.addAttribute("citiesDto", citiesDto);
		model.addAttribute("imgdto", imgList);
		return "index";
	}
	
}
