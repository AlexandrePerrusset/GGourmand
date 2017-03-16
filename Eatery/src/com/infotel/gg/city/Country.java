package com.infotel.gg.city;



public class Country{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3992402814327252754L;
	private Integer id;
	private String name;
	
	
	//CONSTRUCTOR
	public Country(Integer id, String name) {
		this.setId(id);
		this.setName(name);
	}
	
	
	//GETTERS AND SETTERS
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Country [getId()=" + getId() + ", getName()=" + getName() + "]";
	}
	
	
	
	
	
	
}
