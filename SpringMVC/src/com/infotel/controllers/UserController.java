package com.infotel.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	private String authentification(@RequestParam(value = "username", required=true) String username, @RequestParam(value = "password", required=true) String password, HttpServletRequest request) throws AuthenticationException{
		
		if (isConnected(request) == true) {
			return "profil";
		}else {
			UserDTO user = service.authenticate(username, password);
			if (user != null) {
				request.getSession().setAttribute("user", user);
				return "profil";
			}
		}
		
		return "noresults";
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
	
}
