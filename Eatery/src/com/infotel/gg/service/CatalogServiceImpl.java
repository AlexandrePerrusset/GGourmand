package com.infotel.gg.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.infotel.gg.DTO.CityDTO;
import com.infotel.gg.DTO.CookingStyleDTO;
import com.infotel.gg.DTO.EateryDTO;
import com.infotel.gg.DTO.ReviewDTO;
import com.infotel.gg.DTO.SearchCriteriaDTO;
import com.infotel.gg.dao.BookingDAO;
import com.infotel.gg.dao.CityDAO;
import com.infotel.gg.dao.CookingStyleDAO;
import com.infotel.gg.dao.EateryDAO;
import com.infotel.gg.dao.ImageDataDAO;
import com.infotel.gg.dao.ReviewDAO;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.hibernate.CityDAOHbn;
import com.infotel.gg.hibernate.CookingStyleDAOHbn;
import com.infotel.gg.hibernate.EateryDAOHbn;
import com.infotel.gg.model.CookingStyle;
import com.infotel.gg.model.Eatery;
import com.infotel.gg.model.Address;
import com.infotel.gg.model.City;
import com.infotel.gg.model.Country;
import com.infotel.gg.model.EateryTag;
import com.infotel.gg.model.ImageData;
import com.infotel.gg.model.PracticalInformation;
import com.infotel.gg.model.Region;
import com.infotel.gg.model.Booking;
import com.infotel.gg.model.Review;
import com.infotel.gg.model.EateryResult;
import com.infotel.gg.model.SearchCriteria;
import com.infotel.gg.DTO.OrderDTO;




public class CatalogServiceImpl implements CatalogService {

	private final static Logger log = LogManager.getLogger(CatalogServiceImpl.class);

	@Autowired
	private CookingStyleDAO cookingStyleDAO;
	
	@Autowired
	private EateryDAO eateryDAO;
	
	@Autowired
	private ImageDataDAO imageDataDAO;
	
	@Autowired
	private CityDAO cityDAO;

	@Autowired
	private ReviewDAO reviewDAO;

	@Autowired
	private BookingDAO bookingDAO;

	@Override
	public List<CookingStyleDTO> getAllCookingStyles() {
		List<CookingStyleDTO> result = new ArrayList<CookingStyleDTO>();
		List<CookingStyle> cookingstyles = cookingStyleDAO.listAll();
		CookingStyleDTO cookingStyleDto = new CookingStyleDTO();
		for(CookingStyle cs : cookingstyles){
			cookingStyleDto.setId(Integer.toString(cs.getId()));
			cookingStyleDto.setName(cs.getName());
			result.add(cookingStyleDto);
		}

		return result;


	}

	@Override
	public EateryDTO findOneEatery(int id) {
		Eatery eat = eateryDAO.read(id);
		System.out.println(eat);
		EateryDTO edto = transform(eat, true);
		return edto;
	}

	@Override
	public Eatery findOneRealEatery(int id) {
		return eateryDAO.read(id);
	}

	public EateryDTO transform(Eatery eat, boolean detail) {
		EateryDTO e = new EateryDTO();
		e.setId(eat.getId());
		e.setName(eat.getName());
		//e.setHighlightedName(eat.getHighlightedName());
		e.setExecutiveChef(eat.getExecutiveChef());

		e.setCookingStyle(eat.getCookingStyle().getName());
		e.setCookingStyleid(eat.getCookingStyle().getId());
		Address ad = eat.getAddress();
		if (ad != null) {
			e.setStreet(eat.getAddress().getStreet());
			e.setPostCode(ad.getPostCode());

			City ci = ad.getCity();
			if (ci != null) {
				e.setCity(ci.getName());
				e.setCityid(ci.getId());

				Region re = ci.getRegion();
				if (re != null)
					e.setRegion(re.getName());
				Country co = ci.getCountry();
				if (co != null) {
					e.setCountry(co.getName());
				}
			}

		}

		List<Integer> imageIds = null;
		List<ReviewDTO> reviews= null;
		PracticalInformation pi = eat.getPracticalInformation();
		e.setDescription(eat.getDescription());
		if (pi != null) {
			e.setPrice(pi.getPrice());
			e.setHoursOfOperation1(pi.getHoursOfOperation1());
			e.setHoursOfOperation2(pi.getHoursOfOperation2());
			e.setPaymentOptions(pi.getPaymentOptions());
			e.setGettingThere(pi.getGettingThere());
			e.setParking(pi.getParking());
		}
		//		if (detail) {
		//			imageIds = imageDataDAO.findBigByEateryId(eat.getId());
		//			e.setImageIds(imageIds);
		//
		//			// Menu
		//			ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		//			try {
		//				MenuDTO menu = mapper.readValue(eat.getMenu().getContent(), MenuDTO.class);
		//				e.setMenu(menu);
		//			} catch (Exception e1) {
		//				log.error("Echec d�s�rialisation du menu", e1);
		//
		//			}
		//			
		//			//review
		//			reviews = reviewDAO.listAllByEateryId(eat.getId()).stream().map(r -> transform(r))
		//						.collect(Collectors.toList());
		//			 System.out.println(reviews);
		//			 e.setReviews(reviews);
		//			 
		//		} else {
		//			imageIds = imageDataDAO.findSmallByEateryId(eat.getId());
		//			e.setImageIds(imageIds);
		//		}
		//		if (!imageIds.isEmpty()) {
		//			e.setImageId(imageIds.get(0));
		//		}

		List<EateryTag> eatag = eat.getEateryTags();
		if(eatag != null) {
			List<String> eatagname = new ArrayList<>();
			System.out.println(eat.getEateryTags());
			for (int i = 0; i < eatag.size(); i++) {
				if (eatag.get(i) != null) {
					eatagname.add(eatag.get(i).getName());
				}
			}
			e.setEateryTagName(eatagname);
		}
		return e;

	}

