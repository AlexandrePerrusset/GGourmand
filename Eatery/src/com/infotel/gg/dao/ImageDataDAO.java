package com.infotel.gg.dao;



import java.util.List;

import com.infotel.gg.model.ImageData;

public interface ImageDataDAO extends DAO<ImageData, Integer>{

	List<Integer> findSmallByEateryId(int eateryId);
	public List<Integer> findBigByEateryId(int eateryId);
	
}
