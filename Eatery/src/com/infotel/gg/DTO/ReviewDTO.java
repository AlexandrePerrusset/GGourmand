package com.infotel.gg.DTO;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Review")
public class ReviewDTO implements Serializable{
	
	private static final long serialVersionUID = 8977381161008051L;
	

	private Date dateTime;
	
	private int numberOfPeople;
	
	private String firstName;
	
	private String lastName;
	
	private String userName;
	
	private String comment;
	
	private Integer rating;
	
	private int bookingID;

	@Override
	public String toString() {
		return "ReviewDTO [dateTime=" + dateTime + ", numberOfPeople=" + numberOfPeople + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", userName=" + userName + ", comment=" + comment + ", rating=" + rating
				+ "]";
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}


}
