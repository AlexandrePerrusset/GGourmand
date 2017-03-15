
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.infotel.gg.booking.Booking;
import com.infotel.gg.customer.Customer;
import com.infotel.gg.dao.jdbc.BookingDAO;
import com.infotel.gg.dao.jdbc.CustomerDAO;
import com.infotel.gg.dao.jdbc.EateryDAO;
import com.infotel.gg.dao.jdbc.MenuDAO;
import com.infotel.gg.eatery.Eatery;
import com.infotel.gg.eatery.Menu;

public class TestDao {

	public static void main(String[] args) {
		
		
//		Menu menu = new Menu(3000, "blabla");
//		MenuDAO md = new MenuDAO();
//		//md.delete(3000);
//		md.create(menu);
		
//		EateryDAO ed = new EateryDAO();
//		List<Eatery> e = new ArrayList<Eatery>();
//		e = ed.find("*");
//		
//		for(Eatery ea : e){
//			System.out.println(ea);
//		}
//		System.out.println(e.size());
		
		Customer c = new Customer("Alexandre", "Perrusset", "Mr", "24152163", "alex.perru@gmail.com", "sfgshfgseg");
		
		CustomerDAO cd = new CustomerDAO();
		//cd.create(c);
		
		EateryDAO eD = new EateryDAO();
		
		List<Eatery> listEd = new ArrayList<Eatery>();
		listEd = eD.find("Patate");
		
		Collections.shuffle(listEd);
		
		Eatery e = listEd.get(0);
		
		BookingDAO bd = new BookingDAO();
		Booking b = new Booking(new Date(), 10, e, c );
		//bd.create(b);

		Calendar cal = Calendar.getInstance();
		
		

	}

}
