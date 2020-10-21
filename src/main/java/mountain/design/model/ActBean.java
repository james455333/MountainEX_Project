package mountain.design.model;

import java.io.Serializable;

public class ActBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int postID;
	private String memberID ;
	private String npName ; 
	private String peakName ;
	private String actName;
	private int actPay;
	private String startDate;
	private String endDate;
	private String totalDay;
	private String regEndDate;
	private int regNum;
	private int regTopNum;
	private String actOther;
	private String postDate ;
	private String email;
	private String memberName;
	private String memberEXP;
	private String neakName;
	
	public String getNeakName() {
		return neakName;
	}
	public void setNeakName(String neakName) {
		this.neakName = neakName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEXP() {
		return memberEXP;
	}
	public void setMemberEXP(String memberEXP) {
		this.memberEXP = memberEXP;
	}
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public int getRegNum() {
		return regNum;
	}
	public void setRegNum(int regNum) {
		this.regNum = regNum;
	}
	
	
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getNpName() {
		return npName;
	}
	public void setNpName(String npName) {
		this.npName = npName;
	}
	public String getPeakName() {
		return peakName;
	}
	public void setPeakName(String peakName) {
		this.peakName = peakName;
	}
	public String getActName() {
		return actName;
	}
	public void setActName(String actName) {
		this.actName = actName;
	}
	public int getActPay() {
		return actPay;
	}
	public void setActPay(int actPay) {
		this.actPay = actPay;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getTotalDay() {
		return totalDay;
	}
	public void setTotalDay(String totalDay) {
		this.totalDay = totalDay;
	}
	public String getRegEndDate() {
		return regEndDate;
	}
	public void setRegEndDate(String regEndDate) {
		this.regEndDate = regEndDate;
	}
	public int getRegTopNum() {
		return regTopNum;
	}
	public void setRegTopNum(int regTopNum) {
		this.regTopNum = regTopNum;
	}
	public String getActOther() {
		return actOther;
	}
	public void setActOther(String actOther) {
		this.actOther = actOther;
	}
	
}
