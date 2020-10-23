package mountain.mountainList.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import mountain.mountainList.dao.impl.NationalParkDAO;
import mountain.mountainList.model.NationalPark;

public class NationalParkHibernateDAO implements NationalParkDAO {
	
	private Session session;
	
	public NationalParkHibernateDAO(Session session) {
		this.session = session;
	}
	
	@Override
	public NationalPark insert(NationalPark npBean) {
		
		NationalPark result = session.get(NationalPark.class, npBean.getId());
		
		if(result == null) {
			
			session.save(npBean);
			
			return npBean;
		}
		return null;
	}

	@Override
	public NationalPark select(int npid) {
		return session.get(NationalPark.class, npid);
	}

	@Override
	public List<NationalPark> selectAll() {
		
		Query<NationalPark> query = session.createQuery("From NationalPark", NationalPark.class);
		List<NationalPark> npBeans = query.list();
		
		return npBeans;
	}

	@Override
	public boolean delete(int npid) {
		
		NationalPark result = session.get(NationalPark.class, npid);
		
		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}

	@Override
	public NationalPark update(NationalPark npBean) {
		
		NationalPark result = session.get(NationalPark.class, npBean.getId());
		
		if(result != null) {
			session.update(npBean);
			return npBean;
		}
		
		return null;
	}

}
