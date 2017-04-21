package com.infotel.gg.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.gg.dao.CityDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.model.City;
import com.infotel.gg.model.Eatery;
import com.infotel.gg.model.SearchCriteria;

@Repository
@Transactional
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
		String request = "SELECT cit FROM City cit ORDER BY cit.foreMost DESC, cit.name ASC";
		
		Query q = getSession().createQuery(request);	
		result = q.getResultList();
		return result;
	}
	

	@SuppressWarnings("unchecked")
	public List<City> listAll(String keyword) {
		List<City> result = new ArrayList<>();
		String request = "SELECT cit FROM City cit where cit.name like :name ORDER BY cit.foreMost DESC, cit.name ASC";
		Query<City> q = getSession().createQuery(request);
		q.setParameter("name", keyword+"%");
		result = q.getResultList();
		return result;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<City> listAllforemost() {
		List<City> result = new ArrayList<>();
		String request = "SELECT cit FROM City cit WHERE cit.foreMost=1 ORDER BY cit.name ASC";
		Query q = getSession().createQuery(request);	
		result = q.getResultList();
		return result;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Eatery> findByCriteria(SearchCriteria criter) {		
		String request = "select eat from Eatery eat, City c where eat.address.city.id = c.id and c.name LIKE :name";
		
		if(criter.getCookingStyleId() != -1) {
			request +=" and eat.cookingStyle.id = :cookingStyleId";
		}
		
		Query q = getSession().createQuery(request);		

		if(criter.getCookingStyleId() != -1) {
			q.setParameter("cookingStyleId", criter.getCookingStyleId());
		}
		q.setParameter("name", "%"+criter.getName()+"%");
		
		List<Eatery> result = q.getResultList();
		return result; 
	}
}
