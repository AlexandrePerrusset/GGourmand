package com.infotel.gg.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.infotel.gg.dao.BookingReportDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.BookingReport;

@Repository
public class BookingReportDAOHbn extends DAOHbn implements BookingReportDAO {
	
	@Override
	public void create(BookingReport obj) throws DAOException {
		try {
	
			getSession().save(obj);

		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de creer l'element",t);
			
		}
	}

	@Override
	public BookingReport read(Integer i) throws ModelException {
		try {
			
			return getSession().find(BookingReport.class, i);
		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de lire l'element",t);
		}
	}

	@Override
	public void update(BookingReport obj) throws DAOException {
			throw new DAOException("Impossible de mettre a jour l'element");
		}


	@Override
	public void delete(BookingReport obj) throws DAOException {	
			throw new DAOException("Impossible de supprimer l'element");
		}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<BookingReport> listAll() {
		List<BookingReport> result = null;
		String request = "SELECT br FROM BookingReport br";
		
		Query q = getSession().createQuery(request);	
		result = q.getResultList();
		return result;
	}
	
}
