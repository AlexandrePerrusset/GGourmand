package com.infotel.gg.eatery;

import java.util.List;



public class EateryTag{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8204488586862481556L;
	private Integer id;
	private String name;
	
	private List<Eatery> eateries;

	public EateryTag(int id, String name, List<Eatery> eateries) {
		this.id = id;
		this.name = name;
		eateries = eateries;
	}
	public EateryTag(int id, String name) {
		this.id = id;
		this.name = name;
	
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
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param eateries the eateries to set
	 */
	public void setEateries(List<Eatery> eateries) {
		eateries = eateries;
		
	}
	
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
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
		//String nr = eateries.size()==0 ? "Aucun restau" : String.valueOf(eateries.size());
		return "EateryTag [id=" + id + ", name=" + name + ", Eateries=" + eateries + "]";
	}

	
	
	
	
	
}
