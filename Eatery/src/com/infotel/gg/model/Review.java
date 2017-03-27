package com.infotel.gg.model;


public class Review{
	private int id;
	private int rating;
	private String comment;
	private Booking booking;

	
	public Review(int id, int rating, String comment) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
	}
	


	public Review() {
		
	}



	public int getId() {
		return id;
	}



	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}



	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
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



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
}
