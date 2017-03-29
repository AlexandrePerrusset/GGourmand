package com.infotel.gg.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.infotel.gg.exception.ModelException;
import com.mysql.jdbc.StringUtils;

@Entity @Table(name="eatery")
public class Eatery implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5737634769078321910L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="executive_chef")
	private String executiveChef;
	
	@OneToOne(mappedBy="eatery")
	private PracticalInformation practicalInformation;
	
	@ManyToOne @JoinColumn(name="cooking_style_id", unique=true)
	private CookingStyle cookingStyle;
	
	@Embedded
	private Address address;
	
	@ManyToOne @JoinColumn(name="menu_id", unique=true)
	private Menu menu;
	
	@ManyToMany
	@JoinTable(name="eatery_eatery_tag",
	joinColumns={@JoinColumn(name="eatery_id", referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="tag_id", referencedColumnName="id")})
	private List<EateryTag> eateryTags;
	

	
	
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
	 * @param id the id to set
	 * @throws ModelException 
	 */
	public void setId(int id) throws ModelException {
		
			this.id = id;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	

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
	
	@Override
	public String toString() {
		return "Eatery [id=" + id + ", name=" + name + ", description=" + description + ", executiveChef="
				+ executiveChef + ", practicalInformation=" + practicalInformation + ", cookingStyle=" + cookingStyle
				+ ", address=" + address + ", menu=" + menu + "";
	}
}
