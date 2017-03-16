package com.infotel.gg.service;
import com.infotel.gg.customer.*;
import com.infotel.gg.exception.ModelException;

public interface UserService {
	Customer authenticate(String username, String password) throws ModelException;
}
