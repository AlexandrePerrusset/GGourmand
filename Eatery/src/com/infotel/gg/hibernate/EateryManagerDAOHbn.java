package com.infotel.gg.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.infotel.gg.dao.EateryManagerDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.EateryManager;

@Repository
public class EateryManagerDAOHbn extends DAOHbn implements EateryManagerDAO {

	@Override
	public void create(EateryManager obj) throws DAOException {
			throw new DAOException("Impossible de creer l'element");		
		}
	

	@Override
	public EateryManager read(String i) throws ModelException {
		try {
			return getSession().find(EateryManager.class, i);
		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de lire l'element");
		}
	}

	@Override
	public void update(EateryManager obj) {
			throw new DAOException("Impossible de mettre a jour l'element");
		}
	

	@Override
	public void delete(EateryManager obj) throws DAOException {
			throw new DAOException("Impossible de supprimer l'element");
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
