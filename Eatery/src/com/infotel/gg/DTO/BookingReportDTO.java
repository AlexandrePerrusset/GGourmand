package com.infotel.gg.DTO;

import java.util.Calendar;

import com.infotel.gg.model.Booking;
import com.infotel.gg.model.EateryManager;

public class BookingReportDTO {

	private int id;
	
	private Calendar date;
	
	private boolean fulfilled;
	
	private String comment;
	
	private double takingAmount;
	
	private double dueAmount;
	
	private String eMId;
	
	private int bookingId;

	public String geteMId() {
		return eMId;
	}

	public void seteMId(String eMId) {
		this.eMId = eMId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public boolean isFulfilled() {
		return fulfilled;
	}

	public void setFulfilled(boolean fulfilled) {
		this.fulfilled = fulfilled;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getTakingAmount() {
		return takingAmount;
	}

	public void setTakingAmount(double takingAmount) {
		this.takingAmount = takingAmount;
	}

	public double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}

	
	
	
}
