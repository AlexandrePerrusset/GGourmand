package com.infotel.gg.booking;

import java.io.Serializable;
import java.util.Date;

import com.infotel.gg.customer.Customer;
import com.infotel.gg.dao.jdbc.Identifiable;
import com.infotel.gg.eatery.Eatery;

public class Booking implements Identifiable, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 617305149316556133L;
	private long id;
	private Date dateTime;
	private Customer customer;
	private Eatery eatery;
	private int nbOfCustomer;
	
	
	
	
	public Booking(long id, Date dateTime, int nbOfCustomer) {
		super();
		this.id = id;
		this.dateTime = dateTime;
		this.nbOfCustomer = nbOfCustomer;
	}
	public Booking(long id, Date dateTime, int nbOfCustomer, Eatery e, Customer c) {
		super();
		this.id = id;
		this.dateTime = dateTime;
		this.nbOfCustomer = nbOfCustomer;
		this.eatery = e;
		this.customer = c;
	}
	public Booking( Date dateTime, int nbOfCustomer, Eatery e, Customer c) {
		super();
		
		this.dateTime = dateTime;
		this.nbOfCustomer = nbOfCustomer;
		this.eatery = e;
		this.customer = c;
	}
	

	

	
	/**
	 * @return the dateTime
	 */
	public Date getDateTime() {
		return dateTime;
	}
	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(Date dateTime) {
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
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	//Reservation
	public boolean isValid() {
		String[] midi;
		String[] soir;
		if(eatery == null || customer == null || eatery.getPracticalIformation() == null || !(nbOfCustomer>= 0)) return false;
		if(eatery.getPracticalIformation().getHoursOfOperation1() == null){
			midi = eatery.getPracticalIformation().getHoursOfOperation1().split("-");
			if((dateTime.getHours() >= Integer.parseInt(midi[0])  &&  dateTime.getHours() <= Integer.parseInt(midi[1]))){
				return true;
				
			}
			return false;
		}else{
			midi = eatery.getPracticalIformation().getHoursOfOperation1().split("-");
			soir = eatery.getPracticalIformation().getHoursOfOperation2().split("-");
//			Date midi1 = new Date(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay(), Integer.parseInt(midi[0]), dateTime.getMinutes() );
//			Date midi2 = new Date(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay(), Integer.parseInt(midi[1]), dateTime.getMinutes() );
//			Date soir1 = new Date(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay(), Integer.parseInt(soir[0]), dateTime.getMinutes() );
//			Date soir2 = new Date(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay(), Integer.parseInt(soir[1]), dateTime.getMinutes() );
			if((dateTime.getHours() >= Integer.parseInt(midi[0])  &&  dateTime.getHours() <= Integer.parseInt(midi[1])) || (dateTime.getHours() >= Integer.parseInt(soir[0])  &&  dateTime.getHours() <= Integer.parseInt(soir[1]))){
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
		return "Booking [id=" + id + ", dateTime=" + dateTime + ", customer=" + customer + ", eatery=" + eatery
				+ ", nbOfCustomer=" + nbOfCustomer + "]";
	}
	
	
}
