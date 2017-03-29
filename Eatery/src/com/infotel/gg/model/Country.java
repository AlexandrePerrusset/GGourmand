package com.infotel.gg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infotel.gg.exception.ModelException;
import com.mysql.jdbc.StringUtils;

@Entity @Table(name="country")
public class Country {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3992402814327252754L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	// CONSTRUCTOR
	public Country(int id, String name) {
		this.setId(id);
		this.setName(name);
	}

	public Country() {

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Country [getId()=" + getId() + ", getName()=" + getName() + "]";
	}

}
