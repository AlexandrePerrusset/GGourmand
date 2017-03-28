package com.infotel.gg.model;

import com.infotel.gg.exception.ModelException;
import com.mysql.jdbc.StringUtils;

public class Menu {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2223377102082445657L;
	private int id;
	private String content; // YAML format
	private Eatery eatery;

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
	 * @return the eatery
	 */
	public Eatery getEatery() {
		return eatery;
	}

	/**
	 * @param eatery
	 *            the eatery to set
	 * @throws ModelException
	 */
	public void setEatery(Eatery eatery) {
		this.eatery = eatery;
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
		return "Menu [getId()=" + getId() + ", getContent()=" + getContent() + ", getEatery()=" + getEatery() + "]";
	}
}
