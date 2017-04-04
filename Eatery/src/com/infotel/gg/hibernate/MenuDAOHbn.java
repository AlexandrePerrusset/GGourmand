package com.infotel.gg.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.infotel.gg.dao.MenuDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.Menu;

@Repository
public class MenuDAOHbn extends DAOHbn implements MenuDAO{

	@Override
	public void create(Menu obj) throws DAOException {
			throw new DAOException("Impossible de creer l'element");
		}
		
	

	@Override
	public Menu read(Integer i) throws ModelException {
		try {
			return getSession().find(Menu.class, i);
		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de lire l'element");
		}
	}

	@Override
	public void update(Menu obj) {
			throw new DAOException("Impossible de mettre a jour l'element");
		}
		


	@Override
	public void delete(Menu obj) throws DAOException {
			throw new DAOException("Impossible de supprimer l'element");
		}
		


	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Menu> listAll() {
		List<Menu> result = null;
		String request = "SELECT men FROM Menu men";
		Session session = getSession();
		Query q = session.createQuery(request);	
		result = q.getResultList();
		return result;
	}

}
