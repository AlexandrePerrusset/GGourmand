package com.infotel.gg.model;

import java.util.Calendar;

public class BookingReport{
	private int id;
	private Calendar date;
	private boolean fulfilled;
	private String comment;
	private double takingAmount;
	private double dueAmount;
	private EateryManager eM;
	private Booking booking;
	
	
	
	
	public BookingReport(int id, Calendar date, boolean fulfilled, String comment, double takingAmount, double dueAmount) {
		this.id = id;
		this.date = date;
		this.fulfilled = fulfilled;
		this.comment = comment;
		this.takingAmount = takingAmount;
		this.dueAmount = dueAmount;
	}
	
	public BookingReport() {
	}




	/**
	 * @return the date
	 */
	public Calendar getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Calendar date) {
		this.date = date;
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
	 * @return the date
	 */
	public Calendar getCalendar() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setCalendar(Calendar date) {
		this.date = date;
	}


	/**
	 * @return the fulfilled
	 */
	public boolean isFulfilled() {
		return fulfilled;
	}
	/**
	 * @param fulfilled the fulfilled to set
	 */
	public void setFulfilled(boolean fulfilled) {
		this.fulfilled = fulfilled;
	}


	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}


	/**
	 * @return the takingAmount
	 */
	public double getTakingAmount() {
		return takingAmount;
	}
	/**
	 * @param takingAmount the takingAmount to set
	 */
	public void setTakingAmount(double takingAmount) {
		this.takingAmount = takingAmount;
	}



	/**
	 * @return the dueAmount
	 */
	public double getDueAmount() {
		return dueAmount;
	}
	/**
	 * @param dueAmount the dueAmount to set
	 */
	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}



	/**
	 * @return the eM
	 */
	public EateryManager geteM() {
		return eM;
	}
	/**
	 * @param eM the eM to set
	 */
	public void seteM(EateryManager eM) {
		this.eM = eM;
	}


	/**
	 * @return the booking
	 */
	public Booking getBooking() {
		return booking;
	}
	/**
	 * @param booking the booking to set
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BookingReport [id=" + id + ", date=" + date + ", fulfilled=" + fulfilled + ", comment=" + comment
				+ ", takingAmount=" + takingAmount + ", dueAmount=" + dueAmount + ", eM=" + eM + ", booking=" + booking
				+ "]";
	}




	
}
