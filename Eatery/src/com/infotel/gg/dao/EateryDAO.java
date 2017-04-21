package com.infotel.gg.dao;

import java.util.List;

import com.infotel.gg.DTO.EateryDTO;
import com.infotel.gg.model.Eatery;
import com.infotel.gg.model.SearchCriteria;

public interface EateryDAO extends DAO<Eatery, Integer>{
	public List<Eatery> findByCriteria(SearchCriteria criter);

}
