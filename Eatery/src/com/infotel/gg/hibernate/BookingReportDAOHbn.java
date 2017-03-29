package com.infotel.gg.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.infotel.gg.dao.BookingReportDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.BookingReport;

public class BookingReportDAOHbn extends DAOHbn implements BookingReportDAO {
	
	@Override
	public void create(BookingReport obj) throws DAOException {
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
	public BookingReport read(Integer i) throws ModelException {
		try {
			getSession().beginTransaction();
			return getSession().find(BookingReport.class, i);
		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de lire l'element",t);
		}
	}

	@Override
	public void update(BookingReport obj) throws DAOException {
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
	public void delete(BookingReport obj) throws DAOException {
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
	public List<BookingReport> listAll() {
		List<BookingReport> result = null;
		String request = "SELECT br FROM BookingReport br";
		Session session = getSession();
		Query q = session.createQuery(request);	
		result = q.getResultList();
		return result;
	}
	
}
