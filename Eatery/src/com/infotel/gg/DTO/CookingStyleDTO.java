package com.infotel.gg.DTO;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//@XmlRootElement(name="CookingStyle") @JsonInclude(Include.NON_NULL)
public class CookingStyleDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8977381161705633358L;
	
	private String id;
	private String name;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CookingStyleDTO [id=" + id + ", name=" + name + "]";
	}
}

