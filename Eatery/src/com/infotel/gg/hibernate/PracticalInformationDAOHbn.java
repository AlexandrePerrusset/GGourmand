package com.infotel.gg.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.infotel.gg.dao.PracticalInformationDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.PracticalInformation;

@Repository
public class PracticalInformationDAOHbn extends DAOHbn implements PracticalInformationDAO{

	@Override
	public void create(PracticalInformation obj) throws DAOException {
			throw new DAOException("Impossible de creer l'element");
		}
		
	

	@Override
	public PracticalInformation read(Integer i) throws ModelException {
		try {
			getSession().beginTransaction();
			return getSession().find(PracticalInformation.class, i);
		} catch (Throwable t) {
			t.printStackTrace();
			throw new DAOException("Impossible de lire l'element",t);
		}
	}

	@Override
	public void update(PracticalInformation obj) {
			throw new DAOException("Impossible de mettre a jour l'element");
		}
		


	@Override
	public void delete(PracticalInformation obj) throws DAOException {
			throw new DAOException("Impossible de supprimer l'element");
		}
		


	@Override
	public List<PracticalInformation> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
