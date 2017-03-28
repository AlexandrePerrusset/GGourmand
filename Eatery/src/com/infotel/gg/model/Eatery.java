package com.infotel.gg.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.infotel.gg.exception.ModelException;
import com.mysql.jdbc.StringUtils;

public class Eatery implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5737634769078321910L;
	private int id;
	private String name;
	private String description;
	private String executiveChef;
	
	private PracticalInformation practicalInformation;
	private CookingStyle cookingStyle;
	private Address address;
	private Menu menu;
	private List<EateryTag> eateryTags;
	private EateryManager eateryManager;
	
	
	public Eatery(int id, String name, String description, String executiveChef,
			PracticalInformation practicalIformation, CookingStyle cookingStyle, Address address, Menu menu,
			List<EateryTag> eateryTags, EateryManager eateryManager) throws ModelException {

		setId(id);
		setName(name);
		setDescription(description);
		setExecutiveChef(executiveChef);
		setPracticalIformation(practicalIformation);
		setCookingStyle(cookingStyle);
		setAddress(address);
		setMenu(menu);
		setEateryTags(eateryTags);
		setEateryManager(eateryManager);
	}
	
	public Eatery(int id, String name, String description, String executiveChef) throws ModelException {
		setId(id);
		setName(name);
		setDescription(description);
		setExecutiveChef(executiveChef);
	}
	
	
	
	
	
	
	public Eatery() {
		
	}

	/**
	 * @return the practicalIformation
	 */
	public PracticalInformation getPracticalIformation() {
		return practicalInformation;
	}
	/**
	 * @param practicalInformation the practicalIformation to set
	 * @throws ModelException 
	 */
	public void setPracticalIformation(PracticalInformation practicalInformation) throws ModelException {
		
			this.practicalInformation = practicalInformation;
		
	}
	/**
	 * @return the id
	 */
	public int getId() {
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
	 * @throws ModelException 
	 */
	public void setEateryTags(List<EateryTag> eateryTags) throws ModelException {
	
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
	 * @throws ModelException 
	 */
	public void setName(String name) throws ModelException {
	
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
	 * @throws ModelException 
	 */
	public void setDescription(String description) throws ModelException {
		
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
	 * @throws ModelException 
	 */
	public void setExecutiveChef(String executiveChef) throws ModelException {
	
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
	 * @throws ModelException 
	 */
	public void setCookingStyle(CookingStyle cookingStyle) throws ModelException {
	
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
	 * @throws ModelException 
	 */
	public void setAddress(Address address) throws ModelException {
	
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
	 * @throws ModelException 
	 */
	public void setMenu(Menu menu) throws ModelException {
	
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
	 * @throws ModelException 
	 */
	public void setEateryManager(EateryManager eateryManager) throws ModelException {
		
			this.eateryManager = eateryManager;
		
	}
	/**
	 * @param id the id to set
	 * @throws ModelException 
	 */
	public void setId(int id) throws ModelException {
		
			this.id = id;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Eatery [getPracticalIformation()=" + getPracticalIformation() + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getDescription()="
				+ getDescription() + ", getExecutiveChef()=" + getExecutiveChef() + ", getCookingStyle()="
				+ getCookingStyle() + ", getAddress()=" + getAddress() + ", getMenu()=" + getMenu()
				+ ", getEateryManager()=" + getEateryManager() + "]";
	}

	/**
	 * @return the practicalInformation
	 */
	public PracticalInformation getPracticalInformation() {
		return practicalInformation;
	}

	/**
	 * @param practicalInformation the practicalInformation to set
	 */
	public void setPracticalInformation(PracticalInformation practicalInformation) {
		this.practicalInformation = practicalInformation;
	}
}
