package house.hibernate.model;

public class CampBean {

	private int campid;
	private String city;
	private String camptown;
	private String campname;
	private String campdesc;
	
	public CampBean() {
		
	}
	
	public CampBean(int campid, String city, String camptown, String campname, String campdesc) {
		this.campid = campid;
		this.city = city;
		this.camptown = camptown;
		this.campname = campname;
		this.campdesc = campdesc;
		
	}
	
	public int getCampid() {
		return campid;
	}

	public void setCampid(int campid) {
		this.campid = campid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCamptown() {
		return camptown;
	}

	public void setCamptown(String camptown) {
		this.camptown = camptown;
	}

	public String getCampname() {
		return campname;
	}

	public void setCampname(String campname) {
		this.campname = campname;
	}

	public String getCampdesc() {
		return campdesc;
	}

	public void setCampdesc(String campdesc) {
		this.campdesc = campdesc;
	}

}
