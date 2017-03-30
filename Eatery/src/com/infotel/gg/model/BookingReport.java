package com.infotel.gg.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity @Table(name="booking_report") 
public class BookingReport{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="input_date")
	private Calendar date;
	
	@Column(name="fulfilled")
	private boolean fulfilled;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="taking_amount")
	private double takingAmount;
	
	@Column(name="due_amount")
	private double dueAmount;
	
	@ManyToOne @JoinColumn(name="manager_id")
	private EateryManager eM;
	
	@ManyToOne @JoinColumn(name="booking_id", unique=true)
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




	public BookingReport(int id, Calendar date, boolean fulfilled, String comment, double takingAmount,
			double dueAmount, EateryManager eM, Booking booking) {
		super();
		this.id = id;
		this.date = date;
		this.fulfilled = fulfilled;
		this.comment = comment;
		this.takingAmount = takingAmount;
		this.dueAmount = dueAmount;
		this.eM = eM;
		this.booking = booking;
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