	@Override
	public ImageData findImageDataById(int id) throws GGourmandException {
		ImageData image = imageDataDAO.read(id);
		return image;
	}

	@Override
	public List<Integer> findBigImageForEatery(int eateryId) {
		List<Integer> imagesDataId = imageDataDAO.findBigByEateryId(eateryId);
		return imagesDataId;
	}

	@Override
	public List<Integer> findSmallImageForEatery(int eateryId) {
		List<Integer> imagesDataId = imageDataDAO.findSmallByEateryId(eateryId);
		return imagesDataId;
	}

	@Override
	public void review(ReviewDTO rdto) throws GGourmandException {
		Review review = new Review();
		review.setComment(rdto.getComment());
		review.setRating(rdto.getRating());
		Booking booking = bookingDAO.read(rdto.getBookingID());
		review.setBooking(booking);
		
		reviewDAO.create(review);
		
	}
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public List<CityDTO> getAllCities() {
		List<CityDTO> result = new ArrayList<CityDTO>();
		List<City> cities = cityDAO.listAll();
		cities.stream().forEach(c -> result.add(transform(c)));
		return result;
	}

	@Override
	public List<CityDTO> getAllCitiesLike(String beginNameCity) {
		List<CityDTO> result = new ArrayList<CityDTO>();
		List<City> cities = cityDAO.listAll(beginNameCity);
		cities.stream().forEach(c -> result.add(transform(c)));
		return result;
	}
	@Override
	public List<CityDTO> getAllCitiesForemost() {
		List<CityDTO> result = new ArrayList<CityDTO>();
		List<City> cities = cityDAO.listAllforemost();
		cities.stream().forEach(c -> result.add(transform(c)));
		return result;
	}
	
	
	private CityDTO transform(City c) {
		CityDTO cityDto = new CityDTO();
		cityDto.setId(Integer.toString(c.getId()));
		cityDto.setName(c.getName());
		cityDto.setForemost(String.valueOf(c.isForeMost()));
		cityDto.setRegion_name(c.getRegion().getName());
		cityDto.setCountry_name(c.getCountry().getName());
//		if (c.isForemost()) {
//			cityDto.setImageId(imageDataDAO.findImageDataCityIdByTargetId(c.getId()));
//		} else {
//			cityDto.setImageId(null);
//		}

		return cityDto;
	}
	



	@Override
	public List<EateryDTO> findEateryByCriteria(SearchCriteriaDTO criteria) {
		SearchCriteria criter = new SearchCriteria();
		criter = parse(criteria);
		EateryResult daoresult = eateryDAO.findByCriteria(criter);
		List<EateryDTO> result = daoresult.getEateries().stream().map(e -> transform(e, false))
				.collect(Collectors.toList());
		return sortByCriteria(result, criteria.getOrderBy());
	}
	
	private SearchCriteria parse(SearchCriteriaDTO criteria) {
		SearchCriteria criter = new SearchCriteria();
		criter.setName(criteria.getName());
		criter.setCityId(criteria.getCityId());
		criter.setCookingStyleId(criteria.getCookingStyleId());
		return criter;
	}

	private List<EateryDTO> sortByCriteria(List<EateryDTO> res, OrderDTO orderBy) {
		switch (orderBy) {
		case CITY:
			Comparator<EateryDTO> byCity = (EateryDTO o1, EateryDTO o2) -> o1.getCity().compareTo(o2.getCity());
			res.sort(byCity);
			break;
		case REGION:
			Comparator<EateryDTO> byRegion = (EateryDTO o1, EateryDTO o2) -> o1.getRegion().compareTo(o2.getRegion());
			res.sort(byRegion);
			break;
		case COOKINGSTYLE:
			Comparator<EateryDTO> byCookingStyle = (EateryDTO o1, EateryDTO o2) -> o1.getCookingStyle()
					.compareTo(o2.getCookingStyle());
			res.sort(byCookingStyle);
			break;
		case PRICE:
			Comparator<EateryDTO> byPrice = (EateryDTO o1, EateryDTO o2) -> o1.getPrice().compareTo(o2.getPrice());
			res.sort(byPrice);
			break;
		default:
			Comparator<EateryDTO> byName = (EateryDTO o1, EateryDTO o2) -> o1.getName().compareTo(o2.getName());
			res.sort(byName);
			break;
		}
		return res;
	}

}




