package mountain.mountainList.service;

import java.util.List;

import org.hibernate.Session;


import mountain.mountainList.dao.RotueSummaryDAOImp;
import mountain.mountainList.dao.RouteSummaryHibernateDAO;

import mountain.mountainList.model.RouteSummary;

public class RouteSummaryService {
	
	private Session session;
	
	public RouteSummaryService(Session session) {
		this.session = session;
	}
	
	public List<RouteSummary> selectAll(){

		RotueSummaryDAOImp routeSummaryDAO = new RouteSummaryHibernateDAO(session);
		

		return routeSummaryDAO.selectAll();
	}

}
