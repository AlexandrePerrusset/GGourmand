
package com.infotel.gg.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.infotel.gg.dao.CookingStyleDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.CookingStyle;

public class CookingStyleDAOHbn extends DAOHbn implements CookingStyleDAO {


	@Override
	public void create(CookingStyle obj) throws DAOException {
		try {
			Transaction t = getSession().beginTransaction();
			getSession().save(obj);
			t.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de creer l'element",t);
			
		}
	}

	
	@Override
	public CookingStyle read(Integer i) throws ModelException {
		try {
			Transaction t = getSession().beginTransaction();
			return getSession().find(CookingStyle.class, i);
		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de lire l'element",t);
		}	
	}

	
	@Override
	public void update(CookingStyle obj) throws DAOException{
		try {
			Transaction t = getSession().beginTransaction();
			getSession().saveOrUpdate(obj);
			t.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de mettre a jour l'element",t);
		}
	}

	
	@Override
	public void delete(CookingStyle obj) throws DAOException {
		Transaction tr;
		try {
			
			tr = getSession().beginTransaction();
			getSession().delete(obj);
			tr.commit();

		} catch (Throwable t) {
			//if (tr!=null) tr.rollback();
			t.printStackTrace();			
			throw new DAOException("Impossible de supprimer l'element",t);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<CookingStyle> listAll() {
		List<CookingStyle> result = null;
		String request = "SELECT eat.cookingStyle FROM Eatery eat "
				+ "GROUP BY eat.cookingStyle.id ORDER BY count(*) DESC";
		Session session = getSession();
		Query q = session.createQuery(request);	
		result = q.getResultList();
		return result;
	}

}
