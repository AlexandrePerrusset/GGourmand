package com.infotel.gg.model;

import com.infotel.gg.exception.ModelException;
import com.mysql.jdbc.StringUtils;

public class Menu{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2223377102082445657L;
	private int id;
	private String content; // YAML format
	private Eatery eatery;
	
	
	public Menu(int id, String content) throws ModelException {
		setId(id);
		setContent(content);
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
	 * @param content the content to set
	 * @throws ModelException 
	 */
	public void setContent(String content) throws ModelException {
		if(content != null && !StringUtils.isEmptyOrWhitespaceOnly(content)) {
			this.content = content;
		} else {
			throw new ModelException("Erreur Menu content");
		}
	}
	
	
	
	/**
	 * @return the eatery
	 */
	public Eatery getEatery() {
		return eatery;
	}


	/**
	 * @param eatery the eatery to set
	 * @throws ModelException 
	 */
	public void setEatery(Eatery eatery) throws ModelException {
		if(eatery != null) {
			this.eatery = eatery;
		} else {
			throw new ModelException("Erreur Menu eatery");
		}
	}


	/**
	 * @param id the id to set
	 * @throws ModelException 
	 */
	public void setId(int id) throws ModelException {
		if(id > 0) {
			this.id = id;
		} else{
			throw new ModelException("Erreur Menu id");
		}
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Menu [getId()=" + getId() + ", getContent()=" + getContent() + ", getEatery()=" + getEatery() + "]";
	}
}
