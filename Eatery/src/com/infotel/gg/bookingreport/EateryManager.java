package com.infotel.gg.bookingreport;

import com.infotel.gg.customer.Person;
import com.infotel.gg.eatery.Eatery;

public class EateryManager extends Person{
	
	private Eatery eatery;
	
	public EateryManager(String firstName, String lastName, String mdp, String login, Eatery ea) {
		super(firstName, lastName, mdp, login);
		eatery = ea;
	}

	
}
