package com.infotel.gg.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.infotel.gg.dao.CityDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.model.City;

public class CityDAOHbn extends DAOHbn implements CityDAO {

	@Override
	public void create(City obj) throws DAOException {
			throw new DAOException("Impossible de creer l'element");
	}

	@Override
	public City read(Integer i) throws DAOException {
		try {
			getSession().beginTransaction();
			return getSession().find(City.class, i);
		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de lire l'element",t);
		}
	}

	@Override
	public void update(City obj) throws DAOException {
			throw new DAOException("Impossible de mettre a jour l'element");
	}

	@Override
	public void delete(City obj) throws DAOException {
			throw new DAOException("Impossible de supprimer l'element");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<City> listAll() {
		List<City> result = null;
		String request = "SELECT cit FROM City cit";
		Session session = getSession();
		Query q = session.createQuery(request);	
		result = q.getResultList();
		return result;
	}
}
