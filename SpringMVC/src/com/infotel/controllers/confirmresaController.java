
package com.infotel.controllers;

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

import com.infotel.gg.DTO.BookingDTO;
import com.infotel.gg.DTO.EateryDTO;
import com.infotel.gg.service.BookingService;
import com.infotel.gg.service.CatalogService;

@Controller
@EnableTransactionManagement
public class confirmresaController {
	
	@Autowired
	CatalogService service;
	
	@Autowired
	BookingService bkservice;
	

	@RequestMapping(value = "/eateries/reservation/{id}/confirmresa", method = RequestMethod.GET)
	public ModelAndView confirmresa(@PathVariable("id") Integer id, RedirectAttributes redir) {
		EateryDTO eatery = service.findOneEatery(id);
		
		
		ModelAndView modelAndView = new ModelAndView(); 
		modelAndView.setViewName("redirect:/confirmresa");
		redir.addFlashAttribute("eatery",eatery);

		return modelAndView;
	}
	
	@RequestMapping(value = "/confirmresa", method = RequestMethod.GET)
	public String confirmresa1(Model model) {
		return "confirmresa";
	}
	
	@RequestMapping(value = "/eateries/reservation/{id}/confirmresa/profil", method = RequestMethod.GET)
	public ModelAndView confirmresaProfil(@PathVariable("id") Integer id, @RequestParam("date") String date, RedirectAttributes redir) {
		
//	BookingDTO booking = new BookingDTO();
//	booking.setDateTime(date);
//	BookingDTO bookingdto = bkservice.saveBooking(booking);
		
		
		ModelAndView modelAndView = new ModelAndView(); 
		modelAndView.setViewName("redirect:/profil");


		return modelAndView;
	}
	
	@RequestMapping(value = "/profil", method = RequestMethod.GET)
	public String confirmresaProfil(Model model) {
		return "profil";
	}

}
