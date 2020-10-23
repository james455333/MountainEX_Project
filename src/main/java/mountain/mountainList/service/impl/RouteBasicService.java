package mountain.mountainList.service.impl;

import java.util.List;


import mountain.mountainList.model.NationalPark;
import mountain.mountainList.model.RouteBasic;

public interface RouteBasicService {
	
	public RouteBasic insert(RouteBasic rBBean) ;
	
	public RouteBasic select(int rBId);
	
	public List<RouteBasic> selectAll();
	
	public boolean delete(int rBId);
	
	public RouteBasic update(RouteBasic rBBean);
	
}
