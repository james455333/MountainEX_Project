package mountain.mountainList.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "national_park")
public class NationalPark {
	
	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@OneToOne(fetch = FetchType.LAZY , mappedBy = "national_park" , cascade = CascadeType.ALL)
	private RouteBasic routeBasic;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RouteBasic getRouteBasic() {
		return routeBasic;
	}
	public void setRouteBasic(RouteBasic routeBasic) {
		this.routeBasic = routeBasic;
	}
	

	
}
