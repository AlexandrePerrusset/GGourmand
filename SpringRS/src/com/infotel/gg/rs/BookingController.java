package com.infotel.gg.rs;

import java.net.URLDecoder;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gg.DTO.BookingDTO;
import com.infotel.gg.DTO.CustomerDTO;
import com.infotel.gg.DTO.UserDTO;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.model.Eatery;
import com.infotel.gg.service.BookingService;
import com.infotel.gg.service.CatalogService;
import com.infotel.gg.service.UserService;



@RestController 
public class BookingController {

	private static final Logger log = LogManager.getLogger(BookingController.class);
	
	@Autowired
	private BookingService service;
	
	
	@RequestMapping(value="/bookings", method=RequestMethod.POST)
	@ResponseStatus(code=HttpStatus.OK)
	public void saveBooking(@RequestBody BookingDTO dto) throws GGourmandException{
		
		
		log.warn("reservation: " + dto);
		
		service.saveBookingRest(dto);
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/bookings/{id}", method=RequestMethod.GET)
	public List<BookingDTO> bookingByCustomer(@PathVariable("id") String id) throws GGourmandException{
		
		log.warn("reservation: " + id);
		return service.findBookingsByCustomer(URLDecoder.decode(id));
	}
	
	@RequestMapping(value="/bookings/customer", method=RequestMethod.POST)
	public List<BookingDTO> bookingByCustomer(@RequestBody UserDTO uDto) throws GGourmandException{
		
		log.warn("reservation pour username : " + uDto.getUsername());
		return service.findBookingsByCustomer(uDto.getUsername());
	}
}
