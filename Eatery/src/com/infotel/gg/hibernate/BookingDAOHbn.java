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
			Transaction t = getSession().beginTransaction();
			getSession().save(obj);
			t.commit();
		} catch (Throwable t) {
			throw new DAOException("Impossible de creer l'element",t);
		}
		
	}

	@Override
	public Booking read(Integer i) throws DAOException {
		try {
			getSession().beginTransaction();
			return getSession().find(Booking.class, i);
		} catch (Throwable t) {
			throw new DAOException("Impossible de lire l'element",t);
		}
	}

	@Override
	public void update(Booking obj) {
		try {
			Transaction t = getSession().beginTransaction();
			getSession().saveOrUpdate(obj);
			t.commit();
		} catch (Throwable t) {
			throw new DAOException("Impossible de mettre a jour l'element",t);
		}
		
	}

	@Override
	public void delete(Booking obj) throws DAOException {
		try {
			Transaction tr = getSession().beginTransaction();
			getSession().delete(obj);
			tr.commit();
		} catch (Throwable t) {
			throw new DAOException("Impossible de supprimer l'element",t);
		}
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Booking> listAll() {
		List<Booking> result = null;
		String request = "SELECT book FROM Booking book";
		Session session = getSession();
		Query q = session.createQuery(request);	
		result = q.getResultList();
		return result;
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Booking> listAll(CustomerDTO customerdto){
		String request = "SELECT boo FROM Booking boo WHERE boo.customer.username ='"+customerdto.getUsername()+"'";
		Session session = getSession();
		Query q = session.createQuery(request);	
		List<Booking> result = q.getResultList();
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Booking> findByEateryId(int eateryId) throws GGourmandException {
		String request = "from Booking b where b.eatery.id = :eateryId and "
				+ "b not in (select br.booking from BookingReport br)";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(request);
		query.setParameter("eateryId", eateryId);
		List<Booking> bookings = query.getResultList();

		return bookings;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Booking> findByCustomer(String username) {
		Session session = getSession();
		String hql = "select b from Booking b where b.customer.username = :customer_id order by b.dateTime";
		Query query = session.createQuery(hql);
		query.setParameter("customer_id", username);
		List<Booking> bookings = query.getResultList();
		return bookings;
	}

	
}
