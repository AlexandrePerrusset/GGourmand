package com.infotel.gg.dao;

import java.util.List;

import com.infotel.gg.execption.UserException;

public interface DAO<T,K> {

	void create(T obj) throws UserException;

	T read(K i);

	void update(T obj);

	void delete(T obj);

	void deleteById(K id);
	
	public List<T> listAll();
	
	K getId(T obj); 
	
	void setId(K id, T obj);

}