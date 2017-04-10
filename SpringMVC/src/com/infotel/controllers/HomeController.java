package com.infotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infotel.gg.DTO.CookingStyleDTO;
import com.infotel.gg.service.CatalogService;

@Controller 
@EnableTransactionManagement
public class HomeController {
	@Autowired
	CatalogService service;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<CookingStyleDTO> cookingDto = service.getAllCookingStyles();
		System.out.println(cookingDto);
		model.addAttribute("cookingDto", cookingDto);
		return "index";
	}
	
}
