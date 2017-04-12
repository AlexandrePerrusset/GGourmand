package com.infotel.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.mbeans.UserMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.infotel.gg.DTO.BookingDTO;
import com.infotel.gg.DTO.BookingReportDTO;
import com.infotel.gg.DTO.EateryDTO;
import com.infotel.gg.DTO.UserDTO;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.service.BookingService;
import com.infotel.gg.service.CatalogService;
import com.infotel.gg.service.UserService;

@Controller
@EnableTransactionManagement
public class ManagerController {
	@Autowired
	BookingService serviceBooking;
	
	@Autowired
	CatalogService serviceCatalog;
	
	@Autowired
	UserService serviceUser;

	@RequestMapping(value = "/bookings", method = RequestMethod.GET)
	public String searchBookings(Model model,HttpServletRequest request ) throws GGourmandException {
		List<BookingDTO> bookings = new ArrayList<BookingDTO>();
		UserDTO udto = (UserDTO) request.getSession().getAttribute("userM");
		int eateryId = serviceUser.findManagerByUsername(udto.getUsername()).getEateryId();
		bookings = serviceBooking.findBookingsByEateryWithoutReport(eateryId);
		
		EateryDTO eateryDto = new EateryDTO();
		eateryDto = serviceCatalog.findOneEatery(eateryId);
		
		model.addAttribute("bookings", bookings);
		model.addAttribute("eatery", eateryDto);

		return "manager";
	}
	



	@RequestMapping(value = "/report", method = RequestMethod.POST)
	public ModelAndView saveReport(HttpServletRequest request, @RequestParam(value="bookingId") int reportId, @RequestParam(value="presence", required=false) boolean presence, @RequestParam(value="montantPaye") double montant, @RequestParam(value="comment") String comment, RedirectAttributes redir) throws GGourmandException {
		BookingReportDTO brd = new BookingReportDTO();
		UserDTO udto = (UserDTO) request.getSession().getAttribute("userM");
		brd.setBookingId(reportId);
		brd.setFulfilled(presence);
		brd.setComment(comment);
		brd.setTakingAmount(montant);
		brd.seteMId(udto.getUsername());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/bookings");
		
		serviceBooking.saveBookingReport(brd);
		return modelAndView;
	}
	

}
