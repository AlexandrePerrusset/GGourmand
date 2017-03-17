
import java.io.Serializable;
import java.util.List;

public class EateryDTO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5865660667046477L;
	private Integer id;
	private String name;
	private String highlightedName;
	private String description;
	private String executiveChef;
	
	//private MenuDTO menu;
	private MenuDTO menu;
	
	private String hoursOfOperation1;
	private String hoursOfOperation2;
	private String price;
	private String paymentOptions;
	private String gettingThere;
	private String parking;
	
	private String street;
	private String postCode;
	private String city;
	private Integer cityid;
	private String region;
	private String country;
	private String cookingStyle;
	private Integer cookingStyleid;
	private List<String> eateryTagName;
	
	private List<Integer> imageIds;// détail
	private Integer imageId;// liste
	
	private List<ReviewDTO> reviews;
	
	public EateryDTO() {
		super();
	}

	
	public List<Integer> getImageIds() {
		return imageIds;
	}

	public Integer getImageId() {
		return imageId;
	}


	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}


	public void setImageIds(List<Integer> imageIds) {
		this.imageIds = imageIds;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExecutiveChef() {
		return executiveChef;
	}

	public void setExecutiveChef(String executiveChef) {
		this.executiveChef = executiveChef;
	}

	public MenuDTO getMenu() {
		return menu;
	}

	public void setMenu(MenuDTO menu) {
		this.menu = menu;
	}

	public String getHoursOfOperation1() {
		return hoursOfOperation1;
	}

	public void setHoursOfOperation1(String hoursOfOperation1) {
		this.hoursOfOperation1 = hoursOfOperation1;
	}

	public String getHoursOfOperation2() {
		return hoursOfOperation2;
	}

	public void setHoursOfOperation2(String hoursOfOperation2) {
		this.hoursOfOperation2 = hoursOfOperation2;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPaymentOptions() {
		return paymentOptions;
	}

	public void setPaymentOptions(String paymentOptions) {
		this.paymentOptions = paymentOptions;
	}

	public String getGettingThere() {
		return gettingThere;
	}

	public void setGettingThere(String gettingThere) {
		this.gettingThere = gettingThere;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getCityid() {
		return cityid;
	}


	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}


	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCookingStyle() {
		return cookingStyle;
	}

	public void setCookingStyle(String cookingStyle) {
		this.cookingStyle = cookingStyle;
	}


	public List<String> getEateryTagName() {
		return eateryTagName;
	}


	public void setEateryTagName(List<String> eateryTagName) {
		this.eateryTagName = eateryTagName;
	}
	
	

	public List<ReviewDTO> getReviews() {
		return reviews;
	}


	public void setReviews(List<ReviewDTO> reviews) {
		this.reviews = reviews;
	}
	
	public String getHighlightedName() {
		return highlightedName;
	}


	public void setHighlightedName(String highlightedName) {
		this.highlightedName = highlightedName;
	}

	

	public Integer getCookingStyleid() {
		return cookingStyleid;
	}


	public void setCookingStyleid(Integer cookingStyleid) {
		this.cookingStyleid = cookingStyleid;
	}


	@Override
	public String toString() {
		return "EateryDTO [id=" + id + ", name=" + name + ", description=" + description + ", executiveChef="
				+ executiveChef + ", menu=" + menu + ", hoursOfOperation1=" + hoursOfOperation1 + ", hoursOfOperation2="
				+ hoursOfOperation2 + ", price=" + price + ", paymentOptions=" + paymentOptions + ", gettingThere="
				+ gettingThere + ", parking=" + parking + ", street=" + street + ", postCode=" + postCode + ", city="
				+ city + ", cityid=" + cityid + ", region=" + region + ", country=" + country + ", cookingStyle="
				+ cookingStyle + ", cookingStyleid=" + cookingStyleid + ", eateryTagName=" + eateryTagName
				+ ", imageIds=" + imageIds + ", imageId=" + imageId + ", reviews=" + reviews + "]";
	}