package com.infotel.gg.model;



public class Customer extends Person{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7503481568662049568L;
	private String title;
	private String phone;
	
	
	
	
	
	
	public Customer(String firstName, String lastName, String title, String phone, String login, String mdp) {
		super(firstName, lastName, login, mdp);
		this.setTitle(title);
		this.setPhone(phone);
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		
		this.title = title;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.getUsername();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [title=" + title + ", phone=" + phone + ", getTitle()=" + getTitle() + ", getPhone()="
				+ getPhone() + ", getEmail()=" + getEmail() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword() + "]";
	}
	
	
	
	
	
}
