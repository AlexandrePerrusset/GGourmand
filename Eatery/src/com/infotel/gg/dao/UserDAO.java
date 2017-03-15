package com.infotel.gg.dao;

import com.infotel.gg.dao.jdbc.IEmail;
import com.infotel.gg.execption.UserException;

public interface UserDAO<T extends IEmail> {

	void create(T obj) throws UserException;

	T read(String i);

	void update(T obj);

	void delete(T obj);

	void delete(String id);

}