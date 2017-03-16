package com.infotel.gg.service;
import com.infotel.gg.customer.*;

public interface UserService {
	Customer authenticate(String username, String password);
}
