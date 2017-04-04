package com.infotel.gg.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.infotel.gg.dao.CityDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.model.City;

@Repository
public class CityDAOHbn extends DAOHbn implements CityDAO {

	@Override
	public void create(City obj) throws DAOException {
			throw new DAOException("Impossible de creer l'element");
	}

	@Override
	public City read(Integer i) throws DAOException {
		try {
	
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
		List<City> result = new ArrayList<>();
		String request = "SELECT cit FROM City cit ORDER BY cit.foremost DESC, cit.name ASC";
		
		Query q = getSession().createQuery(request);	
		result = q.getResultList();
		return result;
	}
	

	@SuppressWarnings("unchecked")
	public List<City> listAll(String keyword) {
		List<City> result = new ArrayList<>();
		String request = "SELECT cit FROM City cit where cit.name like :name ORDER BY cit.foremost DESC, cit.name ASC";
		Query<City> q = getSession().createQuery(request);
		q.setParameter("name", keyword+"%");
		result = q.getResultList();
		return result;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<City> listAllforemost() {
		List<City> result = new ArrayList<>();
		String request = "SELECT cit FROM City cit WHERE cit.foremost=1 ORDER BY cit.name ASC";
		Query q = getSession().createQuery(request);	
		result = q.getResultList();
		return result;
	}
}
