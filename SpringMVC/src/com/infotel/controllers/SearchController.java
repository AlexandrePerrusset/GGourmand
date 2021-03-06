package com.infotel.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.infotel.gg.DTO.CityDTO;
import com.infotel.gg.DTO.CookingStyleDTO;
import com.infotel.gg.DTO.EateryDTO;
import com.infotel.gg.DTO.ImageDataDTO;
import com.infotel.gg.DTO.SearchCriteriaDTO;
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
	public ModelAndView search(@RequestParam("recherche") String recherche, @RequestParam(value = "cooking") int cooking,@RequestParam(value = "date") String date, @RequestParam(value = "NbPer") int NbPer, RedirectAttributes redir, HttpServletRequest request) {
		
		if (recherche != null) {
			request.getSession().setAttribute("recherche", recherche);
		}
		
		if (NbPer != 0) {
			request.getSession().setAttribute("NbPer", NbPer);
		}
		

		

		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);
		Calendar calendar = new GregorianCalendar();
		try {
			calendar.setTime(formatter.parse(date));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		String madate = formatter.format(calendar.getTime());
		
		if (date != null) {
			request.getSession().setAttribute("date", madate);
		}
		

		
		
		SearchCriteriaDTO criteria = new SearchCriteriaDTO();
		criteria.setName(recherche);
		
		if(cooking!=0){
			criteria.setCookingStyleId(cooking);
			String cookingname = service.getCookingNameById(cooking);
			if (cookingname != null) {
				request.getSession().setAttribute("cookingname", cookingname);
			}				
		}
		
		List<EateryDTO> eateriesByName = service.findEateryByCriteria(criteria);
		List<EateryDTO> eateriesByCity = service.findEateryByCity(criteria);
		List<CookingStyleDTO> cookingDto = service.getAllCookingStyles();
		List<ImageDataDTO> imgList = new ArrayList<>();
		
	
		if(eateriesByName.size() < eateriesByCity.size()){
			eateriesByName = eateriesByCity;
		}
		List<EateryDTO> eateriesDto = new ArrayList<EateryDTO>();
		if (eateriesByName.size() <= 50) {
			eateriesDto  = eateriesByName.subList(0, eateriesByName.size());
		}else{
			eateriesDto  = eateriesByName.subList(0, 49);
		}
		
		
		
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
		
		PagedListHolder<EateryDTO> pagedListHolder = new PagedListHolder<EateryDTO>(eateriesDto);
        pagedListHolder.setPageSize(10);
        
        
        
      

        
        
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/search");

		redir.addFlashAttribute("recherche", recherche);
		redir.addFlashAttribute("eateriesDto", eateriesDto);
		redir.addFlashAttribute("imgdto", imgList);
		redir.addFlashAttribute("cookingDto", cookingDto);

	
		
		if(eateriesDto.size() > 0 ) {
			return modelAndView;
		}
		modelAndView.setViewName("redirect:/");
		return modelAndView;
	}
	
	@RequestMapping(value = "/eateries/reservation/{id}", method = RequestMethod.GET)
	public ModelAndView reservation(@PathVariable("id") Integer id, RedirectAttributes redir, HttpServletRequest request) {
		
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
		
		request.getSession().setAttribute("eatery", eatery);
		request.getSession().setAttribute("imgdto", imgdto);
	
	
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
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String confirmresa1(Model model) {
		return "search";
	}
	
	

	
				
}
