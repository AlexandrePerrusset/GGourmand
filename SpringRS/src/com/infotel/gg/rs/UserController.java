package com.infotel.gg.rs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gg.DTO.UserDTO;
import com.infotel.gg.exception.AuthenticationException;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.service.UserService;




@RestController @RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(value="/auth", method=RequestMethod.POST)
	public UserDTO authenticate(@RequestBody UserDTO login) throws AuthenticationException{
		return (UserDTO) service.authenticate(login.getUsername(), login.getPassword());
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ResponseStatus(code=HttpStatus.OK)
	public void register(@RequestBody UserDTO custdto) throws GGourmandException{
		service.register(custdto);
	}
}
