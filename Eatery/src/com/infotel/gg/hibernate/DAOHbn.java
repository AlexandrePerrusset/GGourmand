package com.infotel.gg.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

public class DAOHbn {
	
	@Autowired
	protected SessionFactory factory;
	
	public DAOHbn() {
		
	}

	protected Session getSession() {
		return factory.getCurrentSession();
	}
}
