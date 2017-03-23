import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infotel.gg.dao.jdbc.SqlUtils;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.Eatery;
import com.infotel.gg.model.EateryTag;



public class MainMySQL {

	public static void main(String[] args) throws ModelException {

		ResultSet rs, rse, rst;
		Statement st, ste, stt;
		Connection cx;
		
		Map<Integer,EateryTag> tagsManagers = new HashMap<>();
		
		try {
			cx = SqlUtils.getConnection();

			// Prepare une demande
			st = cx.createStatement();

			// Execute qui retourne un ResultSet
			rs = st.executeQuery("SELECT * FROM eatery where id BETWEEN 1 AND 200");

			while (rs.next()) {
				int eid = rs.getInt("id");
				Eatery eatery = new Eatery(eid, rs.getString("name"), rs.getString("description"),
						rs.getString("executive_chef"));
				
				// ETAPE 2 eatery_eatery_tag
				ste = cx.createStatement();
				rse = ste.executeQuery("SELECT * FROM eatery_eatery_tag where eatery_id=" + eid);

				// Y a t il des enregistrements dans eatery_eatery_tag
				// on construit une list de tag_id
				List<String> tagIds = new ArrayList<>();
				while (rse.next()) {
					int tagid = rse.getInt("tag_id");
					tagIds.add("" + tagid);
				}

				if (tagIds.size() == 0) {
					System.out.println(eatery);
					continue;
				}

				// PRE ETAPE 3 - Construire une string de IDS
				String ids = String.join(",", tagIds);

				// ETAPE 3 : Interroger eatery_tag "1,2,3,8,9"
				stt = cx.createStatement();
				rst = stt.executeQuery("SELECT * FROM eatery_tag where id in (" + ids + ")");

				List<EateryTag> listOfTags = new ArrayList<>();
				while (rst.next()) {
					int tid = rst.getInt("id");
					EateryTag eTag = null;
					
					if(tagsManagers.containsKey(tid)){
						eTag = tagsManagers.get(tid);
					}else{
						eTag =  new EateryTag(rst.getInt("id"), rst.getString("name"));
						tagsManagers.put(tid, eTag);
					}
					
					listOfTags.add(eTag);
				}
				
				eatery.setEateryTags(listOfTags);
				System.out.println(eatery);
				

			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
