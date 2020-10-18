package member.register.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import member.login.model.MemberBean;

public class memberJDBCDAO implements memberDAO{
	
	private Connection connection;
	private static DataSource ds = null;
	
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/xe");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertData(MemberBean mb) {
		try {
			connection = ds.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("insert into member("
					+ "memberid, password, name, address, email, tel, exp, groupid)"
					+ "values(?, ?, ?, ?, ?, ?, ?, ?)");
			
			pstmt.setString(1, mb.getMemberId());
			pstmt.setString(2, mb.getPassword());
			pstmt.setString(3, mb.getName());
			pstmt.setString(4, mb.getAddress());
			pstmt.setString(5, mb.getEmail());
			pstmt.setString(6, mb.getTel());
			pstmt.setString(7, mb.getExp());
			pstmt.setInt(8, mb.getGroupId());
			
			ResultSet rs = pstmt.executeQuery();
			pstmt.clearParameters();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//檢查登入密碼
	@Override
	public MemberBean checkIdPassword(String userId, String password) {
		
		MemberBean mb = null;
		try (
			Connection connection = ds.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("select * from member where memberId = ? and password = ?")
		){
			
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					mb = new MemberBean();
					mb.setMemberId(rs.getString("memberId"));
					mb.setPassword(rs.getString("password"));
					mb.setName(rs.getString("name"));
					mb.setAddress(rs.getString("address"));
					mb.setEmail(rs.getString("email"));
					mb.setTel(rs.getString("tel"));
					mb.setExp(rs.getString("exp"));
					mb.setGroupId(rs.getInt("groupId"));
					mb.setTotalAmt(rs.getDouble("totalamt"));
					mb.setUnpaid_amount(rs.getDouble("unpaid_amount"));
					mb.setMemberImage(rs.getBlob("memberImage"));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("memberJDBCDAO類別 #checkIdPassword()發生SQL例外：" + e.getMessage());
		}
		return mb;
	}
	
	
	
	

	
	


}
