package mountain.mountainList.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import mountain.mountainList.model.RouteSummary;

public class RouteSummaryDAO {
	
	private Session session;
	
	public RouteSummaryDAO(Session session) {
		this.session = session;
	}
	
	public RouteSummary select(String routeName) {
		return session.get(RouteSummary.class, routeName);
	}
	
	public List<RouteSummary> selectAll(){
		
		Query<RouteSummary> query = session.createQuery("From RouteSummary", RouteSummary.class);
		
		return query.list(); 
	}
	

}
