package com.infotel.gg.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.infotel.gg.dao.ReviewDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.Review;

@Repository
public class ReviewDAOHbn extends DAOHbn implements ReviewDAO {

	@Override
	public void create(Review obj) throws DAOException {
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
	public Review read(Integer i) throws ModelException {
		try {
			getSession().beginTransaction();
			return getSession().find(Review.class, i);
		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de lire l'element",t);
		}
	}

	@Override
	public void update(Review obj) {
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
	public void delete(Review obj) throws DAOException {
		try {
			Transaction t = getSession().beginTransaction();
			getSession().delete(obj);
			t.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de supprimer l'element",t);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Review> listAll() {
		List<Review> result = null;
		String request = "SELECT rev FROM Review rev";
		getSession().beginTransaction();
		Query q = getSession().createQuery(request);	
		result = q.getResultList();
		return result;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Review> listAllByEateryId(int id) {
		List<Review> result = new ArrayList<>();
		String request = "SELECT re FROM Review re "
				+ "Where re.booking.eatery.id= :id ORDER BY re.booking.dateTime DESC";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(request);
		q.setParameter("id", id);
		result = q.getResultList();
		return result;
	}
	@SuppressWarnings({"rawtypes" })
	@Override
	public Review findByBookingId(int bookingId) {
		Review result = null;
		String request = "SELECT re FROM Review re "
				+ "Where re.booking.id= :bookingid";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(request);
		q.setParameter("bookingid", bookingId);
		try{
		result = (Review) q.getSingleResult();
		}
		catch (Exception e) {
		
		}
		return result;
	}

}
