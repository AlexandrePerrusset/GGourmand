package com.infotel.gg.model;



public class ImageData{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4072087939439076750L;
	private int id;
	private byte[] content;
	private String target;
	private int targetId;
	private String size;

	
	
	
	public ImageData(int id, byte[] content, String target, int targetId, String size) {
		super();
		this.id = id;
		this.content = content;
		this.target = target;
		this.targetId = targetId;
		this.size = size;
	}

	/**
	 * @return the content
	 */
	public byte[] getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(byte[] content) {
		this.content = content;
	}

	/**
	 * @return the target
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * @return the targetId
	 */
	public int getTargetId() {
		return targetId;
	}

	/**
	 * @param targetId the targetId to set
	 */
	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	
}
