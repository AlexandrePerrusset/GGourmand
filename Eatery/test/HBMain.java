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
//		City city = new City(id, name, postCode, foreMost);
//		session.persist(city);
		
		Transaction t = session.beginTransaction();
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
