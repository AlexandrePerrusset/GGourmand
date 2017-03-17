package com.infotel.gg.DTO;

import java.io.Serializable;
import java.util.Date;




public class BookingDTO implements Serializable {
	
	private static final long serialVersionUID = 8977381161000001L;
	private String id;
	
	
	private Date dateTime;
	
	private String numberOfPeople;
	
	private String firstName;
	
	private String lastName;
	
	private String customerId;
	
	private int eateryId;
	
	private String eateryName;
	
	private String postcode;
	
	private String street;
	
	private String cityname;

	private boolean comment;
	
	private Integer rating;
	
	private String commenttext;
	
	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getCommenttext() {
		return commenttext;
	}

	public void setCommenttext(String commenttext) {
		this.commenttext = commenttext;
	}

	public int getEateryId() {
		return eateryId;
	}

	public void setEateryId(int eateryId) {
		this.eateryId = eateryId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(String numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEateryName() {
		return eateryName;
	}

	public void setEateryName(String eateryName) {
		this.eateryName = eateryName;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCityName() {
		return cityname;
	}

	public void setCityName(String cityname) {
		this.cityname = cityname;
	}
	

	public boolean isComment() {
		return comment;
	}

	public void setComment(boolean comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "BookingDTO [id=" + id + ", dateTime=" + dateTime + ", numberOfPeople=" + numberOfPeople + ", firstName="
				+ firstName + ", lastName=" + lastName + ", customerId=" + customerId + ", eateryId=" + eateryId
				+ ", eateryName=" + eateryName + ", postcode=" + postcode + ", street=" + street + ", cityname=" + cityname
				+ "]";
	}

	
}
