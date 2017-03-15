import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infotel.gg.eatery.Eatery;
import com.infotel.gg.eatery.EateryTag;


public class Main {

	public static void main(String[] args) {
		Eatery tempE;
		EateryTag tempEt;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bat";
			Connection cx = DriverManager.getConnection(url, "root", "");
			
			Statement st = cx.createStatement();
			Statement st1 = cx.createStatement();
			Statement st2 = cx.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM EATERY where id between 1 and 200");
			ResultSet rse, rst;

			
			while(rs.next()){
				int eid = rs.getInt("id");
				tempE = new Eatery(rs.getInt("id"), rs.getString("name"),rs.getString("description"), rs.getString("executive_chef") );
				
				rse = st.executeQuery("select * from eatery_eatery_tag where eatery_id="+eid);
				
				List<String> tagIds = new ArrayList<>();
				while(rse.next()){
					int tagid = rse.getInt("tag_id");
					tagIds.add(""+tagid);
				}
				if (tagIds.size() ==0) continue;
				String ids = String.join(",", tagIds);
				
				rst = st1.executeQuery("select * from eatery_tag where id in ("+ids+")");
				
				List<EateryTag> listOfTags = new ArrayList<>();
				
				
			}

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
