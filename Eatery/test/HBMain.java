import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;

import com.infotel.gg.dao.CityDAO;
import com.infotel.gg.hibernate.CityDAOHbn;
import com.infotel.gg.model.City;
import com.infotel.gg.model.Country;
import com.infotel.gg.model.Eatery;
import com.infotel.gg.model.Region;

import DBUnit.DBUtils;

public class HBMain {

	public static void main(String[] args) {
		SessionFactory factory = createWithHB5();
		
		DBUtils.startDB();
		
		// Creating session object
		Session session = factory.openSession();

//		Transaction t = session.beginTransaction();
		
//		Criteria crit = session.createCriteria(Region.class);
//		crit.setMaxResults(3);
//		List<Region> regions = crit.list();
//		for (Region reg:regions){
//			System.out.println(reg.toString());
//		}
		
		Criteria crit = session.createCriteria(Eatery.class);
		  crit.add( Restrictions.like("name", "A%") );
		  crit.add( Restrictions.or(
			        Restrictions.like( "executiveChef", "Bruno%"),
			        Restrictions.like("executiveChef", "Bernard%")));
		  List<Eatery> eateries = crit.list();
		  for (Eatery eat:eateries){
				System.out.println(eat.toString());
			}
		
//		
//		Country c = session.get(Country.class, 1);
//		Region r = session.get(Region.class, 1);
//		
//		City city = new City(667, "DevilCity", "66666", true, r, c);
//		session.save(city);

		Transaction t = session.beginTransaction();
		
		Criteria crit = session.createCriteria(Region.class);
		crit.setMaxResults(5);
		List<Region> regions = crit.list();
		
		for (Region reg : regions) {
			System.out.println(reg);
		}
		
		CityDAO cd = new CityDAOHbn();
		City c = cd.read(1);
		
		System.out.println(c);
		
//		Country c = session.get(Country.class, 1);
		Region r = session.get(Region.class, 1);
		City c2 = session.get(City.class, 1);
		
		System.out.println(c2);
//		
//		City city = new City(667, "DevilCity", "66666", true, r, c);
//		session.save(c);

//		
//		
//		
//		City city2 = session.get(City.class, 32);
//		t.commit();
//		System.out.println(city2.toString());
		session.close();
	}
	
	public static SessionFactory createWithHB5() {
		SessionFactory sf = null;
		
		try {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			
			sf = metadata.getSessionFactoryBuilder().build();
		} catch (Throwable th) {
//			System.err.println("Initial SessionFactory creation failed " + th);
			th.printStackTrace();
			
		}
		return sf;
	}

}
