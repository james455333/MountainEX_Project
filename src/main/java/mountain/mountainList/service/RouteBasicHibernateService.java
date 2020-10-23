package mountain.mountainList.service;

import java.util.List;

import org.hibernate.Session;

import mountain.mountainList.dao.NationalParkHibernateDAO;
import mountain.mountainList.dao.RouteBasicHibernateDAO;
import mountain.mountainList.dao.RouteSummaryHibernateDAO;
import mountain.mountainList.dao.impl.NationalParkDAO;
import mountain.mountainList.dao.impl.RouteBasicDAO;
import mountain.mountainList.model.NationalPark;
import mountain.mountainList.model.RouteBasic;
import mountain.mountainList.service.impl.NationalParkService;
import mountain.mountainList.service.impl.RouteBasicService;

public class RouteBasicHibernateService implements RouteBasicService {
	
	private RouteBasicDAO rBHibDAO;
	
	public RouteBasicHibernateService(Session session) {
	}
	
	@Override
	public RouteBasic insert(RouteBasic rBBean) {
		return rBHibDAO.insert(rBBean);
	}

	@Override
	public RouteBasic select(int rBid) {
		return rBHibDAO.select(rBid);
	}

	@Override
	public List<RouteBasic> selectAll() {
		return rBHibDAO.selectAll();
	}

	@Override
	public boolean delete(int rBid) {
		return rBHibDAO.delete(rBid);
	}

	@Override
	public RouteBasic update(RouteBasic rBBean) {
		return rBHibDAO.update(rBBean);
	}

}
