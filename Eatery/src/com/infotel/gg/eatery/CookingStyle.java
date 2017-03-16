package com.infotel.gg.eatery;



public class CookingStyle{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8880518127996567425L;
	private Integer id;
	private String name;

	public CookingStyle(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
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
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
