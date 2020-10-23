package mountain.mountainList.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import mountain.mountainList.dao.impl.RouteBasicDAO;
import mountain.mountainList.model.RouteBasic;

public class RouteBasicHibernateDAO implements RouteBasicDAO {
	
	private Session session;
	
	public RouteBasicHibernateDAO(Session session) {
		this.session = session;
	}
		
	@Override
	public RouteBasic insert(RouteBasic rBBean) {
		
		RouteBasic result = session.get(RouteBasic.class, rBBean.getRouteid());
		
		if(result == null) {
			
			session.save(rBBean);
			
			return rBBean;
		}
		return null;
	}

	@Override
	public RouteBasic select(int rBid) {
		return session.get(RouteBasic.class, rBid);
	}

	@Override
	public List<RouteBasic> selectAll() {
		
		Query<RouteBasic> query = session.createQuery("From RouteBasic", RouteBasic.class);
		List<RouteBasic> rBBeans = query.list();
		
		return rBBeans;
	}

	@Override
	public boolean delete(int rBId) {
		
		RouteBasic result = session.get(RouteBasic.class, rBId);
		
		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}

	@Override
	public RouteBasic update(RouteBasic rBBean) {
		
		RouteBasic result = session.get(RouteBasic.class, rBBean.getRouteid());
		
		if(result != null) {
			session.update(rBBean); 
			return rBBean;
		}
		
		return null;
	}

}
