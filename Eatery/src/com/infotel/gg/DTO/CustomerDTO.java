package com.infotel.gg.DTO;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
	
	
	private static final long serialVersionUID = 89773811610000034L;
	
	private String username;
	private String firstName;
	private String lastName;
	private String title;
	private String phone;
	

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CustomerDTO [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", title="
				+ title + ", phone=" + phone + "]";
	}
}

