package com.infotel.gg.model;

import com.infotel.gg.exception.ModelException;
import com.mysql.jdbc.StringUtils;

public class Country{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3992402814327252754L;
	private int id;
	private String name;
	
	
	
	
	//CONSTRUCTOR
	public Country(int id, String name) throws ModelException {
		this.setId(id);
		this.setName(name);
	}
	
	public Country(){
		
	}
	
	//GETTERS AND SETTERS
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 * @throws ModelException 
	 */
	public void setId(int id) throws ModelException {
		if( id > 0) {
			this.id = id;
		} else{
			throw new ModelException("Erreur Country id");
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
			throw new ModelException("Erreur Country name");
		}
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Country [getId()=" + getId() + ", getName()=" + getName() + "]";
	}
	
	
	
	
	
	
}
