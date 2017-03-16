package com.infotel.gg.eatery;



public class Menu{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2223377102082445657L;
	private Integer id;
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
	public Integer getId() {
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
	 * @param eatery the eatery to set
	 */
	public void setEatery(Eatery eatery) {
		this.eatery = eatery;
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
		return "Menu [id=" + id + ", content=" + content + "]";
	}
	
	
}
