package com.infotel.gg.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.infotel.gg.exception.ModelException;


@Entity @Table(name="eatery_tag") 
public class EateryTag{
	
	private static final long serialVersionUID = 8204488586862481556L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany
	@JoinTable(name="eatery_eatery_tag",
	joinColumns={@JoinColumn(name="tag_id", referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="eatery_id", referencedColumnName="id")})
	private Set<Eatery> eateries;

	public EateryTag(int id, String name, Set<Eatery> eateries){
		setId(id);
		setName(name);
		setEateries(eateries);
	}
	public EateryTag(int id, String name){
		setId(id);
		setName(name);
	
	}
	
	
	public EateryTag() {
	
	}

	/**
	 * @return the eateries
	 */
	public Set<Eatery> getEateries() {
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
	public void setName(String name){
	
			this.name = name;
		
	}
	/**
	 * @param eateries the eateries to set
	 * @throws ModelException 
	 */
	public void setEateries(Set<Eatery> eateries) {

			this.eateries = eateries;
		
		
	}
	
	public int getId() {
		return id;
	}
	
	
	/**
	 * @param id the id to set
	 * @throws ModelException 
	 */
	public void setId(int id){
	
			this.id = id;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EateryTag [getEateries()=" + getEateries() + ", getName()=" + getName() + ", getId()=" + getId() + "]";
	}
}
