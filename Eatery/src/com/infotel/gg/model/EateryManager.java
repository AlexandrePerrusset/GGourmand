package com.infotel.gg.model;

public class EateryManager extends Person{
	
	private Eatery eatery;
	
	public EateryManager(String firstName, String lastName, String mdp, String login, Eatery ea) {
		super(firstName, lastName, mdp, login);
		eatery = ea;
	}
	
	
	public EateryManager(String firstName, String lastName, String login, String mdp) {
		super(firstName, lastName, login, mdp);
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
