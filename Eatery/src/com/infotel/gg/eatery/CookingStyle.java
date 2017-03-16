package com.infotel.gg.eatery;

import com.infotel.gg.exception.ModelException;
import com.mysql.jdbc.StringUtils;

public class CookingStyle{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8880518127996567425L;
	private Integer id;
	private String name;

	public CookingStyle(Integer id, String name) throws ModelException {
		setId(id);
		setName(name);
	}
	


	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	
	/**
	 * @param id the id to set
	 * @throws ModelException 
	 */
	public void setId(Integer id) throws ModelException {
		if(id != null && id > 0) {
			this.id = id;
		} else{
			throw new ModelException("Erreur CookingStyle id");
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
			throw new ModelException("Erreur CookingStyle name");
		}
		
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CookingStyle [id=" + id + ", name=" + name + ", getId()=" + getId() + ", getName()=" + getName() + "]";
	}
}
