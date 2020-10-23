package mountain.mountainList.service;

import java.util.List;

import org.hibernate.Session;

import mountain.mountainList.dao.NationalParkHibernateDAO;
import mountain.mountainList.dao.impl.NationalParkDAO;
import mountain.mountainList.model.NationalPark;
import mountain.mountainList.service.impl.NationalParkService;

public class NationalParkHibernateService implements NationalParkService {
	
	private NationalParkDAO npHibDAO;
	
	public NationalParkHibernateService(Session session) {
		npHibDAO = new NationalParkHibernateDAO(session);
		
	}
	
	@Override
	public NationalPark insert(NationalPark npBean) {
		return npHibDAO.insert(npBean);
	}

	@Override
	public NationalPark select(int npid) {
		return npHibDAO.select(npid);
	}

	@Override
	public List<NationalPark> selectAll() {
		return npHibDAO.selectAll();
	}

	@Override
	public boolean delete(int npid) {
		return npHibDAO.delete(npid);
	}

	@Override
	public NationalPark update(NationalPark npBean) {
		return npHibDAO.update(npBean);
	}

}
