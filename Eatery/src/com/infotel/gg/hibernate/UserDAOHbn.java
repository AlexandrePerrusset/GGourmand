
package com.infotel.gg.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.infotel.gg.dao.UserDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.User;

@Repository
public class UserDAOHbn extends DAOHbn implements UserDAO{

	
	@Override
	public void create(User obj) throws DAOException {
		try {
			getSession().save(obj);
		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de creer l'element",t);
			
		}
	}

	
	@Override
	public User read(String i) throws ModelException {
		try {
			getSession().beginTransaction();
			return getSession().find(User.class, i);
		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de lire l'element",t);
		}
	}

	
	@Override
	public void update(User obj) {
		try {
			getSession().saveOrUpdate(obj);
		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de mettre a jour l'element",t);
		}
	}

	
	@Override
	public void delete(User obj) throws DAOException {
		try {
			getSession().delete(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de supprimer l'element",t);
		}
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<User> listAll() {
		List<User> result = null;
		String request = "SELECT user FROM User user";
		Session session = getSession();
		Query q = session.createQuery(request);	
		result = q.getResultList();
		return result;
	}

}
