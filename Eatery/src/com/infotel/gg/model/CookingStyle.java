package com.infotel.gg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infotel.gg.exception.ModelException;
import com.mysql.jdbc.StringUtils;


@Entity @Table(name="cooking_style")
public class CookingStyle {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8880518127996567425L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	public CookingStyle(int id, String name) {
		setId(id);
		setName(name);
	}

	public CookingStyle() {
	}

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
		return "CookingStyle [id=" + id + ", name=" + name + ", getId()=" + getId() + ", getName()=" + getName() + "]";
	}
}
