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
		
		public List<CampBean> selectCity(String city){
			String originString = " From CampBean where city like '%"+ city+"%'";
			Query<CampBean> query = session.createQuery(originString,CampBean.class);					
			List<CampBean> list = query.list();
			
			return list;
		}
		
		public List<CampBean> selectCampTown(String camptown){
			String originString = " From CampBean where camptown like '%"+ camptown+"%'";
			Query<CampBean> query = session.createQuery(originString,CampBean.class);
			List<CampBean> list = query.list();
			return list;
			
		}
		
		public List<CampBean> selectCampName(String campname){
			String originString = " From CampBean where campname like '%"+ campname+"%'";
			Query<CampBean> query = session.createQuery(originString,CampBean.class);
			List<CampBean> list = query.list();
			return list;
			
		}
		
		public CampBean insertCamp(CampBean bean) {
			CampBean result = session.get(CampBean.class,bean.getCampid());
			
			if (result == null) {
				session.save(bean);
				return bean;
				
			}
			return null;
		}
		
		public CampBean update( CampBean cBean) {

			session.update(cBean);
			return cBean;
		}

		public CampBean deleteCamp(int campid) {
			CampBean cBean = session.get(CampBean.class, campid);
			
			if (cBean!=null) {
				session.delete(cBean);
				return cBean;
			}
			return cBean;
			
			
			
		}

		
		
			
		
		
		
	
}
