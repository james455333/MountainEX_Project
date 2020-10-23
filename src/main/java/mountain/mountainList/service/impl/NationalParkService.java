package mountain.mountainList.service.impl;

import java.util.List;


import mountain.mountainList.model.NationalPark;

public interface NationalParkService {
	
	public NationalPark insert(NationalPark npBean) ;
	
	public NationalPark select(int npid);
	
	public List<NationalPark> selectAll();
	
	public boolean delete(int npid);
	
	public NationalPark update(NationalPark npBean);
	
}
