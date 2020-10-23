package mountain.mountainList.service;

import java.util.List;

import org.hibernate.Session;

<<<<<<< HEAD
import mountain.mountainList.dao.RouteSummaryDAO;
=======
import mountain.mountainList.dao.RotueSummaryDAOImp;
import mountain.mountainList.dao.RouteSummaryHibernateDAO;
>>>>>>> Merge_Branch
import mountain.mountainList.model.RouteSummary;

public class RouteSummaryService {
	
	private Session session;
	
	public RouteSummaryService(Session session) {
		this.session = session;
	}
	
	public List<RouteSummary> selectAll(){
<<<<<<< HEAD
		RouteSummaryDAO routeSummaryDAO = new RouteSummaryDAO(session);
	
=======
		RotueSummaryDAOImp routeSummaryDAO = new RouteSummaryHibernateDAO(session);
		
>>>>>>> Merge_Branch
		return routeSummaryDAO.selectAll();
	}

}
