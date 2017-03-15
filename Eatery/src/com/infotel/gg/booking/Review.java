package com.infotel.gg.booking;

import com.infotel.gg.dao.jdbc.Identifiable;

public class Review implements Identifiable{
	private long id;
	private int rating;
	private String comment;
	private Booking booking;

	
	public Review(long id, int rating, String comment) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
	}


	@Override
	public long getId() {
		return id;
	}
}
