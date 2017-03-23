package com.infotel.gg.model;

public abstract class Person extends User{
	
	private String firstName;
	private String lastName;
	
	
	
	
	
	public Person(String firstName, String lastName, String login, String mdp) {
		
		super(login, mdp);
		this.setFirstName(firstName);
		this.setLastName(lastName);
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
