package mountain.mountainList.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "route_summary")
public class RouteSummary {
	@Id
	@Column(name = "NAME")
	private String name;
	@Column(name = "DESCRIPTION")
	private Blob description;
	@Column(name = "advice")
	private Blob advice;
	@Column(name = "traffic")
	private Blob traffic;
	@Column(name = "NATIONAL_PARK_NAME")
	private String npName;
	@Column(name = "IMG_URL")
	private Blob imgURL;
	
	
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
	public Blob getAdvice() {
		return advice;
	}
	public void setAdvice(Blob advice) {
		this.advice = advice;
	}
	public Blob getTraffic() {
		return traffic;
	}
	public void setTraffic(Blob traffic) {
		this.traffic = traffic;
	}
	public String getNpName() {
		return npName;
	}
	public void setNpName(String npName) {
		this.npName = npName;
	}
	public Blob getImgURL() {
		return imgURL;
	}
	public void setImgURL(Blob imgURL) {
		this.imgURL = imgURL;
	}
	
}
