package com.infotel.gg.booking;


public class Review{
	private Integer id;
	private int rating;
	private String comment;
	private Booking booking;

	
	public Review(Integer id, int rating, String comment) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
	}



	public Integer getId() {
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
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
