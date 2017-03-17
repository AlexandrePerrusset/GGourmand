package com.infotel.gg.DTO;

import java.io.Serializable;

public class RegionDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6965644917970126314L;
	
	private String Name;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "RegionDTO [Name=" + Name + "]";
	}

}
