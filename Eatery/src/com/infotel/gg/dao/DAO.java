package com.infotel.gg.dao;

import java.util.List;

import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;


public interface DAO<T,K> {

	void create(T obj) throws DAOException;

	T read(K i) throws ModelException;

	void update(T obj);

	void delete(T obj) throws DAOException;
	
	public List<T> listAll();
}