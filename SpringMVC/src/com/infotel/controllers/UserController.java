package com.infotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infotel.gg.service.UserService;

@Controller
@EnableTransactionManagement
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String createAccount(@RequestParam("recherche") String recherche, @RequestParam("cooking") int cooking, Model model) {
		
		
		return "index";
		
	}
}
