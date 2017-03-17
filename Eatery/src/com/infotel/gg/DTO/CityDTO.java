package com.infotel.gg.DTO;

public class CityDTO {
	private String id;
	private String name;
	private String foremost;
	private String country_name;
	private String region_name;
	private Integer imageId=-1;
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
	public String getForemost() {
		return foremost;
	}
	public void setForemost(String foremost) {
		this.foremost = foremost;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	@Override
	public String toString() {
		return "CityDTO [id=" + id + ", name=" + name + ", foremost=" + foremost + ", country_name=" + country_name
				+ ", region_name=" + region_name + ", imageId=" + imageId + "]";
	}

	
}
