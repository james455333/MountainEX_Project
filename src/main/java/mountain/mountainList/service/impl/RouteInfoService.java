package mountain.mountainList.service.impl;

import java.util.List;


import mountain.mountainList.model.NationalPark;
import mountain.mountainList.model.RouteBasic;
import mountain.mountainList.model.RouteInfo;

public interface RouteInfoService {
	
	public RouteInfo insert(RouteInfo rIBean) ;
	
	public RouteInfo select(int rBPK);
	
	public List<RouteInfo> selectAll();
	
	public boolean delete(int rBPK);
	
	public RouteInfo update(RouteInfo rIBean);
	
}
