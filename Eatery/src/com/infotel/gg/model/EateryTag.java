package com.infotel.gg.model;

import java.util.List;

import com.infotel.gg.exception.ModelException;
import com.mysql.jdbc.StringUtils;



public class EateryTag{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8204488586862481556L;
	private int id;
	private String name;
	
	private List<Eatery> eateries;

	public EateryTag(int id, String name, List<Eatery> eateries) throws ModelException {
		setId(id);
		setName(name);
		setEateries(eateries);
	}
	public EateryTag(int id, String name) throws ModelException {
		setId(id);
		setName(name);
	
	}
	
	
	public EateryTag() {
	
	}

	/**
	 * @return the eateries
	 */
	public List<Eatery> getEateries() {
		return eateries;
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
			throw new ModelException("Erreur EateryTag name");
		}
	}
	/**
	 * @param eateries the eateries to set
	 * @throws ModelException 
	 */
	public void setEateries(List<Eatery> eateries) throws ModelException {
		if(eateries != null && eateries.size() > 0) {
			this.eateries = eateries;
		} else {
			throw new ModelException("Erreur EateryTag eateries");
		}
		
	}
	
	public int getId() {
		return id;
	}
	
	
	/**
	 * @param id the id to set
	 * @throws ModelException 
	 */
	public void setId(int id) throws ModelException {
		if(id > 0) {
			this.id = id;
		} else{
			throw new ModelException("Erreur EateryTag id");
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EateryTag [getEateries()=" + getEateries() + ", getName()=" + getName() + ", getId()=" + getId() + "]";
	}
}
