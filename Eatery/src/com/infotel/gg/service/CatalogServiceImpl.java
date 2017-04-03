package com.infotel.gg.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.infotel.gg.DTO.CookingStyleDTO;
import com.infotel.gg.DTO.EateryDTO;
import com.infotel.gg.DTO.ReviewDTO;
import com.infotel.gg.dao.BookingDAO;
import com.infotel.gg.dao.CityDAO;
import com.infotel.gg.dao.CookingStyleDAO;
import com.infotel.gg.dao.EateryDAO;
import com.infotel.gg.dao.ImageDataDAO;
import com.infotel.gg.dao.ReviewDAO;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.model.CookingStyle;
import com.infotel.gg.model.Eatery;
import com.infotel.gg.DTO.MenuDTO;
import com.infotel.gg.model.Address;
import com.infotel.gg.model.City;
import com.infotel.gg.model.Country;
import com.infotel.gg.model.EateryTag;
import com.infotel.gg.model.ImageData;
import com.infotel.gg.model.PracticalInformation;
import com.infotel.gg.model.Region;
import com.infotel.gg.model.Booking;
import com.infotel.gg.model.Review;




public class CatalogServiceImpl implements CatalogService {

	private final static Logger log = LogManager.getLogger(CatalogServiceImpl.class);


	private CookingStyleDAO cookingStyleDAO;
	private EateryDAO eateryDAO;
	private ImageDataDAO imageDataDAO;

	private CityDAO cityDAO;

	private ReviewDAO reviewDAO;

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
		//				log.error("Echec désérialisation du menu", e1);
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





}
