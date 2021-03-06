package com.infotel.gg.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public abstract class Person extends User{
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	
	
	
	
	public Person(String firstName, String lastName, String login, String mdp) {
		
		super(login, mdp);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	
	
	public Person(String username, String password) {
		super(username, password);
	}

	public Person() {
		
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
