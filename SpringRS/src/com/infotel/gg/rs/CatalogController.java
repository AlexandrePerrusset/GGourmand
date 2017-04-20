package com.infotel.gg.rs;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.gg.DTO.CityDTO;
import com.infotel.gg.DTO.CookingStyleDTO;
import com.infotel.gg.DTO.EateryDTO;
import com.infotel.gg.DTO.ImageDataDTO;
import com.infotel.gg.DTO.SearchCriteriaDTO;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.service.CatalogService;






@RestController
@EnableTransactionManagement
public class CatalogController {
	private final static Logger log = LogManager.getLogger(CatalogController.class);
	@Autowired
	private CatalogService service;
	
	@RequestMapping(value="/cookingStyles")
	public List<CookingStyleDTO> getCookingStyles() {
		return service.getAllCookingStyles();
	}
	
	@RequestMapping("/eatery/{id}")
	public EateryDTO getEatery(@PathVariable("id") int id) {
		return service.findOneEatery(id);
	}
	
	@RequestMapping("/image/{id}")
	public ResponseEntity<String> getImages(@PathVariable("id") int id) throws GGourmandException {
		ImageDataDTO image = service.findImageDataById(id);
		if(image != null) {
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_PNG_VALUE);
			headers.setContentLength(image.getContent().length());
			ResponseEntity<String> resp = new ResponseEntity<>(image.getContent(),headers,HttpStatus.OK);
			return resp;
		}
		
		return null;
	}
	
	@RequestMapping(value="/eatery/search", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<EateryDTO> searchEateriesJson(@RequestBody SearchCriteriaDTO crit) {
		List<EateryDTO> eateriesByName =  service.findEateryByCriteria(crit);
		List<EateryDTO> eateriesByCity = service.findEateryByCity(crit);
		
		if(eateriesByName.size() < eateriesByCity.size()){
			eateriesByName = eateriesByCity;
		}
		List<EateryDTO> eateriesDto = new ArrayList<EateryDTO>();
		if (eateriesByName.size() <= 10) {
			eateriesDto  = eateriesByName.subList(0, eateriesByName.size());
		}else{
			eateriesDto  = eateriesByName.subList(0, 9);
		}
		return eateriesDto;
	}
	
	@RequestMapping("/cities")
	public List<CityDTO> getAllCities() {
		return service.getAllCities();
	}
	
	@RequestMapping("/cities/{name}")
	public List<CityDTO> getAllCitiesByName(@PathVariable("name") String name) {
		return service.getAllCitiesLike(name);
	}
	
	
	
}
