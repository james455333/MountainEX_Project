package mountain.mountainList.service;

import java.util.List;

import org.hibernate.Session;

import mountain.mountainList.dao.NationalParkHibernateDAO;
import mountain.mountainList.dao.RouteBasicHibernateDAO;
import mountain.mountainList.dao.RouteInfoHibernateDAO;
import mountain.mountainList.dao.RouteSummaryHibernateDAO;
import mountain.mountainList.dao.impl.NationalParkDAO;
import mountain.mountainList.dao.impl.RouteBasicDAO;
import mountain.mountainList.dao.impl.RouteInfoDAO;
import mountain.mountainList.model.NationalPark;
import mountain.mountainList.model.RouteBasic;
import mountain.mountainList.model.RouteInfo;
import mountain.mountainList.service.impl.NationalParkService;
import mountain.mountainList.service.impl.RouteBasicService;
import mountain.mountainList.service.impl.RouteInfoService;

public class RouteInfoHibernateService implements RouteInfoService {
	
	private RouteInfoDAO rIHibDAO;
	
	public RouteInfoHibernateService(Session session) {
		rIHibDAO = new RouteInfoHibernateDAO(session);
	}
	
	@Override
	public RouteInfo insert(RouteInfo rIBean) {
		return rIHibDAO.insert(rIBean);
	}

	@Override
	public RouteInfo select(int rBPK) {
		return rIHibDAO.select(rBPK);
	}

	@Override
	public List<RouteInfo> selectAll() {
		return rIHibDAO.selectAll();
	}

	@Override
	public boolean delete(int rBPK) {
		return rIHibDAO.delete(rBPK);
	}

	@Override
	public RouteInfo update(RouteInfo rIBean) {
		return rIHibDAO.update(rIBean);
	}

}
