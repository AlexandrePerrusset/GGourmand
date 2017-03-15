import com.infotel.gg.service.UserServiceImpl;
import com.infotel.gg.dao.*;
import com.infotel.gg.dao.jdbc.CustomerDAO;
import com.infotel.gg.dao.jdbc.IEmail;

public class TestService {

	public static void main(String[] args) {
		
		UserServiceImpl us = new UserServiceImpl();
		UserDAO udao = new CustomerDAO();
		
		us.setUserDAO(udao);
		
		
		//#1
		IEmail ie = us.authenticate("test@gmail.com", "123456");
		if (ie != null){
			System.out.println("succ�s");
		}else {
			System.out.println("sans succ�s");
		}
		
		//#2
		ie = us.authenticate("rell@gmail.com", "125646");
		if (ie != null){
			System.out.println("succ�s");
		}else {
			System.out.println("sans succ�s");
		}
		
		//#3
		ie = us.authenticate(null, null);
		if (ie != null){
			System.out.println("succ�s");
		}else {
			System.out.println("sans succ�s");
		}
	}

}
