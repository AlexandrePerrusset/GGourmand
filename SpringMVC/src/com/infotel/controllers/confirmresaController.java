
package com.infotel.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.infotel.gg.DTO.UserDTO;
import com.infotel.gg.exception.GGourmandException;
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
	public ModelAndView confirmresaProfil(@PathVariable("id") Integer id, @RequestParam("date") String date, @RequestParam("nbper") String nbper, RedirectAttributes redir, HttpServletRequest request) {
		
	BookingDTO booking = new BookingDTO();
	

	
	if(date.isEmpty())
		date = (String) request.getSession().getAttribute("date");
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);
	Calendar calendar = Calendar.getInstance();

	try {
		calendar.setTime(formatter.parse(date));
		
		
	} catch (ParseException e1) {
		e1.printStackTrace();
	}
	String madate = formatter.format(calendar.getTime());
	
	
	UserDTO userdto =(UserDTO) request.getSession().getAttribute("user");
	booking.setDateTime(calendar);
	booking.setNumberOfPeople(nbper);
	booking.setEateryId(id);
	booking.setCustomerId(userdto.getUsername());
	try {
		bkservice.saveBooking(booking);
	} catch (GGourmandException e) {
		e.printStackTrace();
	}
		
		
		ModelAndView modelAndView = new ModelAndView(); 
		modelAndView.setViewName("redirect:/bookingsUser");


		return modelAndView;
	}


}
