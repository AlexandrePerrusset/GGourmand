
package com.infotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		
		
		
		ModelAndView modelAndView = new ModelAndView(); 
		modelAndView.setViewName("redirect:/confirmresa");

		return modelAndView;
	}
	
	@RequestMapping(value = "/confirmresa", method = RequestMethod.GET)
	public String confirmresa1(Model model) {
		return "confirmresa";
	}
	

}
