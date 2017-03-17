package com.infotel.gg.city;

public class Address {
	private String street;
	private String postCode;
	private City city;
	
	
	//CONSTRUCTOR	
	
	
	public Address(String street, String postCode) {
		this.setStreet(street);
		this.setPostCode(postCode);
	}
	
	
	
	



	//GETTERS AND SETTERS
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
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
