package com.infotel.gg.dao;

import java.util.List;

import com.infotel.gg.model.City;
import com.infotel.gg.model.Eatery;
import com.infotel.gg.model.SearchCriteria;

public interface CityDAO extends DAO<City, Integer>{
	List<City> listAll(String keyword);
	public List<City> listAllforemost();
	List<Eatery> findByCriteria(SearchCriteria criter);

	
}
