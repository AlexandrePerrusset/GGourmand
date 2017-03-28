/**
 * 
 */
package com.infotel.gg.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.infotel.gg.dao.EateryTagDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.EateryTag;

/**
 * @author formation
 *
 */
public class EateryTagDAOHbn extends DAOHbn implements EateryTagDAO{


	@Override
	public void create(EateryTag obj) throws DAOException {
		try {
			getSession().save(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de creer l'element",t);
		}
	}

	
	@Override
	public EateryTag read(Integer i) throws ModelException {
		try {
			return getSession().find(EateryTag.class, i);
		} catch (Throwable t) {
			throw new DAOException("Impossible de lire l'element",t);
		}
	}


	@Override
	public void update(EateryTag obj) {
		try {
			getSession().saveOrUpdate(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de mettre a jour l'element",t);
		}
	}


	@Override
	public void delete(EateryTag obj) throws DAOException {
		try {
			getSession().delete(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de supprimer l'element",t);
		}
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<EateryTag> listAll() {
		List<EateryTag> result = null;
		String request = "SELECT eattag FROM EateryTag eattag";
		Session session = getSession();
		Query q = session.createQuery(request);	
		result = q.getResultList();
		return result;
	}

}
