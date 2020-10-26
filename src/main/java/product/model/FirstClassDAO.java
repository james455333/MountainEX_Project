package product.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import tw.sshong.hibernateproject.model.HouseBean;

public class FirstClassDAO {

	private Session session;
	
	public FirstClassDAO(Session session) {
		this.session =session;
	}
	
	//新增FirstClass
	public FirstClass insert(FirstClass bean) {
		
		FirstClass result = session.get(FirstClass.class, bean.getId());
		
		if (result==null) {
			session.save(bean);
			return bean;
		}
		return null;
	}
	//查詢FirstClass
		public FirstClass select(int firstClassId) {
			return session.get(FirstClass.class, firstClassId);
		}
		//
		public List<FirstClass> selectAll(){
			Query<FirstClass> query = session.createQuery("From FirstClass", FirstClass.class);
			List<FirstClass> list = query.list();
			return list;
		}
		//修改
		public HouseBean update(int houseid,String houseName) {
			HouseBean result = session.get(HouseBean.class, houseid);
			if (result!=null) {
				result.setHousename(houseName);
			}
			return result;
		}
		//刪除
		public boolean delete(int houseid) {
			HouseBean result = session.get(HouseBean.class, houseid);
			if (result!= null) {
				session.delete(result);
				return true;
			}
			return false;
		}
	
	
	
}
