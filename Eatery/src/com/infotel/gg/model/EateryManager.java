package com.infotel.gg.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity @DiscriminatorValue("manager")
public class EateryManager extends Person{
	
	@OneToOne @JoinColumn(name="eatery_id", unique=true)
	private Eatery eatery;
	
	public EateryManager(String firstName, String lastName, String mdp, String login, Eatery ea) {
		super(firstName, lastName, mdp, login);
		eatery = ea;
	}
	
	
	public EateryManager(String firstName, String lastName, String login, String mdp) {
		super(firstName, lastName, login, mdp);
	}

	public EateryManager() {
		
	}


	/**
	 * @return the eatery
	 */
	public Eatery getEatery() {
		return eatery;
	}

	/**
	 * @param eatery the eatery to set
	 */
	public void setEatery(Eatery eatery) {
		this.eatery = eatery;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EateryManager [eatery=" + eatery + "]";
	}



	
	

	
	
}
