package com.infotel.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infotel.gg.DTO.BookingDTO;
import com.infotel.gg.DTO.EateryDTO;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.service.BookingService;
import com.infotel.gg.service.CatalogService;

@Controller
public class ManagerController {
	@Autowired
	BookingService serviceBooking;
	
	@Autowired
	CatalogService serviceCatalog;

	@RequestMapping(value = "/manager/bookings", method = RequestMethod.GET)
	public String searchBookings(Model model) throws GGourmandException {
		List<BookingDTO> bookings = new ArrayList<BookingDTO>();
		bookings = serviceBooking.findBookingsByEatery(11);
		System.out.println("liste recuperee : " + bookings);
		EateryDTO eateryDto = new EateryDTO();
		eateryDto = serviceCatalog.findOneEatery(11);
		
		model.addAttribute("bookings", bookings);
		model.addAttribute("eatery", eateryDto);

		if (bookings.size() > 0) {
			return "manager";
		} else {
			return "noresults";
		}
	}
}
