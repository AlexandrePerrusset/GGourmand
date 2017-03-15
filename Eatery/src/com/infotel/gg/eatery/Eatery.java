package com.infotel.gg.eatery;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.infotel.gg.bookingreport.EateryManager;
import com.infotel.gg.city.Address;
import com.infotel.gg.dao.jdbc.Identifiable;

public class Eatery implements Identifiable, Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5737634769078321910L;
	private long id;
	private String name;
	private String description;
	private String executiveChef;
	
	private PracticalInformation practicalIformation;
	private CookingStyle cookingStyle;
	private Address address;
	private Menu menu;
	private List<EateryTag> eateryTags;
	private EateryManager eateryManager;
	
	
	public Eatery(long id, String name, String description, String executiveChef,
			PracticalInformation practicalIformation, CookingStyle cookingStyle, Address address, Menu menu,
			List<EateryTag> eateryTags, EateryManager eateryManager) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.executiveChef = executiveChef;
		this.practicalIformation = practicalIformation;
		this.cookingStyle = cookingStyle;
		this.address = address;
		this.menu = menu;
		this.eateryTags = eateryTags;
		this.eateryManager = eateryManager;
	}
	public Eatery(long id, String name, String description, String executiveChef) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.executiveChef = executiveChef;
		
	}
	
	
	
	
	/**
	 * @return the practicalIformation
	 */
	public PracticalInformation getPracticalIformation() {
		return practicalIformation;
	}
	/**
	 * @param practicalIformation the practicalIformation to set
	 */
	public void setPracticalIformation(PracticalInformation practicalIformation) {
		this.practicalIformation = practicalIformation;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @return the eateryTags
	 */
	public List<EateryTag> getEateryTags() {
		return eateryTags;
	}
	/**
	 * @param eateryTags the eateryTags to set
	 */
	public void setEateryTags(List<EateryTag> eateryTags) {
		this.eateryTags = eateryTags;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String tag= "";
		if(eateryTags  != null){
		
			return "Eatery [id=" + id + ", name=" + name +" ] [" + eateryTags.toString() + "]";
		}else{
			return "Eatery [id=" + id + ", name=" + name +" ]";
		}
		
	}
	
	
	
	
}
