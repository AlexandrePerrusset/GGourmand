package com.infotel.gg.eatery;

import java.io.Serializable;



public class PracticalInformation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4536914283626180346L;
	private Integer id;
	private String hoursOfOperation1;
	private String hoursOfOperation2;
	private String price;
	private String paymentOptions;
	private String gettingThere;
	private String parking;
	private Eatery eatery;
	
	
	
	public PracticalInformation(Integer id, String hoursOfOperation1, String hoursOfOperation2, String price,
			String paymentOptions, String gettingThere, String parking) {
		setId(id);
		setHoursOfOperation1(hoursOfOperation1);
		setHoursOfOperation2(hoursOfOperation2);
		setPrice(price);
		setPaymentOptions(paymentOptions);
		setGettingThere(gettingThere);
		setParking(parking);
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the hoursOfOperation1
	 */
	public String getHoursOfOperation1() {
		return hoursOfOperation1;
	}
	/**
	 * @param hoursOfOperation1 the hoursOfOperation1 to set
	 */
	public void setHoursOfOperation1(String hoursOfOperation1) {
		this.hoursOfOperation1 = hoursOfOperation1;
	}
	/**
	 * @return the hoursOfOperation2
	 */
	public String getHoursOfOperation2() {
		return hoursOfOperation2;
	}
	/**
	 * @param hoursOfOperation2 the hoursOfOperation2 to set
	 */
	public void setHoursOfOperation2(String hoursOfOperation2) {
		this.hoursOfOperation2 = hoursOfOperation2;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the paymentOptions
	 */
	public String getPaymentOptions() {
		return paymentOptions;
	}
	/**
	 * @param paymentOptions the paymentOptions to set
	 */
	public void setPaymentOptions(String paymentOptions) {
		this.paymentOptions = paymentOptions;
	}
	/**
	 * @return the gettingThere
	 */
	public String getGettingThere() {
		return gettingThere;
	}
	/**
	 * @param gettingThere the gettingThere to set
	 */
	public void setGettingThere(String gettingThere) {
		this.gettingThere = gettingThere;
	}
	/**
	 * @return the parking
	 */
	public String getParking() {
		return parking;
	}
	/**
	 * @param parking the parking to set
	 */
	public void setParking(String parking) {
		this.parking = parking;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PracticalInformation [getId()=" + getId() + ", getHoursOfOperation1()=" + getHoursOfOperation1()
				+ ", getHoursOfOperation2()=" + getHoursOfOperation2() + ", getPrice()=" + getPrice()
				+ ", getPaymentOptions()=" + getPaymentOptions() + ", getGettingThere()=" + getGettingThere()
				+ ", getParking()=" + getParking() + "]";
	}
}
