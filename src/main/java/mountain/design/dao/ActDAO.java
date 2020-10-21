package mountain.design.dao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dB.DataS;
import mountain.design.model.ActBean;

public class ActDAO {

	private int post_id;
	private String memberID;
	private String npName;
	private String peakName;
	private String actName;
	private int actPay;
	private String startDate;
	private String endDate;
	private String totalDay;
	private String regEndDate;
	private int regTopNum;
	private String actOther;
	private String postDate;

	public int newPostToReg(ActBean actBean, Connection connection) throws SQLException {
		int confirm = 0;
		connection.setAutoCommit(false);

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from activity_summary where member_member_id = '" + actBean.getMemberID()
				+ "' and act_name = '" + actBean.getActName() + "'");
		rs.next();
		int queryPostID = rs.getInt("post_id");
		int queryuRegNow = rs.getInt("reg_num");
		int queryRegTopNum = rs.getInt("reg_top_num");
		java.sql.Date queryRegEndDate = rs.getDate("reg_end_date");

		PreparedStatement pStmt = connection
				.prepareStatement("insert into activity_reg(post_id,reg_now,reg_top,reg_end_date) VALUES(?,?,?,?)");

		pStmt.setInt(1, queryPostID);
		pStmt.setInt(2, queryuRegNow);
		pStmt.setInt(3, queryRegTopNum);
		pStmt.setDate(4, queryRegEndDate);

		confirm = pStmt.executeUpdate();
		pStmt.clearParameters();
		return confirm;

	}

	public int newPost(ActBean actBean, Connection connection) throws SQLException {

		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"insert into activity_summary values(hr.SEQUENCE_ACTIVITY_SUMMARY.NEXTVAL,?,?,?,?,?,to_date(?,'yyyy-MM-dd'),to_date(?,'yyyy-MM-dd'),?,to_date(?,'yyyy-MM-dd'),?,?,sysdate,0,?,?,?,?)");

			connection.setAutoCommit(false);
			pstmt.setString(1, actBean.getMemberID());
			pstmt.setString(2, actBean.getNpName());
			pstmt.setString(3, actBean.getPeakName());
			pstmt.setString(4, actBean.getActName());
			pstmt.setInt(5, actBean.getActPay());
			pstmt.setString(6, actBean.getStartDate());
			pstmt.setString(7, actBean.getEndDate());
			pstmt.setString(8, actBean.getTotalDay());
			pstmt.setString(9, actBean.getRegEndDate());
			pstmt.setInt(10, actBean.getRegTopNum());
			if (actBean.getActOther() == null) {
				actBean.setActOther("");
			}
			byte[] bytes = actBean.getActOther().getBytes("UTF-8");
			try (InputStream is = new ByteArrayInputStream(bytes);) {
				pstmt.setBlob(11, is);
			} catch (IOException e) {
				connection.rollback();
			}

			pstmt.setString(12, actBean.getEmail());
			pstmt.setString(13, actBean.getMemberName());
			pstmt.setString(14, actBean.getMemberEXP());
			pstmt.setString(15, actBean.getNeakName());

			int eU = pstmt.executeUpdate();
			pstmt.clearParameters();

			return eU;

		} catch (UnsupportedEncodingException e) {
			connection.rollback();
			e.printStackTrace();
		}
		return 0;

	}

	public List<ActBean> queryPost() throws SQLException {
		DataS dataS = new DataS();
		dataS.setUsername("hr");
		dataS.setUserPassword("hr");
		DataSource datasoure = dataS.getDatasoure();
		List<ActBean> actBeans = new ArrayList<ActBean>();

		try (Connection connection = datasoure.getConnection();) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from activity_summary");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while (rs.next()) {
				ActBean actBean = new ActBean();

				actBean.setMemberID(rs.getString("MEMBER_MEMBER_ID"));
				actBean.setNpName(rs.getString("NATIONAL_PARK_NAME"));
				actBean.setPeakName(rs.getString("ROUTE_SUMMARY_NAME"));
				actBean.setActName(rs.getString("ACT_NAME"));
				actBean.setActPay(rs.getInt("ACT_PAY"));
				java.sql.Date sqlSD = rs.getDate("START_DATE");
				String pSD = sdf.format(sqlSD);
				actBean.setStartDate(pSD);
				java.sql.Date sqlED = rs.getDate("END_DATE");
				String pED = sdf.format(sqlED);
				actBean.setEndDate(pED);
				actBean.setTotalDay(rs.getString("TOTAL_DAY"));
				actBean.setRegEndDate(rs.getString("REG_END_DATE"));
				actBean.setRegTopNum(rs.getInt("REG_TOP_NUM"));
				actBean.setRegNum(rs.getInt("REG_NUM"));
				Blob blob = rs.getBlob("ACT_OTHER");
				try (InputStream is = blob.getBinaryStream(); InputStreamReader isr = new InputStreamReader(is);) {
					char[] chars = new char[1024];
					int buffer;
					StringBuffer result = new StringBuffer();
					while ((buffer = isr.read(chars)) != -1) {
						result.append(chars, 0, buffer);
					}
					String rsString = result.toString();
					actBean.setActOther(rsString);
				} catch (IOException e) {
				} catch (NullPointerException e) {
					actBean.setActOther("");
				}
				java.sql.Date sqlPD = rs.getDate("POST_DATE");
				String pPD = sdf.format(sqlPD);
				actBean.setPostDate(pPD);
				actBean.setPostID(rs.getInt("POST_ID"));
				actBean.setMemberName(rs.getString("member_name"));
				actBean.setEmail(rs.getString("member_email"));
				actBean.setMemberEXP(rs.getString("MEMBER_EXP"));
				try {
					actBean.setNeakName(rs.getString("neakname"));
				} catch (NullPointerException e) {
					actBean.setNeakName("");
				}
				actBeans.add(actBean);
			}
			return actBeans;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actBeans;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
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

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public int deletePost(String postID, Connection connection) throws SQLException {
		connection.setAutoCommit(false);
		Statement stmt = connection.createStatement();
		int result = stmt.executeUpdate("delete from activity_summary where post_id = " +postID);
		return result;
	}

}
