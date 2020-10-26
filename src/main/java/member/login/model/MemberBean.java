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
	
	@Id @Column (name = "MEMBERID")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int memberId;
	
	@Column(name = "ACCOUNT")
	private String account;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "TEL")
	private String tel;
	
	@Column(name = "EXP")
	private String exp;
	
	@Column(name = "GROUPID")
	private int groupId;
	
	@Column(name = "TOTALAMT")
	private double totalAmt;
	
	@Column(name = "UNPAID_AMOUNT")
	private double unpaid_amount;
	
	@Column(name = "MEMBERIMAGE")
	private Blob memberImage;
	
	
	
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
	
	public MemberBean(int memberId, String account, String password, 
			String name, String address, String email, String tel, String exp 
			) {
		
		this.memberId = memberId;
		this.account = account;
		this.password = password;
		this.name = name;
		this.address = address;
		this.email = email;
		this.tel = tel;
		this.exp = exp;
		
	}
	
	
	
	
	
	

}
