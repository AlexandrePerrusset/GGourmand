package com.infotel.gg.eatery;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.infotel.gg.bookingreport.EateryManager;
import com.infotel.gg.city.Address;

public class Eatery implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5737634769078321910L;
	private Integer id;
	private String name;
	private String description;
	private String executiveChef;
	
	private PracticalInformation practicalIformation;
	private CookingStyle cookingStyle;
	private Address address;
	private Menu menu;
	private List<EateryTag> eateryTags;
	private EateryManager eateryManager;
	
	
	public Eatery(Integer id, String name, String description, String executiveChef,
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
	public Eatery(Integer id, String name, String description, String executiveChef) {

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
	public Integer getId() {
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
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the executiveChef
	 */
	public String getExecutiveChef() {
		return executiveChef;
	}
	/**
	 * @param executiveChef the executiveChef to set
	 */
	public void setExecutiveChef(String executiveChef) {
		this.executiveChef = executiveChef;
	}
	/**
	 * @return the cookingStyle
	 */
	public CookingStyle getCookingStyle() {
		return cookingStyle;
	}
	/**
	 * @param cookingStyle the cookingStyle to set
	 */
	public void setCookingStyle(CookingStyle cookingStyle) {
		this.cookingStyle = cookingStyle;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * @return the menu
	 */
	public Menu getMenu() {
		return menu;
	}
	/**
	 * @param menu the menu to set
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	/**
	 * @return the eateryManager
	 */
	public EateryManager getEateryManager() {
		return eateryManager;
	}
	/**
	 * @param eateryManager the eateryManager to set
	 */
	public void setEateryManager(EateryManager eateryManager) {
		this.eateryManager = eateryManager;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
