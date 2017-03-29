package com.infotel.gg.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Address {
	
	@Column(name="street")
	private String street;
	
	@Column(name="post_code")
	private String postCode;
	
	@ManyToOne @JoinColumn(name="city_id", unique=true)
	private City city;
	
	@ManyToOne @JoinColumn(name="id", unique=true,insertable=false, updatable=false)
	private Eatery eatery;
	
	
	//CONSTRUCTOR	
	
	
	public Address(String street, String postCode) {
		this.setStreet(street);
		this.setPostCode(postCode);
	}
	
	public Address() {
	}

	//GETTERS AND SETTERS
	/**
	 * @return the street
	 */
	
	
	
	public String getStreet() {
		return street;
	}
	/**
	 * @return the eatery
	 */
	public Eatery getEatery() {
		return eatery;
	}

	/**
	 * @param eatery the eatery to set
	 */
	public void setEatery(Eatery eatery) {
		this.eatery = eatery;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
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
	 * @return the city
	 */
	public City getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [getStreet()=" + getStreet() + ", getPostCode()=" + getPostCode() + ", getCity()=" + getCity()
				+ "]";
	}
	
	
	

	
	
}
