package com.infotel.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infotel.gg.DTO.EateryDTO;
import com.infotel.gg.DTO.SearchCriteriaDTO;
import com.infotel.gg.service.CatalogService;

//Controller
public class SearchController {

	//@Autowired
	CatalogService service;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Locale locale, Model model) {
		SearchCriteriaDTO criteria = new SearchCriteriaDTO();
		criteria.setName("enise");
		List<EateryDTO> eateriesDto = new ArrayList<EateryDTO>(); // >service.findEateryByCriteria(criteria);
		model.addAttribute("eateriesDto", eateriesDto);
		if(eateriesDto.size() > 0 ) {
			return "index";
		}
		return "noresults";
	}
}
