
package com.infotel.gg.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.infotel.gg.dao.CookingStyleDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.CookingStyle;

public class CookingStyleDAOHbn extends DAOHbn implements CookingStyleDAO {


	@Override
	public void create(CookingStyle obj) throws DAOException {
		try {
			getSession().save(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de creer l'element",t);
		}
	}

	
	@Override
	public CookingStyle read(Integer i) throws ModelException {
		try {
			return getSession().find(CookingStyle.class, i);
		} catch (Throwable t) {
			throw new DAOException("Impossible de lire l'element",t);
		}	
	}

	
	@Override
	public void update(CookingStyle obj) {
		try {
			getSession().saveOrUpdate(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de mettre a jour l'element",t);
		}
	}

	
	@Override
	public void delete(CookingStyle obj) throws DAOException {
		try {
			getSession().delete(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de supprimer l'element",t);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<CookingStyle> listAll() {
		List<CookingStyle> result = null;
		String request = "SELECT cs FROM CookingStyle cs";
		Session session = getSession();
		Query q = session.createQuery(request);	
		result = q.getResultList();
		return result;
	}

}
