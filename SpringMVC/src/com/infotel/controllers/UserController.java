package com.infotel.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.infotel.gg.DTO.UserDTO;
import com.infotel.gg.exception.AuthenticationException;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.service.UserService;

@Controller
@EnableTransactionManagement
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String createAccount(@RequestParam(value="title", required=true) String title, @RequestParam(value="nom", required=true) String nom,@RequestParam(value="prenom", required=true) String prenom,@RequestParam(value="password", required=true) String password, @RequestParam(value="username", required=true) String username,@RequestParam(value="tel", required=true) String tel, HttpServletRequest request) throws GGourmandException {
		
		UserDTO uDto = new UserDTO();
		uDto.setTitle(title);
		uDto.setFirstName(prenom);
		uDto.setLastName(nom);
		uDto.setUsername(username);
		uDto.setPhone(tel);
		uDto.setType("customer");
		uDto.setPassword(password);
		
		service.register(uDto);
		
		return "index";
		
	}
	
	@RequestMapping(value="/authent", method=RequestMethod.POST)
	private String authentification(@RequestParam(value = "username", required=true) String username, @RequestParam(value = "password", required=true) String password, HttpServletRequest request) {
		UserDTO user =null;
		if (isConnected(request) == true) {
			return "index";
		}else {
			
			try {
				user = service.authenticate(username, password);
			} catch (AuthenticationException e) {
;
			}
			if (user != null) {
				request.getSession().setAttribute("user", user);
				return "index";
			}
		}
		
		return "index";
	}
	public boolean isConnected(HttpServletRequest request){
		if (request.getSession().getAttribute("user") != null) {
			return true;
		}else{
			return false;
		}
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	private String logout(HttpServletRequest request){
		
		request.getSession().invalidate();
		return "index";
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
				userM = service.authenticate(usernameM, passwordM);
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
	@RequestMapping(value="/logoutM", method=RequestMethod.GET)
	private String logoutM(HttpServletRequest request){
		
		request.getSession().invalidate();
		return "index";
	}
	
}
