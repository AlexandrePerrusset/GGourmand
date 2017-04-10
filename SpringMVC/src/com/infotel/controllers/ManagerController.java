package com.infotel.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infotel.gg.DTO.BookingDTO;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.service.BookingService;

@Controller
public class ManagerController {
	@Autowired
	BookingService service;

	@RequestMapping(value = "/manager/bookings", method = RequestMethod.GET)
	public String searchBookings(int eateryId) throws GGourmandException {
		List<BookingDTO> bookings = new ArrayList<BookingDTO>();
		bookings = service.findBookingsByEatery(eateryId);

		if (bookings.size() > 0) {
			return "manager";
		} else {
			return "noresults";
		}
	}
}
