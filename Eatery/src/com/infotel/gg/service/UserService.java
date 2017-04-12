package com.infotel.gg.service;
import com.infotel.gg.DTO.CustomerDTO;
import com.infotel.gg.DTO.EateryManagerDTO;
import com.infotel.gg.DTO.UserDTO;
import com.infotel.gg.exception.AuthenticationException;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.Customer;

public interface UserService {
	
	UserDTO authenticate(String username, String password) throws AuthenticationException;
	
	void register (UserDTO userDto) throws GGourmandException;

	CustomerDTO findCustomerByUsername(String username);

	EateryManagerDTO findManagerByUsername(String username);
}
