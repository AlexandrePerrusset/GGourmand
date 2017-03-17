package com.infotel.gg.service;
import com.infotel.gg.DTO.UserDTO;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.exception.ModelException;

public interface UserService {
	
	UserDTO authenticate(String username, String password) throws GGourmandException;
	
	void register (UserDTO userDto) throws ModelException;
}
