package com.infotel.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.infotel.gg.DTO.CookingStyleDTO;
import com.infotel.gg.DTO.EateryDTO;
import com.infotel.gg.DTO.ImageDataDTO;
import com.infotel.gg.DTO.SearchCriteriaDTO;
import com.infotel.gg.exception.AuthenticationException;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.service.BookingService;
import com.infotel.gg.service.CatalogService;
import com.infotel.gg.service.UserService;

@Controller
@EnableTransactionManagement
public class SearchController {

	@Autowired
	CatalogService service;
	
	@Autowired
	BookingService bkservice;
	
	@Autowired
	UserService userservice;

	@RequestMapping(value = "/eateries", method = RequestMethod.GET)
	public String search(@RequestParam("recherche") String recherche, @RequestParam(value = "cooking") int cooking, Model model) {
			
		SearchCriteriaDTO criteria = new SearchCriteriaDTO();
		criteria.setName(recherche);
		if(cooking!=0){
			criteria.setCookingStyleId(cooking);
		}
		List<EateryDTO> eateriesDto = service.findEateryByCriteria(criteria);
		List<CookingStyleDTO> cookingDto = service.getAllCookingStyles();
		List<ImageDataDTO> imgList = new ArrayList<>();
		for (EateryDTO eateryDTO : eateriesDto) {
			try {
				
				if(eateryDTO.getImageId() != null)
					imgList.add(service.findImageDataById(eateryDTO.getImageId()));
				else
					imgList.add(service.findImageDataDefault());
			} catch (GGourmandException e) {
				//model.addAttribute("error", "Impossible de repondre");	
			}
		}

		model.addAttribute("recherche", recherche);
		model.addAttribute("eateriesDto", eateriesDto);
		model.addAttribute("imgdto", imgList);
		model.addAttribute("cookingDto", cookingDto);
		
		if(eateriesDto.size() > 0 ) {
			return "search";
		}
		return "noresults";
	}
	
	@RequestMapping(value = "/eateries/reservation/{id}", method = RequestMethod.GET)
	public ModelAndView reservation(@PathVariable("id") Integer id, RedirectAttributes redir) {
		
		EateryDTO eatery = service.findOneEatery(id);
		ImageDataDTO imgdto = new ImageDataDTO();
		try {
			if(eatery.getImageId() > 0){
				imgdto = service.findImageDataById(eatery.getImageId());
			}else{
				imgdto = service.findImageDataDefault();
			}
		} catch (GGourmandException e) {
		}
		
		
	
	
		ModelAndView modelAndView = new ModelAndView(); 
		modelAndView.setViewName("redirect:/reservation");
		redir.addFlashAttribute("eatery",eatery);
		redir.addFlashAttribute("imgdto",imgdto);


		return modelAndView;
		    

	}
	
	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
	public String reservation(Model model) {
		List<CookingStyleDTO> cookingDto = service.getAllCookingStyles();
		model.addAttribute("cookingDto", cookingDto);
		return "reservation";
	}
	
	
	
	
	
				
}
