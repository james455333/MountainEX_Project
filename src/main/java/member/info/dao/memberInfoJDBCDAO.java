package member.info.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.MBeanAttributeInfo;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.query.Query;

import member.login.model.MemberBean;


public class memberInfoJDBCDAO implements memberInfoDAO{
	
	private Session session;
	
	public memberInfoJDBCDAO(Session session) {
		this.session = session;
	}
	

	//登入後展示會員資料
	@Override
	public List<MemberBean> listMbInfo() {
		
		Query<MemberBean> query = session.createQuery("From MemberBean", MemberBean.class);
		List<MemberBean> list = query.list();
		
		return list;
		
		
//		try (Connection connection = ds.getConnection();
//			 PreparedStatement pstmt = connection.prepareStatement("select * from member");
//			 ResultSet rs = pstmt.executeQuery();
//		){
//			
//		
//			while (rs.next()) {
//				MemberBean mb = new MemberBean();
//				mb.setMemberId(rs.getString("memberId"));
//				mb.setPassword(rs.getString("password"));
//				mb.setName(rs.getString("name"));
//				mb.setAddress(rs.getString("address"));
//				mb.setEmail(rs.getString("email"));
//				mb.setTel(rs.getString("tel"));
//				mb.setGroupId(rs.getInt("groupId"));
//				mb.setTotalAmt(rs.getDouble("totalamt"));
//				mb.setUnpaid_amount(rs.getDouble("unpaid_amount"));
//				
//				list.add(mb);
//
//			}
//		
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
	}

	
	
	//修改會員資料
	@Override
	public void updateData(MemberBean listUpdate) {
		MemberBean result = session.get(MemberBean.class, listUpdate.getMemberId());
		if(result != null) {
			result.setPassword(listUpdate.getPassword());
			result.setName(listUpdate.getName());
			result.setAddress(listUpdate.getAddress());
			result.setEmail(listUpdate.getEmail());
			result.setTel(listUpdate.getTel());
			result.setExp(listUpdate.getExp());
		}


	

	
	
	
	
		
		
		
		
		
		
//		try (Connection connection = ds.getConnection();
//			 PreparedStatement pstmt = connection.prepareStatement("update member set password = ?, name = ?, address = ?, email = ?, tel = ?, exp = ? where memberId = ?");
//				){
//			
//			pstmt.setString(1, listUpdate.getPassword());
//			pstmt.setString(2, listUpdate.getName());
//			pstmt.setString(3, listUpdate.getAddress());
//			pstmt.setString(4, listUpdate.getEmail());
//			pstmt.setString(5, listUpdate.getTel());
//			pstmt.setString(6, listUpdate.getExp());
//			pstmt.setString(7, listUpdate.getMemberId());
//			
//			pstmt.executeUpdate();
//			pstmt.clearParameters();
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
	}

	
	
	
	
	
	

}
