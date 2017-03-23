package com.infotel.gg.model;

import java.io.Serializable;
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
		if(practicalInformation != null) {
			this.practicalInformation = practicalInformation;
		} else {
			throw new ModelException("Erreur Eatery practicalInformation");
		}
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
		if(eateryTags != null && eateryTags.size() > 0) {
			this.eateryTags = eateryTags;
		} else {
			throw new ModelException("Erreur Eatery eateryTag");
		}
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
		if(name != null && !StringUtils.isEmptyOrWhitespaceOnly(name)) {
			this.name = name;
		} else {
			throw new ModelException("Erreur Eatery name");
		}
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
		if(description != null && !StringUtils.isEmptyOrWhitespaceOnly(description)) {
			this.description = description;
		} else {
			throw new ModelException("Erreur Eatery description");
		}
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
		if(executiveChef != null && !StringUtils.isEmptyOrWhitespaceOnly(executiveChef)) {
			this.executiveChef = executiveChef;
		} else {
			throw new ModelException("Erreur Eatery executiveChef");
		}
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
		if(cookingStyle != null) {
			this.cookingStyle = cookingStyle;
		} else {
			throw new ModelException("Erreur Eatery cookingStyle");
		}
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
		if(address != null) {
			this.address = address;
		} else {
			throw new ModelException("Erreur Eatery address");
		}
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
		if(menu != null) {
			this.menu = menu;
		} else {
			throw new ModelException("Erreur Eatery menu");
		}
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
		if(eateryManager != null) {
			this.eateryManager = eateryManager;
		} else {
			throw new ModelException("Erreur Eatery eateryManager");
		}
	}
	/**
	 * @param id the id to set
	 * @throws ModelException 
	 */
	public void setId(int id) throws ModelException {
		if(id > 0) {
			this.id = id;
		} else{
			throw new ModelException("Erreur Eatery id");
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Eatery [getPracticalIformation()=" + getPracticalIformation() + ", getId()=" + getId()
				+ ", getEateryTags()=" + getEateryTags() + ", getName()=" + getName() + ", getDescription()="
				+ getDescription() + ", getExecutiveChef()=" + getExecutiveChef() + ", getCookingStyle()="
				+ getCookingStyle() + ", getAddress()=" + getAddress() + ", getMenu()=" + getMenu()
				+ ", getEateryManager()=" + getEateryManager() + "]";
	}
}
