package house.hibernate.model;

import java.util.List;

import org.hibernate.Session;

public class CampBeanService implements ICampBeanService {
	
	private CampBeanDAO cDao;
	public  CampBeanService(Session session) {
		cDao = new CampBeanDAO(session);
	}
	
	
	@Override
	public CampBean select(int campid) {
		return cDao.select(campid);
	}

	@Override
	public List<CampBean> selectAll() {
		return cDao.selectAll();
	}

}
