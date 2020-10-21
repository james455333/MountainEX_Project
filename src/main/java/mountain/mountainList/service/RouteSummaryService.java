package mountain.mountainList.service;

import java.util.List;

import org.hibernate.Session;

import mountain.mountainList.dao.RouteSummaryDAO;
import mountain.mountainList.model.RouteSummary;

public class RouteSummaryService {
	
	private Session session;
	
	public RouteSummaryService(Session session) {
		this.session = session;
	}
	
	public List<RouteSummary> selectAll(){
		RouteSummaryDAO routeSummaryDAO = new RouteSummaryDAO(session);
	
		return routeSummaryDAO.selectAll();
	}

}
