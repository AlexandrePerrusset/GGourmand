package com.infotel.gg.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.infotel.gg.dao.EateryManagerDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.EateryManager;

public class EateryManagerDAOHbn extends DAOHbn implements EateryManagerDAO {

	@Override
	public void create(EateryManager obj) throws DAOException {
		try {
			getSession().save(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de creer l'element",t);
		}
	}

	@Override
	public EateryManager read(Integer i) throws ModelException {
		try {
			return getSession().find(EateryManager.class, i);
		} catch (Throwable t) {
			throw new DAOException("Impossible de lire l'element",t);
		}
	}

	@Override
	public void update(EateryManager obj) {
		try {
			getSession().saveOrUpdate(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de mettre a jour l'element",t);
		}
	}

	@Override
	public void delete(EateryManager obj) throws DAOException {
		try {
			getSession().delete(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de supprimer l'element",t);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<EateryManager> listAll() {
		List<EateryManager> result = null;
		String request = "SELECT em FROM EateryManager em";
		Session session = getSession();
		Query q = session.createQuery(request);	
		result = q.getResultList();
		return result;
	}

}
