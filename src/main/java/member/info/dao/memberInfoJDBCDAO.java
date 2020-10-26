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
	public MemberBean updateData(int memberId, MemberBean mb) {
		MemberBean result = session.get(MemberBean.class, memberId);
		if(result != null) {
			result.setPassword(mb.getPassword());
			result.setName(mb.getName());
			result.setAddress(mb.getAddress());
			result.setEmail(mb.getEmail());
			result.setTel(mb.getTel());
			result.setExp(mb.getExp());
		}
		return result;
	}


	


	


	


	
	

	
	
	
	

	
	
	
	
	
	

}
