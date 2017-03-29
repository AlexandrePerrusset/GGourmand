package com.infotel.gg.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity @Table(name="booking")
public class Booking implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 617305149316556133L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Temporal(TemporalType.DATE) 
	@Column(name="date_time")
	private Calendar dateTime;
	
	@Basic(fetch=FetchType.LAZY)
	@ManyToOne @JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToOne @JoinColumn(name="eatery_id")
	private Eatery eatery;
	
	@Column(name="nb_people")
	private int nbOfCustomer;
	
	
	
	
	public Booking(int id, Calendar dateTime, int nbOfCustomer) {
		super();
		this.id = id;
		this.dateTime = dateTime;
		this.nbOfCustomer = nbOfCustomer;
	}
	public Booking(int id, Calendar dateTime, int nbOfCustomer, Eatery e, Customer c) {
		super();
		this.id = id;
		this.dateTime = dateTime;
		this.nbOfCustomer = nbOfCustomer;
		this.eatery = e;
		this.customer = c;
	}
	public Booking( Calendar dateTime, int nbOfCustomer, Eatery e, Customer c) {
		super();
		
		this.dateTime = dateTime;
		this.nbOfCustomer = nbOfCustomer;
		this.eatery = e;
		this.customer = c;
	}
	
	public Booking() {
	}
	

	

	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the dateTime
	 */
	public Calendar getDateTime() {
		return dateTime;
	}
	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(Calendar dateTime) {
		this.dateTime = dateTime;
	}
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	 * @return the nbOfCustomer
	 */
	public int getNbOfCustomer() {
		return nbOfCustomer;
	}
	/**
	 * @param nbOfCustomer the nbOfCustomer to set
	 */
	public void setNbOfCustomer(int nbOfCustomer) {
		this.nbOfCustomer = nbOfCustomer;
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
	//Reservation
	public boolean isValid() {
		String[] midi;
		String[] soir;
		if(eatery == null || customer == null || eatery.getPracticalIformation() == null || !(nbOfCustomer>= 0)) return false;
		if(eatery.getPracticalIformation().getHoursOfOperation1() == null){
			midi = eatery.getPracticalIformation().getHoursOfOperation1().split("-");
			if((dateTime.get(Calendar.HOUR_OF_DAY) >= Integer.parseInt(midi[0])  &&  dateTime.get(Calendar.HOUR_OF_DAY) <= Integer.parseInt(midi[1]))){
				return true;
				
			}
			return false;
		}else{
			midi = eatery.getPracticalIformation().getHoursOfOperation1().split("-");
			soir = eatery.getPracticalIformation().getHoursOfOperation2().split("-");
//			Date midi1 = new Date(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay(), int.parseInt(midi[0]), dateTime.getMinutes() );
//			Date midi2 = new Date(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay(), int.parseInt(midi[1]), dateTime.getMinutes() );
//			Date soir1 = new Date(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay(), int.parseInt(soir[0]), dateTime.getMinutes() );
//			Date soir2 = new Date(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay(), int.parseInt(soir[1]), dateTime.getMinutes() );
			if((dateTime.get(Calendar.HOUR_OF_DAY) >= Integer.parseInt(midi[0])  &&  dateTime.get(Calendar.HOUR_OF_DAY) <= Integer.parseInt(midi[1])) || (dateTime.get(Calendar.HOUR_OF_DAY) >= Integer.parseInt(soir[0])  &&  dateTime.get(Calendar.HOUR_OF_DAY) <= Integer.parseInt(soir[1]))){
				return true;
			}
		
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Booking [getDateTime()=" + getDateTime() + ", getCustomer()=" + getCustomer() + ", getEatery()="
				+ getEatery() + ", getNbOfCustomer()=" + getNbOfCustomer() + ", getId()=" + getId() + ", isValid()="
				+ isValid() + "]";
	}
	
	
	
	
}
