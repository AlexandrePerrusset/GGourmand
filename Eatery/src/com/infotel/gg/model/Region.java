package com.infotel.gg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.infotel.gg.exception.ModelException;


@Entity @Table(name="region")
public class Region {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5296585714694623741L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne @JoinColumn(name="country_id", unique=true)
	private Country country;

	// CONSTRUCTOR
	public Region(int id, String name, Country country) {
		this.setId(id);
		this.setName(name);
		this.setCountry(country);
	}
	
	public Region(int id, String name) {
		this.setId(id);
		this.setName(name);
	}

	public Region() {

	}

	// GETTERS AND SETTERS
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 * @throws ModelException
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 * @throws ModelException
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Region [getId()=" + getId() + ", getName()=" + getName() + ", getCountry()=" + getCountry() + "]";
	}

}
