package mountain.mountainList.dao.impl;

import java.util.List;


import mountain.mountainList.model.NationalPark;
import mountain.mountainList.model.RouteInfo;

public interface RouteInfoDAO {
	
	public RouteInfo insert(RouteInfo rIBean) ;
	
	public RouteInfo select(int rbPK);
	
	public List<RouteInfo> selectAll();
	
	public boolean delete(int rbPK);
	
	public RouteInfo update(RouteInfo rIBean);
	
}
