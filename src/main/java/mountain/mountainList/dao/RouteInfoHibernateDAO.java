package mountain.mountainList.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import mountain.mountainList.dao.impl.RouteInfoDAO;
import mountain.mountainList.model.RouteInfo;

public class RouteInfoHibernateDAO implements RouteInfoDAO {
	
	private Session session;
	
	public RouteInfoHibernateDAO(Session session) {
		this.session = session;
	}
		
	@Override
	public RouteInfo insert(RouteInfo rIBean) {
		
		RouteInfo result = session.get(RouteInfo.class, rIBean.getRbPK());
		
		if(result == null) {
			
			session.save(rIBean);
			
			return rIBean;
		}
		return null;
	}

	@Override
	public RouteInfo select(int rbPK) {
		return session.get(RouteInfo.class, rbPK);
	}

	@Override
	public List<RouteInfo> selectAll() {
		
		Query<RouteInfo> query = session.createQuery("From RouteInfo", RouteInfo.class);
		List<RouteInfo> rIBeans = query.list();
		
		return rIBeans;
	}

	@Override
	public boolean delete(int rBPK) {
		
		RouteInfo result = session.get(RouteInfo.class, rBPK);
		
		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}

	@Override
	public RouteInfo update(RouteInfo rIBean) {
		
		RouteInfo result = session.get(RouteInfo.class, rIBean.getRbPK());
		
		if(result != null) {
			session.update(rIBean); 
			return rIBean;
		}
		
		return null;
	}

}
