package house.hibernate.model;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;

public class CampBeanDAO {

		private Session session;
		
		public CampBeanDAO(Session session) {
			this.session = session;
		}
		
		public CampBean select(int campid) {
			return session.get(CampBean.class, campid);
		}
		
		public List<CampBean> selectAll() {
			Query<CampBean> query = session.createQuery("From CampBean",CampBean.class);
			List<CampBean> list = query.list();
			return list;
		}
		
	
}
