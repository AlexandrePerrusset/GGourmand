
package com.infotel.gg.DTO;

public class ImageDataDTO {
	
	private String content;
	private String size;
	private byte[] contentRest;
	
	
	
	public byte[] getContentRest() {
		return contentRest;
	}

	public void setContentRest(byte[] contentRest) {
		this.contentRest = contentRest;
	}

	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
