package com.infotel.gg.bookingreport;

import java.util.Date;

import com.infotel.gg.booking.Booking;

public class BookingReport{
	private long id;
	private Date date;
	private boolean fulfilled;
	private String comment;
	private double takingAmount;
	private double dueAmount;
	private EateryManager eM;
	private Booking booking;
	
	
	
	
	public BookingReport(long id, Date date, boolean fulfilled, String comment, double takingAmount, double dueAmount) {
		super();
		this.id = id;
		this.date = date;
		this.fulfilled = fulfilled;
		this.comment = comment;
		this.takingAmount = takingAmount;
		this.dueAmount = dueAmount;
	}




	public long getId() {
	
		return id;
	}
}
