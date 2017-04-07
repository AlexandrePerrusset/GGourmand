package com.infotel.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infotel.gg.DTO.CookingStyleDTO;
import com.infotel.gg.DTO.EateryDTO;
import com.infotel.gg.DTO.ImageDataDTO;
import com.infotel.gg.DTO.SearchCriteriaDTO;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.service.CatalogService;

@Controller
@EnableTransactionManagement
public class SearchController {

	@Autowired
	CatalogService service;

	@RequestMapping(value = "/eateries", method = RequestMethod.GET)
	public String search(@RequestParam("recherche") String recherche, Model model) {
			
		SearchCriteriaDTO criteria = new SearchCriteriaDTO();
		criteria.setName(recherche);
		List<EateryDTO> eateriesDto = service.findEateryByCriteria(criteria);
		
		List<ImageDataDTO> imgList = new ArrayList<>();
		for (EateryDTO eateryDTO : eateriesDto) {
			try {
				if(service.findImageDataById(eateryDTO.getImageId()) != null)
					imgList.add(service.findImageDataById(eateryDTO.getImageId()));
				else
					imgList.add(service.findImageDataById(eateriesDto.get(0).getImageId()));
			} catch (GGourmandException e) {
				//model.addAttribute("error", "Impossible de repondre");	
			}
		}
				
		model.addAttribute("eateriesDto", eateriesDto);
		model.addAttribute("imgdto", imgList);
		
		if(eateriesDto.size() > 0 ) {
			return "search";
		}
		return "noresults";
	}
	
	@RequestMapping(value = "/eateries/reservation/{id}", method = RequestMethod.GET)
	public String reservation(@PathVariable("id") Integer id, Model model) {
			
		EateryDTO eatery = service.findOneEatery(id);
		model.addAttribute("eateryid", id);	
		model.addAttribute("eatery", eatery);
		return "redirect:/reservation";
		
	}
	
	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
	public String reservation(Model model) {
		return "reservation";
	}
				
}
