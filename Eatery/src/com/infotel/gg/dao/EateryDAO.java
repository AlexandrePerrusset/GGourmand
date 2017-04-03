package com.infotel.gg.dao;

import com.infotel.gg.model.Eatery;
import com.infotel.gg.model.EateryResult;
import com.infotel.gg.model.SearchCriteria;

public interface EateryDAO extends DAO<Eatery, Integer>{
	public EateryResult findByCriteria(SearchCriteria criter);

}
