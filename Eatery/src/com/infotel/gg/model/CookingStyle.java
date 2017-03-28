package com.infotel.gg.model;

import com.infotel.gg.exception.ModelException;
import com.mysql.jdbc.StringUtils;

public class CookingStyle {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8880518127996567425L;
	private int id;
	private String name;

	public CookingStyle(int id, String name) {
		setId(id);
		setName(name);
	}

	public CookingStyle() {
	}

	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 * @throws ModelException
	 */
	public void setId(int id) {

		this.id = id;

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 * @throws ModelException
	 */
	public void setName(String name) {
		this.name = name;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CookingStyle [id=" + id + ", name=" + name + ", getId()=" + getId() + ", getName()=" + getName() + "]";
	}
}
