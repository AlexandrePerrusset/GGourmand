import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.Booking;
import com.infotel.gg.model.Customer;
import com.infotel.gg.model.Eatery;
import com.infotel.gg.model.PracticalInformation;

import static java.lang.Math.*;

public class TestBooking {
	
	private static final Logger LOGGER = LogManager.getLogger("console");
	public static void main(String[] args) throws ModelException {
		
		PracticalInformation pi = new PracticalInformation(3000, "", "", "45 �", "CB", "erbe", "sefes");
		
		Eatery et1 = new Eatery(3000, "blablabla", "ezfezgvzeg", "zefesg");
		et1.setPracticalIformation(pi);
		
		pi.setHoursOfOperation1("11-14");
		pi.setHoursOfOperation2("18-23");
		
		Customer cu = new Customer("Alexandre", "Perrusset", "Mr", "24152163", "alex.perru@gmail.com", "sfgshfgseg");
//		Booking booking = new Booking(1000, new Date(2017, 03, 04, 13, 00), 20 , et1, cu);
//		if(booking.isValid()){
//			System.out.println("R�servation accept�e");
//		}else{
//			System.out.println("R�servation annul�e");
//		}
//		abs(-150);
//		float ppp = 50.65f;
//		float total = ppp* booking.getNbOfCustomer();
//		NumberFormat cf = NumberFormat.getCurrencyInstance(Locale.UK);
//		NumberFormat cn = NumberFormat.getNumberInstance(Locale.UK);
//		
//		com.infotel.gg.dao.file.BookingDAO bdao = new com.infotel.gg.dao.file.BookingDAO();
//		
//		bdao.create(booking);
//		
//		System.out.println(bdao.read(1000));
		
	}

}
