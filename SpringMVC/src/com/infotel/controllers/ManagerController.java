package com.infotel.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infotel.gg.DTO.BookingDTO;
import com.infotel.gg.DTO.BookingReportDTO;
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

	@RequestMapping(value = "/bookings", method = RequestMethod.GET)
	public String searchBookings(Model model) throws GGourmandException {
		List<BookingDTO> bookings = new ArrayList<BookingDTO>();
		bookings = serviceBooking.findBookingsByEateryWithoutReport(11);
		
		EateryDTO eateryDto = new EateryDTO();
		eateryDto = serviceCatalog.findOneEatery(11);
		
//		BookingDTO bookingDto = new BookingDTO();
//		bookingDto = serviceBooking.
		
		model.addAttribute("bookings", bookings);
		model.addAttribute("eatery", eateryDto);

		if (bookings.size() > 0) {
			return "manager";
		} else {
			return "noresults";
		}
	}
	
	@RequestMapping(value = "/report", method = RequestMethod.POST)
	public String saveReport(@RequestParam(value="bookingId") int reportId, @RequestParam(value="presence") boolean presence, @RequestParam(value="montantPaye") double montant, @RequestParam(value="comment") String comment, @RequestParam(value="bookingDate") Calendar date) throws GGourmandException {
		BookingReportDTO brd = new BookingReportDTO();
		brd.setBookingId(reportId);
		brd.setDate(date);
		brd.setFulfilled(presence);
		brd.setComment(comment);
		brd.setTakingAmount(montant);
		
		serviceBooking.saveBookingReport(brd);
		return "manager";
	}
	
}
