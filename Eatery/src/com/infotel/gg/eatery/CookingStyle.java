package com.infotel.gg.eatery;

import com.infotel.gg.dao.jdbc.Identifiable;

public class CookingStyle implements Identifiable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8880518127996567425L;
	private long id;
	private String name;

	public CookingStyle(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
}
