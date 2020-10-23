package mountain.mountainList.dao;

import java.util.List;

import mountain.mountainList.model.RouteSummary;

public interface RotueSummaryDAOImp {

	RouteSummary select(String routeName);

	List<RouteSummary> selectAll();

}