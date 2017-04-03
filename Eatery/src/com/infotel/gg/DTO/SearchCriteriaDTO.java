package com.infotel.gg.DTO;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="SearchCriteria")
public class SearchCriteriaDTO {
	
	// properties
	private String name;
	private int cityId = -1;   // en int city_id
	private int cookingStyleId = -1; // en int cst_id
	
	
	private OrderDTO orderBy; // optionnel
	
	
	public SearchCriteriaDTO(){
		this.orderBy = OrderDTO.NAME;
	}
	
	
	public OrderDTO getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(OrderDTO orderBy) {
		this.orderBy = orderBy;
	}
	public String getName() {
		return name;
	}
	public void setName(String nom) {
		this.name = nom;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int ville) {
		this.cityId = ville;
	}
	public int getCookingStyleId() {
		return cookingStyleId;
	}
	public void setCookingStyleId(int cookingStyle) {
		this.cookingStyleId = cookingStyle;
	}
	
	@Override
	public String toString() {
		return "SearchCriteriaDTO [name=" + name + ", cityId=" + cityId + ", cookingStyleId=" + cookingStyleId
				+ ", orderBy=" + orderBy + "]";
	}

}
