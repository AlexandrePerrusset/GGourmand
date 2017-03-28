package com.infotel.gg.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DAOHbn {
	protected SessionFactory factory = null;
	
	public DAOHbn() {
		
	}

	protected Session getSession() {
		if(factory == null) {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();
			Transaction t = factory.getCurrentSession().beginTransaction();
		}
		
		
		return factory.getCurrentSession();
	}
}
