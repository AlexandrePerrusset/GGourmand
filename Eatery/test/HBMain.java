import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.infotel.gg.model.City;
import com.infotel.gg.model.Country;

public class HBMain {

	public static void main(String[] args) {
		SessionFactory factory = createWithHB5();
		
		// Creating session object
		Session session = factory.openSession();
		
		Country c = session.get(Country.class, 8);
		City city = new City(666, "DevilCity", "66666", true);
		session.persist(city);
		
		Transaction t = session.beginTransaction();
		City city2 = session.get(City.class, 666);
		t.commit();
		System.out.println(city2.toString());
		session.close();
	}
	
	public static SessionFactory createWithHB5() {
		SessionFactory sf = null;
		
		try {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			
			sf = metadata.getSessionFactoryBuilder().build();
		} catch (Throwable th) {
			System.err.println("Initial SessionFactory creation failed " + th);
			
		}
		return sf;
	}

}
