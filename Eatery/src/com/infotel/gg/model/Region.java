package com.infotel.gg.model;

import com.infotel.gg.exception.ModelException;
import com.mysql.jdbc.StringUtils;

public class Region {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5296585714694623741L;
	private int id;
	private String name;
	private Country country;

	// CONSTRUCTOR
	public Region(int id, String name) {
		this.setId(id);
		this.setName(name);
	}

	public Region() {

	}

	// GETTERS AND SETTERS
	/**
	 * @return the id
	 */
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

	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Region [getId()=" + getId() + ", getName()=" + getName() + ", getCountry()=" + getCountry() + "]";
	}

}
