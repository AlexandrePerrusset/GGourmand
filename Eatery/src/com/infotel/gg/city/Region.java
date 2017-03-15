package com.infotel.gg.city;

import com.infotel.gg.dao.jdbc.Identifiable;

public class Region implements Identifiable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5296585714694623741L;
	private long id;
	private String name;
	private Country country;
	/**
	 * @return the id
	 */
	
	public Region(long id, String name) {
		super();
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
	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Region [id=" + id + ", name=" + name + ", country=" + country + "]";
	}
	
	
	
	
}
