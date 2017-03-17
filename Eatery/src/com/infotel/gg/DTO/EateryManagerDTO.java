package com.infotel.gg.DTO;

import java.io.Serializable;

public class EateryManagerDTO implements Serializable {

	private static final long serialVersionUID = 6160252279813733191L;

	
	private String username;
	private String firstName;
	private String lastName;
	private int eateryId;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public int getEateryId() {
		return eateryId;
	}
	public void setEateryId(int eateryId) {
		this.eateryId = eateryId;
	}
	@Override
	public String toString() {
		return "EateryManagerDTO [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", eateryId=" + eateryId + "]";
	}
}
