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
			throw new DAOException("Impossible de creer l'element");
		}
	

	
	@Override
	public Region read(Integer i) throws ModelException {
		try {
			getSession().beginTransaction();
			return getSession().find(Region.class, i);
		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de lire l'element",t);
		}
	}

	
	@Override
	public void update(Region obj) {
			throw new DAOException("Impossible de mettre a jour l'element");
		}
	

	
	@Override
	public void delete(Region obj) throws DAOException {
			throw new DAOException("Impossible de supprimer l'element");
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
