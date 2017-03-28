package com.infotel.gg.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.infotel.gg.dao.CountryDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.Country;

public class CountryDAOHbn extends DAOHbn implements CountryDAO{

	@Override
	public void create(Country obj) throws DAOException {
		try {
			getSession().save(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de creer l'element",t);
		}
		
	}

	@Override
	public Country read(Integer i) throws ModelException {
		try {
			return getSession().find(Country.class, i);
		} catch (Throwable t) {
			throw new DAOException("Impossible de lire l'element",t);
		}
	}

	@Override
	public void update(Country obj) {
		try {
			getSession().saveOrUpdate(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de mettre a jour l'element",t);
		}
		
	}

	@Override
	public void delete(Country obj) throws DAOException {
		try {
			getSession().delete(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de supprimer l'element",t);
		}
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Country> listAll() {
		List<Country> result = null;
		String request = "SELECT count FROM Country count";
		Session session = getSession();
		Query q = session.createQuery(request);	
		result = q.getResultList();
		return result;
	}

}
