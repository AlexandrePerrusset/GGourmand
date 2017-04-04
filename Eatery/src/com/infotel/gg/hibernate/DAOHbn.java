package com.infotel.gg.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

public class DAOHbn {
	
	@Autowired
	protected SessionFactory factory = null;
	
	public DAOHbn() {
		
	}

	protected Session getSession() {
		if(factory == null) {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();
			
		}
		
		
		return factory.getCurrentSession();
	}
}
