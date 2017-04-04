package com.infotel.gg.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.infotel.gg.DTO.CustomerDTO;
import com.infotel.gg.dao.BookingDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.model.Booking;


@Repository
public class BookingDAOHbn extends DAOHbn implements BookingDAO {

	@Override
	public void create(Booking obj) throws DAOException {
		try {
			getSession().save(obj);
			
		} catch (Throwable t) {
			throw new DAOException("Impossible de creer l'element",t);
		}
		
	}

	@Override
	public Booking read(Integer i) throws DAOException {
		try {
			
			return getSession().find(Booking.class, i);
		} catch (Throwable t) {
			throw new DAOException("Impossible de lire l'element",t);
		}
	}

	@Override
	public void update(Booking obj) {
		try {
			
			getSession().saveOrUpdate(obj);
	
		} catch (Throwable t) {
			throw new DAOException("Impossible de mettre a jour l'element",t);
		}
		
	}

	@Override
	public void delete(Booking obj) throws DAOException {
		try {
	
			getSession().delete(obj);

		} catch (Throwable t) {
			throw new DAOException("Impossible de supprimer l'element",t);
		}
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Booking> listAll() {
		List<Booking> result = null;
		String request = "SELECT book FROM Booking book";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(request);	
		result = q.getResultList();
		return result;
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Booking> listAll(CustomerDTO customerdto){
		String request = "SELECT boo FROM Booking boo WHERE boo.customer.username ='"+customerdto.getUsername()+"'";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(request);	
		List<Booking> result = q.getResultList();
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Booking> findByEateryId(int eateryId) throws GGourmandException {
		String request = "from Booking b where b.eatery.id = :eateryId and "
				+ "b not in (select br.booking from BookingReport br)";
		Query q = getSession().createQuery(request);	
		q.setParameter("eateryId", eateryId);
		List<Booking> bookings = q.getResultList();

		return bookings;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Booking> findByCustomer(String username) {
		
		String hql = "select b from Booking b where b.customer.username = :customer_id order by b.dateTime";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(hql);	
		q.setParameter("customer_id", username);
		List<Booking> bookings = q.getResultList();
		return bookings;
	}

	
}
