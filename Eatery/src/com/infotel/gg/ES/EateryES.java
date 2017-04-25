package com.infotel.gg.ES;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.infotel.gg.dao.EateryDAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.Eatery;
import com.infotel.gg.model.SearchCriteria;
import com.infotel.gg.model.Address;
import com.infotel.gg.model.City;
import com.infotel.gg.model.CookingStyle;
import com.infotel.gg.model.Menu;
import com.infotel.gg.model.PracticalInformation;

@Repository @Qualifier("elastics")
public class EateryES implements EateryDAO{
	private final static Logger log = LogManager.getLogger(EateryES.class);
	
	@Autowired
	private EsClientProvider provider;
	
	@Override
	public List<Eatery> findByCriteria(SearchCriteria criter) {
		Client client = provider.getClient();
		
		// query
		QueryBuilder query = null;
		if(criter.getName() != null) {
			query = QueryBuilders.matchQuery("name", criter.getName()).fuzziness(Fuzziness.ONE);
		}
		
		//filtre
		BoolQueryBuilder filter = QueryBuilders.boolQuery();
		if (criter.getCookingStyleId() != -1) {
			filter.must(QueryBuilders.matchQuery("cookingStyle.id", criter.getCookingStyleId()));
		}
		
		BoolQueryBuilder fullQuery = QueryBuilders.boolQuery();
		if (criter.getName() != null)
			fullQuery.must(query);
		if (criter.getCityId() != -1 || criter.getCookingStyleId() != -1) {
			fullQuery.filter(filter);
		}
		

		SearchResponse respEat = client.prepareSearch(EsClientProvider.INDEX_NAME)
				.setTypes("eateries")
				.setQuery(fullQuery)
				.execute()
				.actionGet();
		
//		SearchResponse respEatCities = client.prepareSearch(EsClientProvider.INDEX_NAME)
//				.setTypes("cities")
//				.setQuery(fullQuery)
//				.execute()
//				.actionGet();
//		
//		
//		log.warn("Nombres de résultats eatery : "+respEat.getHits().getTotalHits());
//		log.warn("Nombres de résultats cities : "+respEatCities.getHits().getTotalHits());
		SearchHits hits;
//		if (respEat.getHits().getTotalHits() >= respEatCities.getHits().getTotalHits()) {
			hits = respEat.getHits();
//		}else{
//			hits = respEatCities.getHits();
//		}
//		
		List<Eatery> eateries = new LinkedList<>();
		hits.forEach(hit ->{
			Map<String, Object> source = hit.getSource();
			String name = (String) source.get("name");
			int id = Integer.parseInt(hit.getId());
			
			Map<String, Object> style  = (Map<String, Object>) source.get("cookingStyle");
			CookingStyle cs = new CookingStyle();
			cs.setId((Integer)style.get("id"));
			cs.setName((String)style.get("name"));
			
			
			//practical information à faire
			Map<String, Object> pi = (Map<String, Object>) source.get("practicalInformation");
			PracticalInformation practicalInfo = new PracticalInformation();
			practicalInfo.setPrice((String)pi.get("price"));
			
			Eatery eatery = new Eatery();
			eatery.setId(id);
			eatery.setName(name);
			eatery.setCookingStyle(cs);
			eatery.setPracticalInformation(practicalInfo);
			
			eateries.add(eatery);
			
		});
			
		return eateries;
	}
	
	

	@Override
	public void create(Eatery obj) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Eatery read(Integer i) throws ModelException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Eatery obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Eatery obj) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Eatery> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
