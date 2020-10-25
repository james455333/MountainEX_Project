package member.login.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "member")
public class MemberBean {
	
	private String memberId;
	private String password;
	private String name;
	private String address;
	private String email;
	private String tel;
	private String exp;
	private int groupId;
	private double totalAmt;
	private double unpaid_amount;
	private Blob memberImage;
	
	
	@Id @Column (name = "MEMBERID")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
	@Column (name = "PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Column (name = "NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Column (name = "ADDRESS")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Column (name = "EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Column (name = "TEL")
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	@Column (name = "EXP")
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	
	
	@Column (name = "GROUPID")
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	
	@Column (name = "TOTALAMT")
	public double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	
	@Column (name = "UNPAID_AMOUNT")
	public double getUnpaid_amount() {
		return unpaid_amount;
	}
	public void setUnpaid_amount(double unpaid_amount) {
		this.unpaid_amount = unpaid_amount;
	}
	
	@Column (name = "MEMBERIMAGE")
	public Blob getMemberImage() {
		return memberImage;
	}
	public void setMemberImage(Blob memberImage) {
		this.memberImage = memberImage;
	}
	
	
	
	public MemberBean() {
		
	}
	
	public MemberBean(String memberId, String password, String name, String address, 
			String email, String tel, String exp, int groupId) {
		
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.address = address;
		this.email = email;
		this.tel = tel;
		this.exp = exp;
		this.groupId = groupId;
	}
	
	
	
//	private String email;
//	private String pwd;
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getPwd() {
//		return pwd;
//	}
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}
	
	

}
