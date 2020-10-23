package mountain.mountainList.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "route_basic")
public class RouteBasic {
	@Id
	@Column(name = "ID")
	private int routeid;
	
	@GenericGenerator( name = "npIdG", strategy = "foregin", parameters = @Parameter( name="props", value="national_park"))
	@Column(name = "NATIONAL_PARK_ID")
	@GeneratedValue(generator = "npIdG")
	private int npid;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private NationalPark npBean;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "route_basic", cascade = CascadeType.ALL)
	private RouteInfo routeInfo;
	
	public int getRouteid() {
		return routeid;
	}
	public void setRouteid(int routeid) {
		this.routeid = routeid;
	}
	public int getNpid() {
		return npid;
	}
	public void setNpid(int npid) {
		this.npid = npid;
	}
	public NationalPark getNpBean() {
		return npBean;
	}
	public void setNpBean(NationalPark npBean) {
		this.npBean = npBean;
	}
	public RouteInfo getRouteInfo() {
		return routeInfo;
	}
	public void setRouteInfo(RouteInfo routeInfo) {
		this.routeInfo = routeInfo;
	}
	
	
	
}
