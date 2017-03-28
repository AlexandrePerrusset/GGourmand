package com.infotel.gg.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
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
		}
		return factory.getCurrentSession();
	}
}
