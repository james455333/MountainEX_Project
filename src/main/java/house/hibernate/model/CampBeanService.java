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

	@Override
	public List<CampBean> selectCity(String city) {
		return cDao.selectCity(city);
	}
	

	@Override
	public List<CampBean> selectCampTown(String camptown) {
		return cDao.selectCampTown(camptown);
	}


	@Override
	public List<CampBean> selectCampName(String campname) {
		return cDao.selectCampName(campname);
	}


	@Override
	public CampBean insertCamp(CampBean bean) {
		return cDao.insertCamp(bean);
	}



	@Override
	public CampBean deleteCamp(int campid) {
		return cDao.deleteCamp(campid);
	}


	@Override
	public CampBean update(CampBean cBean) {
		return cDao.update(cBean);
	}


	


	


	


	


	

	



	

	
	

	

	

}
