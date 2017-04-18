package com.infotel.gg.rs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gg.DTO.BookingDTO;
import com.infotel.gg.DTO.CustomerDTO;
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
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private CatalogService catalogService;
	
	@RequestMapping(value="/bookings", method=RequestMethod.POST)
	@ResponseStatus(code=HttpStatus.OK)
	public void saveBooking(@RequestBody BookingDTO dto) throws GGourmandException{
		
		if (log.isDebugEnabled()) {
			log.debug("reservation: " + dto);
		}
		
		CustomerDTO customer = userService.findCustomerByUsername(dto.getCustomerId());
		dto.setCustomerId(customer.getUsername());
		
		Eatery eatery = catalogService.findOneRealEatery(dto.getEateryId());
		dto.setEateryId(eatery.getId());
		service.saveBooking(dto);
	}
}
