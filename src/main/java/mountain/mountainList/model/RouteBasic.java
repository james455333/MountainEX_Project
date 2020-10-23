package mountain.mountainList.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "route_baisc")
public class RouteBasic {
	@Id
	@Column(name = "ID")
	private int routeid;
	
//	@Column(name = "NATIONAL_PARK_ID")
//	private int npid;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NATIONAL_PARK_ID")
	private NationalPark npBean;
	
	public int getRouteid() {
		return routeid;
	}
	public void setRouteid(int routeid) {
		this.routeid = routeid;
	}
//	public int getNpid() {
//		return npid;
//	}
//	public void setNpid(int npid) {
//		this.npid = npid;
//	}
	public NationalPark getNpBean() {
		return npBean;
	}
	public void setNpBean(NationalPark npBean) {
		this.npBean = npBean;
	}
	
	
	
}
