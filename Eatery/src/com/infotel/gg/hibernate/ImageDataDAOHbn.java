/**
 * 
 */
package com.infotel.gg.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.infotel.gg.dao.ImageDataDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.ImageData;

/**
 * @author formation
 *
 */
public class ImageDataDAOHbn extends DAOHbn implements ImageDataDAO {

	
	@Override
	public void create(ImageData obj) throws DAOException {
		try {
			getSession().save(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de creer l'element",t);
		}
	}

	
	@Override
	public ImageData read(Integer i) throws ModelException {
		try {
			return getSession().find(ImageData.class, i);
		} catch (Throwable t) {
			throw new DAOException("Impossible de lire l'element",t);
		}
	}

	
	@Override
	public void update(ImageData obj) {
		try {
			getSession().saveOrUpdate(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de mettre a jour l'element",t);
		}
	}

	
	@Override
	public void delete(ImageData obj) throws DAOException {
		try {
			getSession().delete(obj);
		} catch (Throwable t) {
			throw new DAOException("Impossible de supprimer l'element",t);
		}
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<ImageData> listAll() {
		List<ImageData> result = null;
		String request = "SELECT img FROM ImageData img";
		Session session = getSession();
		Query q = session.createQuery(request);	
		result = q.getResultList();
		return result;
	}

}
