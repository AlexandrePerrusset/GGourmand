package com.infotel.gg.dao;

import com.infotel.gg.dao.jdbc.Identifiable;

public interface DAO<T extends Identifiable> {

	void create(T obj);

	T read(int i);

	void update(T obj);

	void delete(T obj);

	void delete(long id);

}