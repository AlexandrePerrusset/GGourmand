/**
 * 
 */
package com.infotel.gg.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.infotel.gg.dao.EateryTagDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.EateryTag;

@Repository
public class EateryTagDAOHbn extends DAOHbn implements EateryTagDAO{


	@Override
	public void create(EateryTag obj) throws DAOException {
			throw new DAOException("Impossible de creer l'element");
		}
	

	
	@Override
	public EateryTag read(Integer i) throws ModelException {
		try {
			return getSession().find(EateryTag.class, i);
		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de lire l'element",t);
		}
	}


	@Override
	public void update(EateryTag obj) {
			throw new DAOException("Impossible de mettre a jour l'element");	
	}


	@Override
	public void delete(EateryTag obj) throws DAOException {
			throw new DAOException("Impossible de supprimer l'element");
		}


	
	@Override
	public List<EateryTag> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
