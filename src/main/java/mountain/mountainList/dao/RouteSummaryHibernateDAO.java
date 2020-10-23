package mountain.mountainList.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import mountain.mountainList.model.RouteSummary;

public class RouteSummaryHibernateDAO implements RotueSummaryDAOImp {
	
	private Session session;
	
	public RouteSummaryHibernateDAO(Session session) {
		this.session = session;
	}
	
	@Override
	public RouteSummary select(String routeName) {
		return session.get(RouteSummary.class, routeName);
	}
	
	@Override
	public List<RouteSummary> selectAll(){
		
		Query<RouteSummary> query = session.createQuery("From RouteSummary", RouteSummary.class);
		
		return query.list(); 
	}
	

}
