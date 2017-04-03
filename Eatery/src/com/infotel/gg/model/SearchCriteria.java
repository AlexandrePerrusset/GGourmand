package com.infotel.gg.model;

public class SearchCriteria {
	
	// properties
	private String name;
	private int cityId;
	private int cookingStyleId;
	
	public String getName() {
		return name;
	}
	public void setName(String nom) {
		this.name = nom;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getCookingStyleId() {
		return cookingStyleId;
	}

	public void setCookingStyleId(int cookingStyleId) {
		this.cookingStyleId = cookingStyleId;
	}

	@Override
	public String toString() {
		return "SearchCriteria [name=" + name + ", cityId=" + cityId + ", cookingStyleId=" + cookingStyleId + "]";
	}
}
