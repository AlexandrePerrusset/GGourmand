package com.infotel.gg.model;

import java.util.Base64;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="image_data") 
public class ImageData{

	private static final long serialVersionUID = -4072087939439076750L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Basic(fetch=FetchType.LAZY)
	@Column(name="content")
	private byte[] content;
	
	@Column(name="target")
	private String target;
	
	@Column(name="target_id")
	private int targetId;
	
	@Column(name="size")
	private String size;

	
	
	
	public ImageData(int id, byte[] content, String target, int targetId, String size) {
		super();
		this.id = id;
		this.content = content;
		this.target = target;
		this.targetId = targetId;
		this.size = size;
	}
	

	public ImageData() {
		
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

	
	public String getBase64URL() {
		byte[]encodedBytes = Base64.getEncoder().encode(content);
		return "data:image/jpeg;base64, " + new String(encodedBytes);
	
	}
	
}
