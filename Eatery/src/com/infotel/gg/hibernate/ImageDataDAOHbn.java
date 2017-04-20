/**
 * 
 */
package com.infotel.gg.hibernate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.gg.dao.ImageDataDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.ImageData;

@Repository
@Transactional
public class ImageDataDAOHbn extends DAOHbn implements ImageDataDAO {
	
	private final static Path IMAGE_DIR = 
			Paths.get("D:\\dev\\images");
	
	@Override
	public void create(ImageData obj) throws DAOException {
		throw new DAOException("Impossible de creer l'element");
	}

	
//	@Override
//	public ImageData read(Integer i) throws ModelException {
//		try {
//				
//			return getSession().find(ImageData.class, i);
//		} catch (Throwable t) {
//			throw new DAOException("Impossible de lire l'element",t);
//		}
//	}
	
	@Override
	public ImageData read(Integer id) {
		ImageData image = getSession().get(ImageData.class, id);
		
		try {
			Path imgPath = IMAGE_DIR.resolve(id + ".png");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			Files.copy(imgPath, baos);
			image.setContent(baos.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return image;
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
		Query q = getSession().createQuery(request);	
		result = q.getResultList();
		return result;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Integer> findSmallByEateryId(int eateryId) {
		String request = "select i.id from ImageData i where i.targetId=:targetId and (i.target='food-spotting' OR i.target='eatery') and i.size='small'";
		Query q = getSession().createQuery(request);	
		q.setParameter("targetId", eateryId);
		List<Integer> result = q.getResultList();
		return result;
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Integer> findBigByEateryId(int eateryId) {
		String request = "select i.id from ImageData i where i.targetId=:targetId and (i.target='food-spotting' OR i.target='eatery') and i.size='big'";
		Query q = getSession().createQuery(request);	
		q.setParameter("targetId", eateryId);
		List<Integer> result = q.getResultList();
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public int findImageDataCityIdByTargetId(int targetId) {
		String request = "select i.id from ImageData i where i.targetId=:targetId and (i.target='city')";
		Query q = getSession().createQuery(request);	
		q.setParameter("targetId", targetId);
		return (int) q.getSingleResult();
	}

}
