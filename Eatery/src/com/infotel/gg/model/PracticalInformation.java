package com.infotel.gg.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity @Table(name="practical_information") 
public class PracticalInformation implements Serializable{
	
	private static final long serialVersionUID = 4536914283626180346L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="hours_of_operation1")
	private String hoursOfOperation1;
	
	@Column(name="hours_of_operation2")
	private String hoursOfOperation2;
	
	@Column(name="price")
	private String price;
	
	@Column(name="payment_options")
	private String paymentOptions;
	
	@Column(name="getting_there")
	private String gettingThere;
	
	@Column(name="parking")
	private String parking;
	
	@OneToOne(cascade=CascadeType.ALL)  @JoinColumn(name="id") 
	@MapsId
	private Eatery eatery;
	
	
	
	public PracticalInformation(int id, String hoursOfOperation1, String hoursOfOperation2, String price,
			String paymentOptions, String gettingThere, String parking) {
		setId(id);
		setHoursOfOperation1(hoursOfOperation1);
		setHoursOfOperation2(hoursOfOperation2);
		setPrice(price);
		setPaymentOptions(paymentOptions);
		setGettingThere(gettingThere);
		setParking(parking);
	}
	
	
	public PracticalInformation() {
	
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
