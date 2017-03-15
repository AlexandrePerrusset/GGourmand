package com.infotel.gg.city;

import java.io.Serializable;

import com.infotel.gg.dao.jdbc.Identifiable;

public class City implements Identifiable, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2406884507752812014L;
	private long id;
	private String name;
	private String postCode;
	private boolean foreMost;
	
	private Region region;
	private Country country;
	/**
	 * @return the id
	 */
	
	public City(long id, String name, String postCode, boolean foreMost) {
		super();
		this.id = id;
		this.name = name;
		this.postCode = postCode;
		this.foreMost = foreMost;
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
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	/**
	 * @return the foremost
	 */
	public boolean isForemost() {
		return foreMost;
	}
	/**
	 * @param foremost the foremost to set
	 */
	public void setForemost(boolean foremost) {
		this.foreMost = foremost;
	}
	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
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
		return "City [id=" + id + ", name=" + name + ", postCode=" + postCode + ", foremost=" + foreMost + ", region="
				+ region + ", country=" + country + "]";
	}
	
	
	
	
}
