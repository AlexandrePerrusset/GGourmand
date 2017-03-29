
package com.infotel.gg.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.infotel.gg.dao.EateryDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.Eatery;

public class EateryDAOHbn extends DAOHbn implements EateryDAO {

	
	@Override
	public void create(Eatery obj) throws DAOException {
			throw new DAOException("Impossible de creer l'element");
	}
	
	@Override
	public Eatery read(Integer i) throws ModelException {
		try {
			getSession().beginTransaction();
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

}
