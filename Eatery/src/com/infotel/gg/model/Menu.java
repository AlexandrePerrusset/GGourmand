package com.infotel.gg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infotel.gg.exception.ModelException;


@Entity @Table(name="menu") 
public class Menu {
	
	private static final long serialVersionUID = 2223377102082445657L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="content")
	private String content; // YAML format
	
	
	

	public Menu(int id, String content) {
		setId(id);
		setContent(content);
	}

	public Menu() {

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 * @throws ModelException
	 */
	public void setContent(String content) {
		this.content = content;
	}

	

	/**
	 * @param id
	 *            the id to set
	 * @throws ModelException
	 */
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Menu [getId()=" + getId() + ", getContent()=" + getContent() + "]";
	}
}
