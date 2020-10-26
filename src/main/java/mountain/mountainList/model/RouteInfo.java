package mountain.mountainList.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name = "route_info")
public class RouteInfo {
	
	@GenericGenerator( name = "rbidG1", strategy = "foreign", parameters = @Parameter( name = "property", value = "route_basic"))
	@Id
	@Column( name = "ROUTE_BASIC_ID")
	@GeneratedValue(generator = "rbidG1")
	private int rbPK;
	
	@Column( name = "NAME")
	private String name;
	
	@Column( name = "DESCRIPTION")
	private Blob description;
	@Column( name = "ADVICE")
	private Blob advice;
	@Column( name = "TRAFFIC")
	private Blob traffic;
	@Column( name = "IMG_URL")
	private Blob imgUrl;
	
	@OneToOne( fetch = FetchType.LAZY )
	@PrimaryKeyJoinColumn
	private RouteBasic route_basic;
	
	
	public RouteBasic getRoute_basic() {
		return route_basic;
	}
	public void setRoute_basic(RouteBasic route_basic) {
		this.route_basic = route_basic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Blob getDescription() {
		return description;
	}
	public void setDescription(Blob description) {
		this.description = description;
	}
	public Blob getTraffic() {
		return traffic;
	}
	public void setTraffic(Blob traffic) {
		this.traffic = traffic;
	}
	public Blob getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(Blob imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Blob getAdvice() {
		return advice;
	}
	public void setAdvice(Blob advice) {
		this.advice = advice;
	}

	public int getRbPK() {
		return rbPK;
	}
	public void setRbPK(int rbPK) {
		this.rbPK = rbPK;
	}

}
