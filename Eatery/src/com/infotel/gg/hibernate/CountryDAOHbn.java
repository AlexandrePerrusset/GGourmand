package com.infotel.gg.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.infotel.gg.dao.CountryDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.Country;

@Repository
public class CountryDAOHbn extends DAOHbn implements CountryDAO{

	@Override
	public void create(Country obj) throws DAOException {
			throw new DAOException("Impossible de creer l'element");
		}
		
	

	@Override
	public Country read(Integer i) throws ModelException {
		try {
			getSession().beginTransaction();
			return getSession().find(Country.class, i);
		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de lire l'element",t);
		}
	}

	@Override
	public void update(Country obj) {
			throw new DAOException("Impossible de mettre a jour l'element");
		}
		


	@Override
	public void delete(Country obj) throws DAOException {	
			throw new DAOException("Impossible de supprimer l'element");	
	}

	
	

	@Override
	public List<Country> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
