package com.infotel.gg.city;

import com.infotel.gg.dao.jdbc.Identifiable;

public class Country implements Identifiable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3992402814327252754L;
	private long id;
	private String name;
	/**
	 * @return the id
	 */
	
	
	public Country(long id, String name) {
	
		this.id = id;
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + "]";
	}
	
	
}
