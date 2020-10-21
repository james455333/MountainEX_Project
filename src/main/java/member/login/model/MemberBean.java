package member.login.model;

import java.sql.Blob;

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
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public double getUnpaid_amount() {
		return unpaid_amount;
	}
	public void setUnpaid_amount(double unpaid_amount) {
		this.unpaid_amount = unpaid_amount;
	}
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
