package com.infotel.gg.eatery;

import com.infotel.gg.dao.jdbc.Identifiable;

public class Menu implements Identifiable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2223377102082445657L;
	private long id;
	private String content; // YAML format
	private Eatery eatery;
	
	
	public Menu(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}


	


	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Menu [id=" + id + ", content=" + content + "]";
	}
	
	
}
