package com.infotel.gg.dao;

import java.util.List;

import com.infotel.gg.model.City;

public interface CityDAO extends DAO<City, Integer>{
	List<City> listAll(String keyword);
	public List<City> listAllforemost();

	
}
