/**
 * 
 */
package com.infotel.gg.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.infotel.gg.dao.RegionDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.Region;

/**
 * @author formation
 *
 */
public class RegionDAOHbn extends DAOHbn implements RegionDAO{

	
	@Override
	public void create(Region obj) throws DAOException {
		try {
			getSession().save(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de creer l'element",t);
		}
	}

	
	@Override
	public Region read(Integer i) throws ModelException {
		try {
			return getSession().find(Region.class, i);
		} catch (Throwable t) {
			throw new DAOException("Impossible de lire l'element",t);
		}
	}

	
	@Override
	public void update(Region obj) {
		try {
			getSession().saveOrUpdate(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de mettre a jour l'element",t);
		}
	}

	
	@Override
	public void delete(Region obj) throws DAOException {
		try {
			getSession().delete(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de supprimer l'element",t);
		}
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Region> listAll() {
		List<Region> result = null;
		String request = "SELECT reg FROM Region reg";
		Session session = getSession();
		Query q = session.createQuery(request);	
		result = q.getResultList();
		return result;
	}

}
