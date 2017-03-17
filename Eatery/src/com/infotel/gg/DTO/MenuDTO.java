package com.infotel.gg.DTO;

import java.io.Serializable;
import java.util.List;

public class MenuDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5208927478084734523L;

	private List<MenuPartDTO> parts;

	public List<MenuPartDTO> getParts() {
		return parts;
	}

	public void setParts(List<MenuPartDTO> parts) {
		this.parts = parts;
	}	
}
