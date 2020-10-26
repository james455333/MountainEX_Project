package house.hibernate.model;

import java.util.List;

public interface ICampBeanService {
	
	public CampBean select(int campid);
	public List<CampBean> selectAll();
}
