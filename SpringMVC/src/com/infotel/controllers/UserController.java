package com.infotel.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.infotel.gg.DTO.BookingDTO;
import com.infotel.gg.DTO.ReviewDTO;
import com.infotel.gg.DTO.UserDTO;
import com.infotel.gg.exception.AuthenticationException;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.service.BookingService;
import com.infotel.gg.service.CatalogServiceImpl;
import com.infotel.gg.service.UserService;

@Controller
@EnableTransactionManagement
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BookingService bookService;
	
	private final static Logger log = LogManager.getLogger(UserController.class);
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView createAccount(@RequestParam(value="title", required=true) String title, @RequestParam(value="nom", required=true) String nom,@RequestParam(value="prenom", required=true) String prenom,@RequestParam(value="password", required=true) String password, @RequestParam(value="username", required=true) String username,@RequestParam(value="tel", required=true) String tel, HttpServletRequest request) throws GGourmandException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/");
		
		if(prenom.trim().equals("") || nom.trim().equals("") || username.trim().equals("") || tel.trim().equals("") || password.trim().equals("")) {
			log.warn("---------------dans le IF------------------");
			return modelAndView;
		}
		
		UserDTO uDto = new UserDTO();
		uDto.setTitle(title);
		uDto.setFirstName(prenom);
		uDto.setLastName(nom);
		uDto.setUsername(username);
		uDto.setPhone(tel);
		uDto.setType("customer");
		uDto.setPassword(password);
		
		userService.register(uDto);
		
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/registerResa", method = RequestMethod.POST)
	public ModelAndView createAccountResa(@RequestParam(value="title", required=true) String title, @RequestParam(value="nom", required=true) String nom,@RequestParam(value="prenom", required=true) String prenom,@RequestParam(value="password", required=true) String password, @RequestParam(value="username", required=true) String username,@RequestParam(value="tel", required=true) String tel, HttpServletRequest request) throws GGourmandException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/reservation");
		
		if(prenom.trim().equals("") || nom.trim().equals("") || username.trim().equals("") || tel.trim().equals("") || password.trim().equals("")) {
			log.warn("---------------dans le IF registerResa------------------");
			return modelAndView;
		}
		
		UserDTO uDto = new UserDTO();
		uDto.setTitle(title);
		uDto.setFirstName(prenom);
		uDto.setLastName(nom);
		uDto.setUsername(username);
		uDto.setPhone(tel);
		uDto.setType("customer");
		uDto.setPassword(password);
		
		userService.register(uDto);
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="/authent", method=RequestMethod.POST)
	private ModelAndView authentification(@RequestParam(value = "username", required=true) String username, @RequestParam(value = "password", required=true) String password, HttpServletRequest request) {
		UserDTO user =null;
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/");
			
			try {
				user = userService.authenticate(username, password);
			} catch (AuthenticationException e) {
				e.printStackTrace();
			}
			if (user != null) {
				request.getSession().setAttribute("user", user);
			}

		return modelAndView;
	}
	
	@RequestMapping(value="/authentResa", method=RequestMethod.POST)
	private ModelAndView authentificationResa(@RequestParam(value = "username", required=true) String username, @RequestParam(value = "password", required=true) String password, HttpServletRequest request) {
		UserDTO user = null;
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/confirmresa");
			
			try {
				user = userService.authenticate(username, password);
			} catch (AuthenticationException e) {
				e.printStackTrace();
			}
			
			if (user != null) {
				request.getSession().setAttribute("user", user);
			}
			
			return modelAndView;
		}
	
	
	public boolean isConnected(HttpServletRequest request){
		if (request.getSession().getAttribute("user") != null) {
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	private ModelAndView logout(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/");
		
		request.getSession().invalidate();
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/authentM", method=RequestMethod.POST)
	private ModelAndView authentificationM(@RequestParam(value = "usernameM", required=true) String usernameM, @RequestParam(value = "passwordM", required=true) String passwordM, HttpServletRequest request) {
		UserDTO userM =null;
		ModelAndView modelAndView = new ModelAndView(); 
		modelAndView.setViewName("redirect:/bookings");
		if (isConnectedM(request) == true) {
			return modelAndView;
		}else {
			
			try {
				userM = userService.authenticate(usernameM, passwordM);
			} catch (AuthenticationException e) {
;
			}
			if (userM != null) {
				request.getSession().setAttribute("userM", userM);
				return modelAndView;
			}
		}
		modelAndView.setViewName("index");
		return modelAndView;
	}
	public boolean isConnectedM(HttpServletRequest request){
		if (request.getSession().getAttribute("userM") != null) {
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping(value = "/bookingsUser", method = RequestMethod.GET)
	public String searchBookings(Model model,HttpServletRequest request ) throws GGourmandException {
		List<BookingDTO> bookings = new ArrayList<BookingDTO>();
		
		UserDTO udto = (UserDTO) request.getSession().getAttribute("user");
		bookings = bookService.findBookingsByCustomer(udto.getUsername());

		model.addAttribute("bookings", bookings);

		if(request.getSession().getAttribute("user") != null) {
			return "profil";
		} else {
			return "index";
		}
	}
	
	@RequestMapping(value = "/infos", method = RequestMethod.GET)
	public String infos(Model model) {
		return "profil2";
	}
	
//	TODO : à finir
//	@RequestMapping(value = "/review", method = RequestMethod.POST)
//	public ModelAndView saveReview(HttpServletRequest request, @RequestParam(value="comment") String comment, @RequestParam(value="rating") int rating, @RequestParam(value="bookingID") int bookingID) {
//		ReviewDTO rdto = new ReviewDTO();
//		UserDTO udto = (UserDTO) request.getSession().getAttribute("user");
//		rdto.setComment(comment);
//		rdto.setRating(rating);
//		rdto.setBookingID(bookingID);
//		
//		
//	}
	
}
