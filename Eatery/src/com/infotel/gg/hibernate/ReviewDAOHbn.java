package com.infotel.gg.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.infotel.gg.dao.ReviewDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.Review;

public class ReviewDAOHbn extends DAOHbn implements ReviewDAO {

	@Override
	public void create(Review obj) throws DAOException {
		try {
			getSession().save(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de creer l'element",t);
		}
	}

	@Override
	public Review read(Integer i) throws ModelException {
		try {
			return getSession().find(Review.class, i);
		} catch (Throwable t) {
			throw new DAOException("Impossible de lire l'element",t);
		}
	}

	@Override
	public void update(Review obj) {
		try {
			getSession().saveOrUpdate(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de mettre a jour l'element",t);
		}
	}

	@Override
	public void delete(Review obj) throws DAOException {
		try {
			getSession().delete(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de supprimer l'element",t);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Review> listAll() {
		List<Review> result = null;
		String request = "SELECT rev FROM Review rev";
		Session session = getSession();
		Query q = session.createQuery(request);	
		result = q.getResultList();
		return result;
	}

}
