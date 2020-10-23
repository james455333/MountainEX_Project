package mountain.mountainList.dao.impl;

import java.util.List;


import mountain.mountainList.model.NationalPark;
import mountain.mountainList.model.RouteBasic;

public interface RouteBasicDAO {
	
	public RouteBasic insert(RouteBasic rBBean) ;
	
	public RouteBasic select(int rBID);
	
	public List<RouteBasic> selectAll();
	
	public boolean delete(int rBID);
	
	public RouteBasic update(RouteBasic rBBean);
	
}
