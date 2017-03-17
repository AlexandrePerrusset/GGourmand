package com.infotel.gg.DTO;

import java.util.List;

public class MenuPartDTO {

	private String title;
	private List<MenuItemDTO> items;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<MenuItemDTO> getItems() {
		return items;
	}
	public void setItems(List<MenuItemDTO> items) {
		this.items = items;
	}
	
	
}
