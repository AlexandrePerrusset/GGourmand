import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infotel.gg.dao.ImageDataDAO;
import com.infotel.gg.hibernate.ImageDataDAOHbn;
import com.infotel.gg.model.ImageData;

public class testImage {

	public static void main(String[] args) {
		ImageDataDAO imageDao = new ImageDataDAOHbn();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-test.xml");
		imageDao = ctx.getBean(ImageDataDAO.class);
		ImageData image = new ImageData();
		
		image = imageDao.read(4);
		System.out.println(image.getBase64URL());
	}

}
