/**
 * 
 */
package com.infotel.gg.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.infotel.gg.dao.ImageDataDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.ImageData;

@Repository
public class ImageDataDAOHbn extends DAOHbn implements ImageDataDAO {

	
	@Override
	public void create(ImageData obj) throws DAOException {
		throw new DAOException("Impossible de creer l'element");
	}

	
	@Override
	public ImageData read(Integer i) throws ModelException {
		try {
				
			return factory.getCurrentSession().find(ImageData.class, i);
		} catch (Throwable t) {
			throw new DAOException("Impossible de lire l'element",t);
		}
	}

	
	@Override
	public void update(ImageData obj) {
		throw new DAOException("Impossible de creer l'element");
	}

	
	@Override
	public void delete(ImageData obj) throws DAOException {
		throw new DAOException("Impossible de creer l'element");
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<ImageData> listAll() {
		List<ImageData> result = null;
		String request = "SELECT img FROM ImageData img";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(request);	
		result = q.getResultList();
		return result;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Integer> findSmallByEateryId(int eateryId) {
		String request = "select i.id from ImageData i where i.targetId=:targetId and (i.target='food-spotting' OR i.target='eatery') and i.size='small'";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(request);	
		q.setParameter("targetId", eateryId);
		List<Integer> result = q.getResultList();
		return result;
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Integer> findBigByEateryId(int eateryId) {
		String request = "select i.id from ImageData i where i.targetId=:targetId and (i.target='food-spotting' OR i.target='eatery') and i.size='big'";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(request);	
		q.setParameter("targetId", eateryId);
		List<Integer> result = q.getResultList();
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public int findImageDataCityIdByTargetId(int targetId) {
		String request = "select i.id from ImageData i where i.targetId=:targetId and (i.target='city')";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(request);	
		q.setParameter("targetId", targetId);
		return (int) q.getSingleResult();
	}

}
