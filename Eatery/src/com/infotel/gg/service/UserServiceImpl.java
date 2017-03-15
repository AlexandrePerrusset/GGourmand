package com.infotel.gg.service;

import com.infotel.gg.dao.UserDAO;
import com.infotel.gg.dao.jdbc.IEmail;

public class UserServiceImpl implements UserService{
	private UserDAO userDAO;

	@Override
	public IEmail authenticate(String username, String password) {
		IEmail user = userDAO.read(username);
		if(user != null && password.equals(user.getPassword())){
			return user;
		}
		return null;
	}

	/**
	 * @return the userDAO
	 */
	public UserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
}


