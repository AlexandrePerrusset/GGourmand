package com.infotel.gg.service;
import com.infotel.gg.customer.*;
import com.infotel.gg.dao.jdbc.IEmail;

public interface UserService {
	IEmail authenticate(String username, String password);
}
