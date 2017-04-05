
package com.infotel.gg.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.gg.dao.EateryDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.Eatery;
import com.infotel.gg.model.EateryResult;
import com.infotel.gg.model.SearchCriteria;

@Repository
@Transactional
public class EateryDAOHbn extends DAOHbn implements EateryDAO {

	
	@Override
	public void create(Eatery obj) throws DAOException {
			throw new DAOException("Impossible de creer l'element");
	}
	
	@Override
	public Eatery read(Integer i) throws ModelException {
		try {
			return getSession().find(Eatery.class, i);
		} catch (Throwable t) {
			throw new DAOException("Impossible de lire l'element",t);
		}
	}
	
	@Override
	public void update(Eatery obj) {

			throw new DAOException("Impossible de mettre a jour l'element");
	}
	
	@Override
	public void delete(Eatery obj) throws DAOException {
			throw new DAOException("Impossible de supprimer l'element");
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Eatery> listAll() {
		List<Eatery> result = null;
		String request = "SELECT eat FROM Eatery eat";
		Session session = getSession();
		Query q = session.createQuery(request);	
		result = q.getResultList();
		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public EateryResult findByCriteria(SearchCriteria criter) {		
		String request = "select eat from Eatery eat where 1 = 1";
		if(criter.getName()!=null) {
			request +=" and eat.name LIKE :name";
		}
		if(criter.getCityId() != -1) {
			request +=" and eat.address.city.id = :cityId";
		} 
		if(criter.getCookingStyleId() != -1) {
			request +=" and eat.cookingStyle.id = :cookingStyleId";
		}
		
		Query q = getSession().createQuery(request);		
		
		if(criter.getName()!=null) {
			q.setParameter("name", "%"+criter.getName()+"%");
		}
		if(criter.getCityId() != -1) {
			q.setParameter("cityId", criter.getCityId());
		}
		if(criter.getCookingStyleId() != -1) {
			q.setParameter("cookingStyleId", criter.getCookingStyleId());
		}
		q.setMaxResults(5);
		
		List<Eatery> result = q.getResultList();
		return new EateryResult(result.size(), result); 
	}

}
