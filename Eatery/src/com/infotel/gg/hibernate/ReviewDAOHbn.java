package com.infotel.gg.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.gg.dao.ReviewDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.Booking;
import com.infotel.gg.model.Review;

@Repository
@Transactional
public class ReviewDAOHbn extends DAOHbn implements ReviewDAO {

	@Override
	public void create(Review obj) throws DAOException {
		try {
			getSession().save(obj);
		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de creer l'element",t);
		}
	}

	@Override
	public Review read(Integer i) throws ModelException {
		try {
			return getSession().find(Review.class, i);
		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de lire l'element",t);
		}
	}

	@Override
	public void update(Review obj) {
		try {
			getSession().saveOrUpdate(obj);
		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de mettre a jour l'element",t);
		}
	}

	@Override
	public void delete(Review obj) throws DAOException {
		try {
			getSession().delete(obj);
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
		Query q = getSession().createQuery(request);
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
		Query q = getSession().createQuery(request);
		q.setParameter("bookingid", bookingId);
		try{
		result = (Review) q.getSingleResult();
		}
		catch (Exception e) {
		
		}
		return result;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Review> findByCustomer(String username) {
		String hql = "select r from Review r, Booking b where b.id = r.booking and b.customer.username = :customer order by b.dateTime DESC";
		Query q = getSession().createQuery(hql);	
		q.setParameter("customer", username);
		List<Review> reviews = q.getResultList();
		return reviews;
	}

}
