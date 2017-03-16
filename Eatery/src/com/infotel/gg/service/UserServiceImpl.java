package com.infotel.gg.service;

import com.infotel.gg.customer.Customer;
import com.infotel.gg.dao.DAO;

public class UserServiceImpl implements UserService{
	private DAO userDAO;

	@Override
	public Customer authenticate(String username, String password) {
		Customer user = (Customer) userDAO.read(username);
		if(user != null && password.equals(user.getPassword())){
			return user;
		}
		return null;
	}

	/**
	 * @return the userDAO
	 */
	public DAO getUserDAO() {
		return userDAO;
	}

	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(DAO userDAO) {
		this.userDAO = userDAO;
	}
	
}


